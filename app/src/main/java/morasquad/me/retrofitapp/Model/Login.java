package morasquad.me.retrofitapp.Model;

/**
 * Created by Sandun Isuru Niraj on 3/4/2018.
 */

public class Login {

    private String message;
    private String name;
    private String email;

    public Login(String message, String name, String email) {
        this.message = message;
        this.name = name;
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
