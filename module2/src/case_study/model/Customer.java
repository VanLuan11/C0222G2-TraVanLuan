package case_study.model;

import java.util.Date;

public class Customer extends Person {
    private static final String COMMA = ",";
    private Integer idCustomer;
    private String typeOfGuest;
    private String address;

    public Customer() {
    }

    public Customer(Integer idCustomer, String typeOfGuest, String address) {
        this.idCustomer = idCustomer;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public Customer(String name, Date date, String gender, Integer idCard, Integer phone, String email, Integer idCustomer, String typeOfGuest, String address) {
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
        return "Customer" + super.toString() +
                ", idCustomer: " + idCustomer +
                ", typeOfGuest: " + typeOfGuest +
                ", address: " + address;
    }

    @Override
    public String convertLine() {
        return super.convertLine() + COMMA + this.idCustomer + COMMA + this.typeOfGuest + COMMA + this.address;
    }
}
