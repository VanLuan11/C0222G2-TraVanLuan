package ss7_abstract_class_interface.bai_tap.Resizeable;

public class Circle extends Shape {
    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                " radius=" + radius +
                " Area: " + getArea() +
                '}';
    }
    @Override
    public void resize(double percent){
        this.radius *= percent;
    }
}
