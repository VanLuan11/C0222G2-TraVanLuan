package ss4_class_and_oop_java.bai_tap.Fan;

import ss4_class_and_oop_java.bai_tap.Fan.Fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, "yellow", 10);
        Fan fan2 = new Fan(2, false, "blue", 10);
        System.out.println(fan1);
        System.out.print(fan2);
    }
}
