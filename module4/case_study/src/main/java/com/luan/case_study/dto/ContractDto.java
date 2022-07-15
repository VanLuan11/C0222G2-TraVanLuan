package com.luan.case_study.dto;

import com.luan.case_study.model.contract.ContractDetail;
import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.model.employee.Employee;
import com.luan.case_study.model.facility.Facility;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;
@GroupSequence(value = {DtoOne.class, DtoTwo.class, ContractDto.class})
public class ContractDto {
    private Integer id;

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String startDate;

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String endDate;

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class)
    @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = ContractDto.class)
    private Double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private List<ContractDetail> contractDetailList;
    private Integer totalMoney;

    public ContractDto() {
    }

    public ContractDto(Integer id, @NotEmpty(message = "không được để trống", groups = DtoOne.class) String startDate, @NotEmpty(message = "không được để trống", groups = DtoOne.class) String endDate, @NotEmpty(message = "không được để trống", groups = DtoOne.class) @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class) @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = ContractDto.class) Double deposit, Customer customer, Employee employee, Facility facility, List<ContractDetail> contractDetailList, Integer totalMoney) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.contractDetailList = contractDetailList;
        this.totalMoney = totalMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}
