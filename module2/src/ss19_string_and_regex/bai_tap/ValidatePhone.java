package ss19_string_and_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String VALIDATE_PHONE = "^\\([0-9]{2}\\)-\\(0+[0-9]{9}\\)$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(VALIDATE_PHONE);
        while (true){
            System.out.print("nhập số điện thoại: ");
            String phone = scanner.nextLine();
            if(pattern.matcher(phone).find()){
                System.out.println("đúng rồi");
                break;
            }else{
                System.out.println("nhập sai rồi thằng ngu");
            }
        }
    }
}
