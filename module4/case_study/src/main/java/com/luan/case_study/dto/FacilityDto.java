package com.luan.case_study.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.model.facility.Facility;
import com.luan.case_study.model.facility.FacilityType;
import com.luan.case_study.model.facility.RentType;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@GroupSequence(value = {DtoOne.class, DtoTwo.class, FacilityDto.class})
public class FacilityDto {

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class)
    @Pattern(regexp = "^([A-Z][^A-Z\\s]+)(\\s[A-Z][^A-Z\\s]+)*$",
            message = "tên chữ cái đầu phải viết hoa", groups = FacilityDto.class)
    private String name;

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class)
    @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class)
    private Integer area;

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class)
    @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class)
    private Double cost;

    @NotEmpty(message = "không được để trống", groups = DtoOne.class)
    @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class)
    @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class)
    private Integer maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;

    @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class)
    private Integer numberOfFloors;
    private String facilityFree;
    private Integer status;
    private List<Contract> contract;

    public FacilityDto() {
    }

    public FacilityDto(@NotEmpty(message = "không được để trống", groups = DtoOne.class) @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class) @Pattern(regexp = "^([A-Z][^A-Z\\s]+)(\\s[A-Z][^A-Z\\s]+)*$",
            message = "tên chữ cái đầu phải viết hoa", groups = FacilityDto.class) String name, @NotEmpty(message = "không được để trống", groups = DtoOne.class) @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class) @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class) Integer area, @NotEmpty(message = "không được để trống", groups = DtoOne.class) @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class) @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class) Double cost, @NotEmpty(message = "không được để trống", groups = DtoOne.class) @NotBlank(message = "không đc để rỗng", groups = DtoTwo.class) @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class) Integer maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String descriptionOtherConvenience, Double poolArea, @Pattern(regexp = "^([0-9]+)*$", message = "không được nhập số âm", groups = FacilityDto.class) Integer numberOfFloors, String facilityFree, Integer status, List<Contract> contract) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.status = status;
        this.contract = contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}
