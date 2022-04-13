package ss6_inheritance.bai_tap.ClassPoint2DAndClassPoint3D;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(){

    }
    public Point3D(float z){
        this.z=z;
    }
    public Point3D(float x,float y,float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(){
        float[] array3D = new float[3];
        array3D[0] = this.getX();
        array3D[1] = this.getY();
        array3D[2] = this.z;
        return array3D;
    }
    public void setXYZ(float x,float y,float z){
        setXY(x,y);
        this.z=z;
    }
    public String toString() {
        return "Point3D" + "\n" +
                "x" + this.getX() + "\n" +
                "y" + this.getY() + "\n" +
                "z" + z;
    }
}
