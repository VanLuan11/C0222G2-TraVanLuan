package ss7_abstract_class_interface.bai_tap.resizeable;

public class Rectangle extends Shape {
    private double width ;
    private double length;

    public Rectangle (){

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, double width, double length) {
        super(color);
        this.width = width;
        this.length = length;
    }
    public double getRectangularArea(){
        return width*length;
    }
    public  double getPerimeter(){
        return 2*(width*length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                " length=" + length +
                " RectangularArea=" + getRectangularArea()+
                " Perimeter=" + getPerimeter() +
                '}';
    }
    @Override
    public void resize(double percent){
        this.width *= percent;
        this.length *= percent;
    }

}
