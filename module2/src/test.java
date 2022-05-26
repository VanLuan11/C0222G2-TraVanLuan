import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Integer[][] arrs = {
                {1, 2, 8, 43},
                {9, 4, 53, 7},
                {11, 6, 4, 0},
                {1, 2, 6, 51}
        };
        Integer[] arr = solution(arrs);
        for (Integer a : arr) {
            System.out.println(a);
        }
    }

    public static Integer[] solution(Integer[][] arr) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPrime(arr[i][j])) {
                    lists.add(arr[i][j]);
                }
            }
        }
        // toArray chuyển cái list về mảng
        Collections.sort(lists);
        return lists.toArray(new Integer[0]);
    }
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <=  number; i++) {
                if (number % 2 == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
