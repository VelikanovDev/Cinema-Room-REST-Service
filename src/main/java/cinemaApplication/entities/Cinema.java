package cinemaApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats;
}
