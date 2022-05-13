package bai_thi.common;

import java.util.Scanner;

public class Regex {
    static Scanner sc = new Scanner(System.in);
    private static final String MA_CHIEU = "^CL\\-[0-9]{4}$";
//    public static boolean maSuatChieu (String maChieu){
//        return maChieu.matches(MA_CHIEU);
//    }
    private static  final  String TEN_PHIM = "^[A-Z][a-z]{1,}$";
//    public static boolean tenPhim (String tenPhim){
//        return tenPhim.matches(TEN_PHIM);
//    }

    public static String regexInput(String input, String regex, String error) {
        boolean check = true;
        do {
            if (input.matches(regex)) {
                check = false;
            } else {
                System.err.println(error);
                input = sc.nextLine();
            }
        } while (check);
        return input;
    }
        public static String maSuatPhim(){
        System.out.println("Enter the suat phim: ");
        return Regex.regexInput(sc.nextLine(),MA_CHIEU , "Error: ádasdasdasd");
    }
}
