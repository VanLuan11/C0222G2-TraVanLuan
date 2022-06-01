import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int n = 10;
        String str = "";
        for (int i = 0; i <= n ;i++) {
            for (int j = i; j <= n ; j++) {
                str= "*";
            }
        }
        System.out.println(str);
    }
}
