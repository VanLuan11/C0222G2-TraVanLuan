package case_study.model;

public class Room extends Facility{
    private String freeServiceincluded;
//    Dịch vụ miễn phí đi kèm.

    public Room() {
    }

    public Room(String freeServiceincluded) {
        this.freeServiceincluded = freeServiceincluded;
    }

    public Room(String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType, String freeServiceincluded) {
        super(nameService, area, rentalCosts, maximumPerson, rentalType);
        this.freeServiceincluded = freeServiceincluded;
    }

    public String getFreeServiceincluded() {
        return freeServiceincluded;
    }

    public void setFreeServiceincluded(String freeServiceincluded) {
        this.freeServiceincluded = freeServiceincluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServiceincluded='" + freeServiceincluded + '\'' +
                '}';
    }
}
