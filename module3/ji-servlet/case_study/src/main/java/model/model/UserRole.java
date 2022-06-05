package model.model;

public class UserRole {
    private Role role;
    private User user;
    private int status;

    public UserRole() {
    }

    public UserRole(Role role, User user, int status) {
        this.role = role;
        this.user = user;
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
