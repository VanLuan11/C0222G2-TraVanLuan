package case_study.model;

public class House extends Facility{
    private String standardRoom;
    private Integer numberOfFloors;
//    Tiêu chuẩn phòng, Số tầng.

    public House() {
    }

    public House(String standardRoom, Integer numberOfFloors) {
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType, String standardRoom, Integer numberOfFloors) {
        super(nameService, area, rentalCosts, maximumPerson, rentalType);
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
