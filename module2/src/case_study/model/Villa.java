package case_study.model;

public class Villa extends Facility{
    private static final String COMMA = ",";
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

    public Villa(String codeService, String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType, String standardRoom, Integer poolArea, Integer numberOfFloors) {
        super(codeService, nameService, area, rentalCosts, maximumPerson, rentalType);
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
        return "Villa: " + super.toString() +
                "standardRoom: " + standardRoom +
                ", poolArea: " + poolArea +
                ", numberOfFloors: " + numberOfFloors;
    }
    public String convertLine(){
        return super.convertLine() + COMMA + this.standardRoom + COMMA + this.poolArea + COMMA + this.numberOfFloors;
    }
}
