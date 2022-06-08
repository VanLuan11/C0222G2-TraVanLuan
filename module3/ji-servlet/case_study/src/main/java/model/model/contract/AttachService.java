package model.model.contract;

public class AttachService {
    private int AttachServiceId;
    private String AttachServiceName;
    private double AttachServiceCost;
    private int AttachServiceUnti;
    private String AttachServiceStatus;
    private int status;

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, double attachServiceCost, int attachServiceUnti, String attachServiceStatus, int status) {
        AttachServiceId = attachServiceId;
        AttachServiceName = attachServiceName;
        AttachServiceCost = attachServiceCost;
        AttachServiceUnti = attachServiceUnti;
        AttachServiceStatus = attachServiceStatus;
        this.status = status;
    }

    public int getAttachServiceId() {
        return AttachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        AttachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return AttachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        AttachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return AttachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        AttachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnti() {
        return AttachServiceUnti;
    }

    public void setAttachServiceUnti(int attachServiceUnti) {
        AttachServiceUnti = attachServiceUnti;
    }

    public String getAttachServiceStatus() {
        return AttachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        AttachServiceStatus = attachServiceStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
