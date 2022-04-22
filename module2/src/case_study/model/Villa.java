package case_study.model;

public class Villa extends Facility{
    private String standardRoom;
    private Integer poolArea;
    private  Integer numberOfFloors;
//    Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.

    public Villa() {
    }

    public Villa(String standardRoom, Integer poolArea, Integer numberOfFloors) {
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(Integer id, String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType, String standardRoom, Integer poolArea, Integer numberOfFloors) {
        super(id, nameService, area, rentalCosts, maximumPerson, rentalType);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Integer getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Integer poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa" + super.toString() +
                "standardRoom=" + standardRoom +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors;
    }
}