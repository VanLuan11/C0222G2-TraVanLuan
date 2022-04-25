package charater_stream.model;



public class Student  {
    private Integer codeStudent;
    private String nameStudent;
    private String adderrStudent;
    private Integer point;

    public Student() {
    }

    public Student(Integer codeStudent, String nameStudent, String adderrStudent, Integer point) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.adderrStudent = adderrStudent;
        this.point = point;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getAdderrStudent() {
        return adderrStudent;
    }

    public void setAdderrStudent(String adderrStudent) {
        this.adderrStudent = adderrStudent;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student" +
                "codeStudent: " + codeStudent +
                ", nameStudent: " + nameStudent +
                ", adderrStudent: " + adderrStudent +
                ", point=" + point ;
    }
}
