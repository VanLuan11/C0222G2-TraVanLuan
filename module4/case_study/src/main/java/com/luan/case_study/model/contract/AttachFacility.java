package com.luan.case_study.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    @Column(name = "facility_status")
    private String facilityStatus;
    private Integer status;

    @JsonBackReference
    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail> contractDetails;

    public AttachFacility() {
    }

    public AttachFacility(Integer id, String name, Double cost, String unit, String facilityStatus, Integer status, List<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.facilityStatus = facilityStatus;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFacilityStatus() {
        return facilityStatus;
    }

    public void setFacilityStatus(String facilityStatus) {
        this.facilityStatus = facilityStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
