package com.model;

public class Email {
    private String languages;
    private Integer pageSize;
    private boolean spamsFiliter;
    private String signatuer;

    public Email() {
    }

    public Email(String languages, Integer pageSize, boolean spamsFiliter, String signatuer) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFiliter = spamsFiliter;
        this.signatuer = signatuer;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFiliter() {
        return spamsFiliter;
    }

    public void setSpamsFiliter(boolean spamsFiliter) {
        this.spamsFiliter = spamsFiliter;
    }

    public String getSignatuer() {
        return signatuer;
    }

    public void setSignatuer(String signatuer) {
        this.signatuer = signatuer;
    }
}
