package ss5_access_modifier_static_method_static_property.thuc_hanh.StaticMethod;

public class MainStaticMethod {
    public static void main(String args[]) {
        StaticMethod.change();

        StaticMethod s1 = new StaticMethod(1, "Hoàn ngáo đá");
        StaticMethod s2 = new StaticMethod(2, "Tài tài năng");
        StaticMethod s3 = new StaticMethod(3, "Luận pro");

        s1.display();
        s2.display();
        s3.display();
    }
}
