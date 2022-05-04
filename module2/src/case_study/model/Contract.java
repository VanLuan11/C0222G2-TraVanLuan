package case_study.model;

public class Contract {
    private String contractId;
    private String bookingId;
    private Long deposits;
    private Long totalMoney;
    private String customerId;
//    Số hợp đồng, mã booking, Số tiền cọc trước, Tổng số tiền thanh toán, mã khách hàng.

    public Contract() {
    }

    public Contract(String contractId, String bookingId, Long deposits, Long totalMoney, String customerId) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Long getDeposits() {
        return deposits;
    }

    public void setDeposits(Long deposits) {
        this.deposits = deposits;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId='" + contractId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", deposits=" + deposits +
                ", totalMoney=" + totalMoney +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
