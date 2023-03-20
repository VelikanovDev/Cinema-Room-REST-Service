package cinemaApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Seat {
    private int row;
    private int column;
    @JsonIgnore
    private boolean taken;
    @JsonIgnore
    private Token token;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.token = new Token();
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.token = new Token();
    }
}
