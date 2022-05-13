package exam.common.regex;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Scanner;

public class Regex {
    //. So khớp với bất kỳ ký tự đơn nào
//
//^ So khớp phần đầu của chuỗi hay dòng
//
//$ So khớp phần cuối của chuỗi hay dòng
//
//(…) So khớp với các ‘nhóm’ ký tự bên trong
//
//[…] So khớp với bất kỳ ký tự đơn nào trong dấu ngoặc vuông
//
//[^…] So khớp với bất kỳ ký tự đơn nào ngoại trừ các ký tự trong dấu ngoặc vuông
//
//[m-n] So khớp từ ký tự m đến ký tự n theo thứ tự trong ASCII
//
// XY So khớp với ‘X theo sau là Y’, ví dụ: [a-e][i-u]
//
// X|Y
//So khớp với X hoặc Y
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_1 = "^$";
    private static final String REGEX_2 = "^$";
    private static final String REGEX_3 = "^$";
    private static final String REGEX_4 = "^$";
    private static final String REGEX_5 = "^$";

    public static boolean regex1(String string) {
        return string.matches(REGEX_1);
    }

    public static boolean regex2(String string) {
        return string.matches(REGEX_2);
    }

    public static boolean regex3(String string) {
        return string.matches(REGEX_3);
    }

    public static boolean regex4(String string) {
        return string.matches(REGEX_4);
    }

    public static boolean regex5(String string) {
        return string.matches(REGEX_5);
    }
}
