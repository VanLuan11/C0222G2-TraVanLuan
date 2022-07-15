package com.luan.case_study.dto;

import com.luan.case_study.model.customer.CustomerType;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.*;

@GroupSequence(value = {CustomerDto.class, DtoOne.class, DtoTwo.class, DtoThree.class})
public class CustomerDto {

    private Integer id;
    private CustomerType customerType;

    @NotEmpty(message = "không được để trống",groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng",groups = DtoTwo.class)
    @Pattern(regexp = "^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$",
            message = "tên chữ cái đầu phải viết hoa", groups = DtoThree.class)
    private String name;

    @NotEmpty(message = "không được để trống",groups = DtoOne.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String birthday;

    private int gender;

    @NotEmpty(message = "không được để trống",groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng",groups = DtoTwo.class)
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$", message = "CMND phải từ 9 - 12 số", groups = DtoThree.class)
    private String idCard;

    @NotEmpty(message = "không được để trống",groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng",groups = DtoTwo.class)
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$",
            message = "nhập đúng định dạng 090 hoặc 091 hoặc (84)+90 hoặc (84)+91", groups = DtoThree.class)
    private String phone;

    @NotEmpty(message = "không được để trống",groups = DtoOne.class)
    @Email(message = "email phải đúng địng dạng vd: lethitai@gmail.com", groups = DtoThree.class)
    private String email;

    @NotEmpty(message = "không được để trống",groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng",groups = DtoTwo.class)
    private String address;


    public CustomerDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
