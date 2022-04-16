package ss10_dsa_list.bai_tap.array_list;


public class Main {
    public static void main(String[] args) {
        Student student1= new Student(1,"luan");
        Student student2 = new Student(2,"luan2");
        Student student3 = new Student(3,"luan3");
        Student student4 = new Student(4,"luan4");

        ArrayList<Student> studentArrayList = new ArrayList<>();

        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.remove(1);
        for (int i = 0; i < studentArrayList.size(); i++) {
            System.out.println(studentArrayList.elements[i].toString());

        }
    }
}
