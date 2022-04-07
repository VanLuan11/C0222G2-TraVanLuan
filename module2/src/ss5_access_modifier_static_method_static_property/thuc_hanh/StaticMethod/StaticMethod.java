package ss5_access_modifier_static_method_static_property.thuc_hanh.StaticMethod;

public class StaticMethod {
    private int rollno;
    private String name;
    private static String college = "BBDIT";
    StaticMethod(int r, String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        college = "ĐÀ NẴNG";
    }
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
