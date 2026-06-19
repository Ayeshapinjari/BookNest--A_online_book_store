package Projects.OnlineBookStore.model;
public class User extends Person {

    private int id;
    private String password;
    private String role;

    public User() {
    }

    public User(int id, String name, String email, String password, String role) {
        super(name, email);
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", role='" + role + '\'' + '}';
    }
}