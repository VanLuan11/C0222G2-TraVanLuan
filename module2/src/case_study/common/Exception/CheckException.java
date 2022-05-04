package case_study.common.Exception;

import java.util.Scanner;

public class CheckException {
    static Scanner scanner = new Scanner(System.in);
     public static int getChoice(int choice){
         boolean check = true;
         while (check){
             try{
               choice = Integer.parseInt(scanner.nextLine());
               check = false;
             } catch (NumberFormatException e) {
                 e.printStackTrace();
             }
         }
         return choice;
     }
}
