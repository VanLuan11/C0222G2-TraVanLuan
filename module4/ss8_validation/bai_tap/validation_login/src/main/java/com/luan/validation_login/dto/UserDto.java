package com.luan.validation_login.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;


public class UserDto {

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45, message = "Nhập đúng ký tự")
    private String firstname;

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45, message = "Nhập đúng ký tự")
    private String lastname;

    @NotEmpty
    @NotBlank
    @NumberFormat
    private String phone;
    
    @Min(18)
    private Integer age;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(String firstname, String lastname, String phone, Integer age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
