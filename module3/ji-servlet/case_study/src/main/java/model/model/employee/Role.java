package model.model.employee;

public class Role {
    private int RoleId;
    private String RoleName;
    private int status;

    public Role() {
    }

    public Role(int roleId, String roleName, int status) {
        RoleId = roleId;
        RoleName = roleName;
        this.status = status;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
