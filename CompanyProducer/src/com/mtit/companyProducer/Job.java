package com.mtit.companyProducer;

public class Job {
    private String companyId;
    private String jobTitle;
    private String description;
    private static int nextJobId = 1;
    private int jobId;

    public Job(String companyId, String jobTitle, String description) {
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.description = description;
        this.jobId = nextJobId++;
    }

    // Getters
    public String getCompanyId() {
        return companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public int getJobId() {
        return jobId;
    }

    // Setters
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
