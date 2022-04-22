package ss15_exception_handling_and_debug.bai_tap;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle (int a, int b, int c) throws  TriangleException{
        if (a<=0|| b<=0|| c<=0){
            throw new TriangleException("Cạnh không thể âm");
        }
        if (a+b<=c||b+c<=a||a+c<=b){
            throw new TriangleException("Ko phải tam giác");
        }
        else {
            System.out.println("là tam giác");
        }
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
