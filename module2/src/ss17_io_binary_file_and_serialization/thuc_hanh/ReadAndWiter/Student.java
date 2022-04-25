package ss17_io_binary_file_and_serialization.thuc_hanh.ReadAndWiter;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String name;
    private String adderr;

    public Student() {
    }

    public Student(Integer id, String name, String adderr) {
        this.id = id;
        this.name = name;
        this.adderr = adderr;
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

    public String getAdderr() {
        return adderr;
    }

    public void setAdderr(String adderr) {
        this.adderr = adderr;
    }

    @Override
    public String toString() {
        return "student" +
                "id: " + id +
                ", name: " + name +
                ", adderr: " + adderr ;
    }
}
