package model.model.employee;

public class UserRole {
    private int roleId;
    private String userName;
    private int status;

    public UserRole() {
    }

    public UserRole(int roleId, String userName, int status) {
        this.roleId = roleId;
        this.userName = userName;
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
