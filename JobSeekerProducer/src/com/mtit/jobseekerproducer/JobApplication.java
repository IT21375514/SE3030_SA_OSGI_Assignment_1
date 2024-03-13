package com.mtit.jobseekerproducer;

public class JobApplication {
	
	private String jobId;
	private String jobseekerNIC;
	
	public JobApplication(String jobId, String jobseekerNIC) {
		super();
		this.jobId = jobId;
		this.jobseekerNIC = jobseekerNIC;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobseekerNIC() {
		return jobseekerNIC;
	}
	
	public void setJobseekerNIC(String jobseekerNIC) {
		this.jobseekerNIC = jobseekerNIC;
	}
	
	
}
