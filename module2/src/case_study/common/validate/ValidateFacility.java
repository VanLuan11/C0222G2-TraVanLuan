package case_study.common.validate;

public class ValidateFacility {
    private static final String REGEX_VILA = "^SVVL\\-[0-9]{4}$";
    private static final String REGEX_HOUSE = "^SVHO\\-[0-9]{4}$";
    private static final String REGEX_ROOM = "^SVRO\\-[0-9]{4}$";
    private static final String REGEX_NAME_SERVICE = "^[A-Z][a-z]{1,}$";
    private final static String REGEX_AREA = "^((([3-9][1-9])|([1-9][0-9][0-9]+)))$";
    private final static String REGEX_RENTAL_COSTS = "^([1-9]+)$";
    private final static String REGEX_MAXIMUM_PEOPLE = "^(([1-9])|[1][0-9])$";
    private final static String REGEX_FLOORS_NUMBER = "^([1-9]|[1-9][0-9]+)$";


    public static boolean Vila(String codeService) {
        return codeService.matches(REGEX_VILA);
    }
    public static boolean House(String codeService) {
        return codeService.matches(REGEX_HOUSE);
    }
    public static boolean Room(String codeService) {
        return codeService.matches(REGEX_ROOM);
    }
    public static boolean isMatchesNameService(String dichVu) {
        return dichVu.matches(REGEX_NAME_SERVICE);
    }
    public static boolean Area (String dienTich){
        return dienTich.matches(REGEX_AREA);
    }
    public static boolean MaxmumPeople(String soNguoi){
        return soNguoi.matches(REGEX_MAXIMUM_PEOPLE);
    }
    public static boolean FloorsNumber (String soTang){
        return soTang.matches(REGEX_FLOORS_NUMBER);
    }
    public static boolean RentalCosts(String chiPhiThue){
        return chiPhiThue.matches(REGEX_RENTAL_COSTS);
    }
}
