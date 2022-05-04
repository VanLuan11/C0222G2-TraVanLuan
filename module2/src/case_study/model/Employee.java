package case_study.model;

import java.util.Date;

public class Employee extends Person {
    private static final String COMMA = ",";
    private Integer idEmployee;
    private String level;
    private String location;
    private Integer wage;

    public Employee() {
    }

    public Employee(Integer idEmployee, String level, String location, Integer wage) {
        this.idEmployee = idEmployee;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String name, Date dayOfBirth, String gender, Integer idCard, String phone, String email, Integer idEmployee, String level, String location, Integer wage) {
        super(name, dayOfBirth, gender, idCard, phone, email);
        this.idEmployee = idEmployee;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee" + super.toString() +
                "idEmployee: " + idEmployee +
                ", level: " + level +
                ", location: " + location +
                ", wage: " + wage;
    }

    @Override
    public String convertLine() {
        return super.convertLine() + COMMA + this.idEmployee + COMMA + this.level + COMMA + this.location + COMMA + this.wage;
    }
}
