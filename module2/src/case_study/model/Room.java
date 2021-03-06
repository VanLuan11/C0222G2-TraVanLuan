package case_study.model;

public class Room extends Facility{
    private static final String COMMA = ",";
    private String freeServiceincluded;
//    Dịch vụ miễn phí đi kèm.

    public Room(String codeService, String dichVu, Integer dienTich, Integer chiPhi, Integer soLuongNguoi, String kieuThue, String tieuChuan, String dichVufree) {
    }

    public Room(String freeServiceincluded) {
        this.freeServiceincluded = freeServiceincluded;
    }

    public Room(String codeService, String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType, String freeServiceincluded) {
        super(codeService, nameService, area, rentalCosts, maximumPerson, rentalType);
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
        return "Room: " + super.toString() +
                "freeServiceincluded: " + freeServiceincluded ;
    }
    public String convertLine(){
        return super.convertLine() + COMMA + this.freeServiceincluded;
    }
}
