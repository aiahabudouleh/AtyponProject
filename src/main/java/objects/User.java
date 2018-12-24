package objects;

import java.util.Objects;

public class User {

    public String username;
    public String password;
    public String email;
    public String privilege;
    public int id;

    public User(String username, String password, String email, String privilege) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.privilege = privilege;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public int getId() {
        return id;
    }

    public User(String username, String password, String email, String privilege, int id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.privilege = privilege;
        this.id = id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", privilege='" + privilege + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPrivilege(), user.getPrivilege());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getEmail(), getPrivilege(), getId());
    }
}
