package cinemaApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CinemaStats {
    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;
}
