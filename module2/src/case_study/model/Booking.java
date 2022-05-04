package case_study.model;

import java.util.Date;

public class Booking {
    private static String COMMA = ",";
    private String codeBooking;
    private Date startDay;
    private Date endDay;
    private String idCustomer;
    private String nameService;
    private String typeOfService;

    public Booking() {
    }

    public Booking(String codeBooking, Date startDay, Date endDay, String idCustomer, String nameService, String typeOfService) {
        this.codeBooking = codeBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeOfService = typeOfService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking" +
                "codeBooking='" + codeBooking +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", idCustomer=" + idCustomer +
                ", nameService=" + nameService +
                ", typeOfService=" + typeOfService;
    }

    public String convertLine() {
        return this.codeBooking + COMMA + this.startDay + COMMA + this.endDay + COMMA +this.idCustomer+COMMA +this.nameService+COMMA +this.typeOfService;
    }
}
