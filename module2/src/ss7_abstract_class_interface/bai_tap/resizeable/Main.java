package ss7_abstract_class_interface.bai_tap.resizeable;

public class Main {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() *10);
        Shape[] shapes = new Shape[3];
        shapes [0] = new Circle("blue", x);
        shapes [1] = new Rectangle("red", x,x);
        shapes [2] = new Square("black", x);

        for (Shape a : shapes) {
            System.out.println(a);
        }
    }
}
