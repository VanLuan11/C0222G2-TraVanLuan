package case_study.common.Exception;

import java.util.Scanner;

public class CheckException {
     public static Integer getCheckInteger(Integer integer){
         Scanner scanner = new Scanner(System.in);
         boolean check= true;
         while (check){
             try{
                 integer = Integer.parseInt(scanner.nextLine());
                 check = false;
             }catch(NumberFormatException e){
                 System.err.println(e.getMessage());
             }
         }
         return integer;
     }
}
