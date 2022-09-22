import java.util.ArrayList;
import java.util.List;


public class Algorithm {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        a.add("AFBGVHYFFB");
        for (int i = 0; i <a.size() ; i++) {
            if(a.get(i).equals("F")) {
                b.add(a.get(i));
            }
        }
        System.out.println(b);
    }
}
