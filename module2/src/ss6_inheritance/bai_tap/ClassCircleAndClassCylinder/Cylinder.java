package ss6_inheritance.bai_tap.ClassCircleAndClassCylinder;

public class Cylinder extends Circle {
    private double height;

    private Cylinder (){

    }

    public Cylinder(double height){
        this.height=height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getCylindrical(){
        return  height*getArea();
    }
    public String toString(){
        return "Radius: " + this.getRadius() + '\n' +
                "Color: " + this.getColor() + '\n' +
                "Height: " + height ;
    }
}
