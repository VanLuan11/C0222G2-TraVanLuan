package model.model.employee;

public class User {
    private String userName;
    private String password;
    private int status;

    public User() {
    }

    public User(String userName, String password, int status) {
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
