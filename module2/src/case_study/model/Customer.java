package case_study.model;

public class Customer extends Person{
    // đối tượng khách hàng
    private Integer idCustomer;
    private String typeOfGuest;
    private String address;
// mã khách hàng, loại khách, địa chỉ
    public Customer() {
    }

    public Customer(Integer idCustomer, String typeOfGuest, String address) {
        this.idCustomer = idCustomer;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public Customer(String name, String date, String gender, Integer idCard, String phone, String email, Integer idCustomer, String typeOfGuest, String address) {
        super(name, date, gender, idCard, phone, email);
        this.idCustomer = idCustomer;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString()+
                "idCustomer=" + idCustomer +
                ", typeOfGuest='" + typeOfGuest + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
