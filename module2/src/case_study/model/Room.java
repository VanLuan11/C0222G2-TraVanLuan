package case_study.model;

public class Room extends Facility{
    private String freeServiceincluded;
//    Dịch vụ miễn phí đi kèm.

    public Room(Integer id, String dichVu, Integer dienTich, Integer chiPhi, Integer soLuongNguoi, String kieuThue, String tieuChuan, String dichVufree) {
    }

    public Room(String freeServiceincluded) {
        this.freeServiceincluded = freeServiceincluded;
    }

    public Room(Integer id, String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType, String freeServiceincluded) {
        super(id, nameService, area, rentalCosts, maximumPerson, rentalType);
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
        return "Room" + super.toString() +
                "freeServiceincluded=" + freeServiceincluded ;
    }
}
