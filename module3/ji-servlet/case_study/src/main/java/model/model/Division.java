package model.model;

public class Division {
    private int divisionId;
    private String divisionName;
    private int status;

    public Division() {
    }

    public Division(int divisionId, String divisionName, int status) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.status = status;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
