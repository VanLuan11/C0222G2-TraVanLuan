package ss7_abstract_class_interface.bai_tap.Resizeable;

public class Square extends Shape{
    private double width;

    public Square(){

    }

    public Square(double width) {
        this.width = width;
    }

    public Square(String color, double width) {
        super(color);
        this.width = width;
    }
    public double getSquareArea(){
        return width*width;
    }
    public  double getSquarePerimeter(){
        return width *4;
    }
    @Override
    public void resize(double percent){
        this.width *= percent;
    }

    @Override
    public String toString() {
        return "Square{" +
                " width=" + width +
                " SquareArea=" + getSquareArea()+
                " SquarePerimeter=" + getSquarePerimeter() +
                '}';
    }
}
