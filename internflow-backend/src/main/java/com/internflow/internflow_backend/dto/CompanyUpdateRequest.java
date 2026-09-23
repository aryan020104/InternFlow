package com.internflow.internflow_backend.dto;

public class CompanyUpdateRequest {

    private String companyName;
    private String industry;
    private String address;
    private String website;
    private String logoUrl;
    private String hrContactName;
    private String hrContactTitle;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getHrContactName() {
        return hrContactName;
    }

    public void setHrContactName(String hrContactName) {
        this.hrContactName = hrContactName;
    }

    public String getHrContactTitle() {
        return hrContactTitle;
    }

    public void setHrContactTitle(String hrContactTitle) {
        this.hrContactTitle = hrContactTitle;
    }
}