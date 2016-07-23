package in.app.myandroid.gatepassmngtsystem.model;

/**
 * Created by mukund on 27/6/16.
 */
public class LoginUser {
    private String uName;
    private String password;

    public LoginUser(String name, String password) {
        this.password = password;
        this.uName = name;
    }

    public String getPassword() {
        return password;
    }

    public LoginUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getuName() {
        return uName;
    }

    public LoginUser setuName(String uName) {
        this.uName = uName;
        return this;
    }
}
