package ss4_class_and_oop_java.bai_tap;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

     public QuadraticEquation ( double a,double b,double c){
         this.a=a;
         this.b=b;
         this.c=c;
     }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant(){
         return  b*b - 4*a*c;
    }
    public double getRoot1(){
         return (-b+Math.sqrt(this.getDiscriminant()));
    }
    public double getRoot2(){
        return (-b-Math.sqrt(this.getDiscriminant()));
    }
    public  String Condition(){
         if(this.getDiscriminant() > 0){
             return (this.getRoot1()+ " " + this.getRoot2());
         }else if (this.getDiscriminant() == 0){
             return this.getRoot1()+ "";
         }else {
             return "The equation has no roots";
         }

    }

}
