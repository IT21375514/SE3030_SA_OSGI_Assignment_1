package com.mtit.companyProducer;

public class Company {
    private String companyId;
    private String companyName;
    private String industry;
    private String location;

    public Company(String companyId, String companyName, String industry, String location) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.industry = industry;
        this.location = location;
    }

    // Getters
    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public String getLocation() {
        return location;
    }

    // Setters
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
