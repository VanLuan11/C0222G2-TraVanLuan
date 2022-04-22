package case_study.model;

public abstract class Facility {
    private  Integer id;
    private String nameService;
    private Integer area;
    private Integer rentalCosts;
    private Integer maximumPerson;
    private String rentalType;
//   id,Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ.)

    public Facility() {
    }

    public Facility(Integer id, String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType) {
        this.id = id;
        this.nameService = nameService;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maximumPerson = maximumPerson;
        this.rentalType = rentalType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Integer rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(Integer maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility" +
                "id=" + id +
                ", nameService=" + nameService +
                ", area=" + area +
                ", rentalCosts=" + rentalCosts +
                ", maximumPerson=" + maximumPerson +
                ", rentalType=" + rentalType ;
    }
}
