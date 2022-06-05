package model.model;

public class CustomerType {
    private int  CustomerTypeId;
    private String CustomerTypeName;
    private int status;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerTypeName, int status) {
        CustomerTypeId = customerTypeId;
        CustomerTypeName = customerTypeName;
        this.status = status;
    }

    public int getCustomerTypeId() {
        return CustomerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        CustomerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return CustomerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        CustomerTypeName = customerTypeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
