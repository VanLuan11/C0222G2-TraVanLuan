package ss4_class_and_oop_java.bai_tap;

public class Fan {
    private final int slow = 1;
    private final int nedium = 2;
    private final int fast = 3;
    private int speed = slow;
    private boolean on = false;
    private String color = "blue";
    private double radius = 5;

    public Fan() {
    }

    public Fan(int speed, boolean on, String color, double radius) {
        this.speed = speed;
        this.on = on;
        this.color = color;
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        String str = " ";
        if (this.getOn()) {
            str += "Fan is on" + "\n";
            str += "Speed: " + this.getSpeed() + "\n";
            str += "Color: " + this.getColor() + "\n";
            str += "Radius: " + this.getRadius() + "\n";

        } else {
            str += "Fan is off" + "\n";
            str += "Color: " + this.getColor() + "\n";
            str += "Radius: " + this.getRadius() + "\n";

        }

//        if (this.getOn()) {
//            str += "Speed: " + speed + "\n";
//            str += "Color: " + color + "\n";
//            str += "Radius: " + radius + "\n";
//            str += "Fan is on";
//        } else {
//            str += "Color: " + color + "\n";
//            str += "Radius: " + radius + "\n";
//            str += "Fan is off" + "\n";
//        }
        return str;
    }
}

