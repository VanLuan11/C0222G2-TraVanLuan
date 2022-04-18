package ss12_java_collection_framework.thuc_hanh.comparable_and_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Hoàn", 27, "HT");
        Student student1 = new Student("Tài", 26, "HN");
        Student student2 = new Student("Phương", 18, "HT" );
        Student student3 = new Student("Trí", 20, "HT" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("So sánh theo dộ trẻ trâu:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
