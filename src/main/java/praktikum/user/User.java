package praktikum.user;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String userEmail, String userPassword) {
        this.email = userEmail;
        this.password = userPassword;
    }

    public User(String userName, String userEmail, String userPassword) {
        this.name = userName;
        this.email = userEmail;
        this.password = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
