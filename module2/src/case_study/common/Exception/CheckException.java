package case_study.common.Exception;

import java.util.Scanner;

public class CheckException {
    static Scanner scanner = new Scanner(System.in);
     public static Integer getChoice(Integer choice){
         boolean check = true;
         while (check){
             try{
               choice = Integer.parseInt(scanner.nextLine());
               check = false;
             } catch (NumberFormatException e) {
                 System.err.println(e.getMessage());
             }
         }
         return choice;
     }
     public static Integer getCheckInteger(Integer integer){
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
