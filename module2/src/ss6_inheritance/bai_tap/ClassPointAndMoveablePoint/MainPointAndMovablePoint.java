package ss6_inheritance.bai_tap.ClassPointAndMoveablePoint;

public class MainPointAndMovablePoint {
    public static void main(String[] args) {
        Point point = new Point(2,3);
        System.out.println(point.toString());

        MovablePoint movablePoint = new MovablePoint(2,3,4,5);
        System.out.println(movablePoint.toString());
        System.out.println(movablePoint.getMove());
    }
}
