package case_study.common.validate;

import case_study.common.readandwrite.ReadAndWrite;

import java.util.Scanner;

public class Regex {
    private static final String REGEX_VILA = "^SVVL\\-[0-9]{4}$";
    private static final String REGEX_HOUSE = "^SVHO\\-[0-9]{4}$";
    private static final String REGEX_ROOM = "^SVRO\\-[0-9]{4}$";
    private static final String REGEX_NAME_SERVICE = "^[A-Z][a-z]{1,}$";
    private final static String REGEX_AREA = "^((([3-9][1-9])|([1-9][0-9][0-9]+)))$";
    private final static String REGEX_RENTAL_COSTS = "^([1-9]+)$";
    private final static String REGEX_MAXIMUM_PEOPLE = "^(([1-9])|[1][0-9])$";
    private final static String REGEX_FLOORS_NUMBER = "^([1-9]|[1-9][0-9]+)$";
    private static Scanner sc = new Scanner(System.in);

        public static boolean Villa(String codeService) {
        return codeService.matches(REGEX_VILA);
    }

    public static boolean House(String codeService) {
        return codeService.matches(REGEX_HOUSE);
    }

    public static boolean Room(String codeService) {
        return codeService.matches(REGEX_ROOM);
    }

    public static boolean NameService(String dichVu) {
        return dichVu.matches(REGEX_NAME_SERVICE);
    }

    public static boolean Area(String dienTich) {
        return dienTich.matches(REGEX_AREA);
    }

    public static boolean MaxmumPeople(String soNguoi) {
        return soNguoi.matches(REGEX_MAXIMUM_PEOPLE);
    }

    public static boolean FloorsNumber(String soTang) {
        return soTang.matches(REGEX_FLOORS_NUMBER);
    }

    public static boolean RentalCosts(String chiPhiThue) {
        return chiPhiThue.matches(REGEX_RENTAL_COSTS);
    }
    // hàm regex chung
//    public static String regex(String scanner, String regex, String error) {
//        boolean check = true;
//        do {
//            if (scanner.matches(regex)) {
//                check = false;
//            } else {
//                System.err.println(error);
//                scanner = sc.nextLine();
//            }
//        } while (check);
//        return scanner;
//    }
//
//    public static String Villa() {
//        System.out.println("Nhập mã dịch vụ Villa: ");
//        return Regex.regex(sc.nextLine(), REGEX_VILA, "Error: không đúng mã dịch vụ SVVL-YYYY!");
//    }
//
//    public static String House() {
//        System.out.println("Nhập mã dịch vụ House: ");
//        return Regex.regex(sc.nextLine(), REGEX_HOUSE, "Error: Không đúng mã dịch vụ SVHO -YYYY");
//    }
//
//    public static String Room() {
//        System.out.println("Nhập mã dịch vụ House: ");
//        return Regex.regex(sc.nextLine(), REGEX_ROOM, "Error: Không đúng mã dịch vụ SVRO -YYYY");
//    }
//
//    public static String Name() {
//        System.out.println("Nhập tên dịch vụ : ");
//        return Regex.regex(sc.nextLine(), REGEX_NAME_SERVICE, "Error: Name có chữ hoa đầu");
//    }
//
//    public static String Area() {
//        System.out.println("Nhập diện tích sử dụng: ");
//        return Regex.regex(sc.nextLine(), REGEX_AREA, "Error: diện tích sử dụng >30m2");
//    }
//    public static String AreaPool() {
//        System.out.println("Nhập diện tích hồ bơi: ");
//        return Regex.regex(sc.nextLine(), REGEX_AREA, "Error: diện tích hồ bơi >30m2");
//    }
//
//    public static String RentalCost() {
//        System.out.println("Nhập chi phí thuê: ");
//        return Regex.regex(sc.nextLine(), REGEX_RENTAL_COSTS, "Error: Là số dương");
//    }
//
//    public static String MaxPerson() {
//        System.out.println("Nhập số người tối đa : ");
//        return Regex.regex(sc.nextLine(), REGEX_MAXIMUM_PEOPLE, "Error: 0< số người <20");
//    }
//    public static String RentalType() {
//        System.out.println("Nhập kiểu thuê : ");
//        return Regex.regex(sc.nextLine(), REGEX_NAME_SERVICE, "Error: Kiểu thuê có chữ hoa đầu");
//    }
//    public static String RoomStandard() {
//        System.out.println("Nhập tiêu chuẩn phòng : ");
//        return Regex.regex(sc.nextLine(), REGEX_NAME_SERVICE, "Error: Tiêu chuẩn phòng có chữ hoa đầu");
//    }
}
