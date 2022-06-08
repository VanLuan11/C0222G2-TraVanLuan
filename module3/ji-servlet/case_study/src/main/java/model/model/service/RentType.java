package model.model.service;

public class RentType {
    private int RentTypeId;
    private String RentTypeName;
    private double RentTypeCost;
    private int status;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, double rentTypeCost, int status) {
        RentTypeId = rentTypeId;
        RentTypeName = rentTypeName;
        RentTypeCost = rentTypeCost;
        this.status = status;
    }

    public int getRentTypeId() {
        return RentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        RentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return RentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        RentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return RentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        RentTypeCost = rentTypeCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
