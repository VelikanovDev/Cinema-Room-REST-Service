package cinemaApplication.repositories;

import cinemaApplication.entities.Seat;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaRepository {
    private static final int TOTAL_ROWS = 9;
    private static final int TOTAL_COLUMNS = 9;
    private static final int PREMIUM_SEAT_PRICE = 10;
    private static final int REGULAR_SEAT_PRICE = 8;
    private static final List<Seat> SEATS;
    private static final List<Seat> PURCHASED_TICKETS;

    static {
        SEATS = new ArrayList<>();
        PURCHASED_TICKETS = new ArrayList<>();
        for (int row = 1; row <= TOTAL_ROWS; row++) {
            for (int column = 1; column <= TOTAL_COLUMNS; column++) {
                SEATS.add(new Seat(
                                row, column,
                                row <= 4 ? PREMIUM_SEAT_PRICE : REGULAR_SEAT_PRICE
                        )
                );
            }
        }
    }

    public int getTotalRows() {
        return TOTAL_ROWS;
    }

    public int getTotalColumns() {
        return TOTAL_COLUMNS;
    }

    public List<Seat> getSeats() {
        return SEATS;
    }

    public void saveTicket(Seat seat) {
        PURCHASED_TICKETS.add(seat);
    }

    public void removeTicket(Seat seat) {
        PURCHASED_TICKETS.remove(seat);
    }

    public int getTotalIncome() {
        return PURCHASED_TICKETS
                .stream()
                .mapToInt(Seat::getPrice)
                .sum();
    }

    public int getNumberOfAvailableSeats() {
        return SEATS.size() - PURCHASED_TICKETS.size();
    }

    public int getNumberOfPurchasedTickets() {
        return PURCHASED_TICKETS.size();
    }

}
