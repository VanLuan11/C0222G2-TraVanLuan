package model.model;

public class ServiceType {
    private int ServiceTypeId;
    private String ServiceTypeName;
    private int status;

    public ServiceType() {
    }

    public ServiceType(int serviceTypeId, String serviceTypeName, int status) {
        ServiceTypeId = serviceTypeId;
        ServiceTypeName = serviceTypeName;
        this.status = status;
    }

    public int getServiceTypeId() {
        return ServiceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        ServiceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return ServiceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        ServiceTypeName = serviceTypeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
