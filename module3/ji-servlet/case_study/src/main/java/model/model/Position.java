package model.model;

public class Position {
    private int positionId;
    private String positionName;
    private int status;

    public Position() {
    }

    public Position(int positionId, String positionName, int status) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.status = status;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
