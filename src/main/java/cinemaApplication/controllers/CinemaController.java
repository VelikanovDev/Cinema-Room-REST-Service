package cinemaApplication.controllers;

import cinemaApplication.entities.Cinema;
import cinemaApplication.entities.Seat;
import cinemaApplication.entities.Token;
import cinemaApplication.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public Cinema returnCinema() {
        return cinemaService.getCinema();
    }

    @PostMapping ("/purchase")
    ResponseEntity<?> purchaseTicket(@RequestBody Seat seat) {
        return cinemaService.purchaseTicket(seat);
    }

    @PostMapping("/return")
    ResponseEntity<?> returnTicket(@RequestBody Token token) {
        return cinemaService.returnTicket(token);
    }

    @PostMapping("/stats")
    ResponseEntity<?> getStats(@RequestParam(required = false) String password) {
        return  cinemaService.getStats(password);
    }
}
