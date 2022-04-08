package ss6_inheritance.bai_tap.ClassCircleAndClassCylinder;

public class Cylinder extends Circle {
    public double height;

    public Cylinder (){

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
        return "Radius: " + radius + '\n' +
                "Color: " + color + '\n' +
                "Height: " + height ;
    }
}
