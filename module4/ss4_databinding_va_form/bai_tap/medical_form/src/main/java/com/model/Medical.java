package com.model;

public class Medical {
    private String name;
    private String birthday;
    private String gender;
    private String nation;
    private String idCard;
    private String vehicle;
    private String licensePlates;
    private Integer numberOfSeats;
    private String dateStart;
    private String dateEnd;
    private String moveInfo;

    public Medical() {
    }

    public Medical(String name, String birthday, String gender, String nation, String idCard, String vehicle, String licensePlates, Integer numberOfSeats, String dateStart, String dateEnd, String moveInfo) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.nation = nation;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.licensePlates = licensePlates;
        this.numberOfSeats = numberOfSeats;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.moveInfo = moveInfo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getMoveInfo() {
        return moveInfo;
    }

    public void setMoveInfo(String moveInfo) {
        this.moveInfo = moveInfo;
    }
}
