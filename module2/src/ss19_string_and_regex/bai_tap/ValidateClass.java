package ss19_string_and_regex.bai_tap;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String VALIDATE_CLASS = "^[C|A|P]+[0-9]{4}+[G|H|I|K|L|M]$";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(VALIDATE_CLASS);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("nhập tên lớp: ");
            String lop = scanner.nextLine();
            if(pattern.matcher(lop).find()){
                System.out.println("đúng");
                break;
            }else{
                System.out.println("sai rồi thằng ngu");
            }
        }
    }
}
