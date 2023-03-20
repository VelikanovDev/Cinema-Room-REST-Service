package cinemaApplication.services;

import cinemaApplication.entities.Cinema;
import cinemaApplication.entities.CinemaStats;
import cinemaApplication.entities.Seat;
import cinemaApplication.entities.Token;
import cinemaApplication.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CinemaService {
    private static final String PASSWORD = "super_secret";
    private final CinemaRepository cinemaRepo;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepo = cinemaRepository;
    }

    public Cinema getCinema() {
        return new Cinema(cinemaRepo.getTotalRows(), cinemaRepo.getTotalColumns(),
                cinemaRepo.getSeats());
    }

    public ResponseEntity<?> purchaseTicket(Seat seat) {
        if((seat.getRow() <= 0 || seat.getColumn() <= 0)
                || (seat.getRow() > cinemaRepo.getTotalRows())
                || (seat.getColumn() > cinemaRepo.getTotalColumns())) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"),
                    HttpStatus.BAD_REQUEST);
        }

        Seat tempSeat = cinemaRepo
                .getSeats()
                .stream()
                .filter(s -> s.getRow() == seat.getRow()
                        && s.getColumn() == seat.getColumn()
                        && !s.isTaken())
                .findFirst()
                .orElse(null);

        if (tempSeat != null) {
            tempSeat.setTaken(true);
            cinemaRepo.saveTicket(tempSeat);
            return new ResponseEntity<>(Map.of("token", tempSeat.getToken().getStringValueOfToken(),
                    "ticket", tempSeat), HttpStatus.OK);
        }
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"),
                    HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> returnTicket(Token token) {
        System.out.println(token.getStringValueOfToken() + " /// "
                + cinemaRepo.getSeats().get(0).getToken().getStringValueOfToken()
                + cinemaRepo.getSeats().get(0).getRow() + " - " + cinemaRepo.getSeats().get(0).getColumn());

        Seat tempSeat = cinemaRepo
                .getSeats()
                .stream()
                .filter(s -> s.getToken().getStringValueOfToken().equals(token.getStringValueOfToken()))
                .findFirst()
                .orElse(null);

        if(tempSeat == null) return new ResponseEntity<>(Map.of("error", "Wrong token!"),
                HttpStatus.BAD_REQUEST);

        cinemaRepo.removeTicket(tempSeat);
        return new ResponseEntity<>(Map.of("returned_ticket", tempSeat), HttpStatus.OK);
    }

    public ResponseEntity<?> getStats(String password) {
        if(password != null && checkPassword(password)) {
            return new ResponseEntity<>(new CinemaStats(cinemaRepo.getTotalIncome(),
                    cinemaRepo.getNumberOfAvailableSeats(), cinemaRepo.getNumberOfPurchasedTickets()), HttpStatus.OK);
        }

        return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
    }

    public boolean checkPassword(String password) {
        return password.equals(PASSWORD);
    }
}
