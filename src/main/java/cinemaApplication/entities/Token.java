package cinemaApplication.entities;

import java.util.UUID;

public class Token {
    private UUID token;

    public Token() {
        token = UUID.randomUUID();
    }

    public UUID getToken() {
        return token;
    }

    public String getStringValueOfToken() {
        return String.valueOf(token);
    }
}
