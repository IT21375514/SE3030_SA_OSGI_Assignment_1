package com.mtit.jobseekerproducer;

public class JobSeeker {
	private String jobseeker_NIC;
	private String jobseeker_name;
	private String jobseeker_email;
	private String jobseeker_highestqualifications;
	private String jobseeker_preferedposition;
	private String jobseeker_description;
	private Double jobseeker_expectedsalary;
	
	public JobSeeker(String jobseeker_NIC, String jobseeker_name, String jobseeker_email, String jobseeker_highestqualifications, String jobseeker_preferedposition, String jobseeker_description, Double jobseeker_expectedsalary) {
		super();
		this.jobseeker_NIC = jobseeker_NIC;
		this.jobseeker_name = jobseeker_name;
		this.jobseeker_email = jobseeker_email;
		this.jobseeker_highestqualifications =jobseeker_highestqualifications;
		this.jobseeker_preferedposition = jobseeker_preferedposition;
		this.jobseeker_description = jobseeker_description;
		this.jobseeker_expectedsalary = jobseeker_expectedsalary;
	}

	public String getJobseeker_NIC() {
		return jobseeker_NIC;
	}

	public void setJobseeker_NIC(String jobseeker_NIC) {
		this.jobseeker_NIC = jobseeker_NIC;
	}

	public String getJobseeker_name() {
		return jobseeker_name;
	}

	public void setJobseeker_name(String jobseeker_name) {
		this.jobseeker_name = jobseeker_name;
	}

	public String getJobseeker_email() {
		return jobseeker_email;
	}

	public void setJobseeker_email(String jobseeker_email) {
		this.jobseeker_email = jobseeker_email;
	}

	public String getJobseeker_highestqualifications() {
		return jobseeker_highestqualifications;
	}

	public void setJobseeker_highestqualifications(String jobseeker_highestqualifications) {
		this.jobseeker_highestqualifications = jobseeker_highestqualifications;
	}

	public String getJobseeker_preferedposition() {
		return jobseeker_preferedposition;
	}

	public void setJobseeker_preferedposition(String jobseeker_preferedposition) {
		this.jobseeker_preferedposition = jobseeker_preferedposition;
	}

	public String getJobseeker_description() {
		return jobseeker_description;
	}

	public void setJobseeker_description(String jobseeker_description) {
		this.jobseeker_description = jobseeker_description;
	}

	public Double getJobseeker_expectedsalary() {
		return jobseeker_expectedsalary;
	}

	public void setJobseeker_expectedsalary(Double jobseeker_expectedsalary) {
		this.jobseeker_expectedsalary = jobseeker_expectedsalary;
	}
	

	
}
