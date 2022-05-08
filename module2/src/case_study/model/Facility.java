package case_study.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Facility {
    private static final String COMMA = ",";
    private String codeService;
    private String nameService;
    private Integer area;
    private Integer rentalCosts;
    private Integer maximumPerson;
    private String rentalType;

    public Facility() {
    }

    public Facility(String codeService, String nameService, Integer area, Integer rentalCosts, Integer maximumPerson, String rentalType) {
        this.codeService = codeService;
        this.nameService = nameService;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maximumPerson = maximumPerson;
        this.rentalType = rentalType;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
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
        return "Facility: " +
                " codeService: " + codeService +
                ", nameService: " + nameService +
                ", area: " + area +
                ", rentalCosts: " + rentalCosts +
                ", maximumPerson: " + maximumPerson +
                ", rentalType: " + rentalType ;
    }
    public String convertLine(){
        return this.codeService + COMMA + this.nameService + COMMA + this.area + COMMA + this.rentalCosts + COMMA + this.maximumPerson + COMMA + this.rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(nameService, facility.nameService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameService);
    }
}
