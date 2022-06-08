package model.model.contract;

public class Contract {
    private int contractId;
    private String contractStartDate;
    private String contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;
    private int employeeId;
    private int customerId;
    private int serviceId;
    private int status;

    public Contract() {
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, int employeeId, int customerId, int serviceId, int status) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.status = status;
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, int employeeId, int customerId, int serviceId) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract(String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, int employeeId, int customerId, int serviceId) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }
}
