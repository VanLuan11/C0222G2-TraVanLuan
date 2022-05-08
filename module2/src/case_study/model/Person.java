package case_study.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
    // Họ tên, Ngày sinh, Giới tính, Số CCCD, Số điện thoại, Email;
    private  static final String COMMA = ",";
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private String name;
    private Date dayOfBirth;
    private String gender;
    private Integer idCard;
    private Integer phone;
    private String email;

    public Person() {
    }

    public Person(String name, Date date, String gender, Integer idCard, Integer phone, String email) {
        this.name = name;
        this.dayOfBirth = date;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return dayOfBirth;
    }

    public void setDate(Date date) {
        this.dayOfBirth = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person: " +
                "name: " + name +
                ", date: " + dateFormat.format(dayOfBirth) +
                ", gender: " + gender +
                ", idCard: " + idCard +
                ", phone: " + phone +
                ", email: " + email;
    }

    public String convertLine(){
        return this.name + COMMA + dateFormat.format(this.dayOfBirth) + COMMA + this.gender + COMMA + this.idCard + COMMA + this.phone + COMMA +this.email;
    }
}
