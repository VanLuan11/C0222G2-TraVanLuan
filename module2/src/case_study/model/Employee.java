package case_study.model;

public class Employee extends Person {
    // mã nhân viên
    private Integer idEmployee;
    private String level;
    private String location;
    private Integer wage;
    // mã nhân viên, trình độ, vị trí, lương

    public Employee() {
    }

    public Employee(Integer idEmployee, String level, String location, Integer wage) {
        this.idEmployee = idEmployee;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String name, String date, String gender, Integer idCard, String phone, String email, Integer idEmployee, String level, String location, Integer wage) {
        super(name, date, gender, idCard, phone, email);
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
        return "Employee{" + super.toString() +
                "idEmployee=" + idEmployee +
                ", level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", wage=" + wage +
                '}';
    }
}
