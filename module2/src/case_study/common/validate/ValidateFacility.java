package case_study.common.validate;

public class ValidateFacility {
    private static final String REGEX_SV_FACILITY_VILA = "^SVVL\\-[0-9]{4}$";
    public static boolean isMatchesFacilityVila(String codeService ) {
        return codeService .matches(REGEX_SV_FACILITY_VILA);
    }

    private static final String REGEX_SV_FACILITY_HOUSE = "^SVHO\\-[0-9]{4}$";

    public static boolean isMatchesFacilityHouse(String codeService ) {
        return codeService .matches(REGEX_SV_FACILITY_HOUSE);
    }

    private static final String REGEX_SV_FACILITY_ROOM = "^SVRO\\-[0-9]{4}$";

    public static boolean isMatchesFacilityRoom(String codeService ) {
        return codeService .matches(REGEX_SV_FACILITY_ROOM);
    }
}
