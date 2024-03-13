package com.mtit.jobseekerproducer;

import java.util.List;

public interface JobSeekerProduce {
	public String addJobSeeker(String jobseeker_NIC, String jobseeker_name, String jobseeker_email, String jobseeker_highestqualifications, String jobseeker_preferedposition, String jobseeker_description, Double jobseeker_expectedsalary);
	public void deleteJobSeeker(String jobseeker_NIC);
	public void updateJobSeeker(String jobseeker_NIC, String jobseeker_highestqualifications, String jobseeker_preferedposition, String jobseeker_description, double jobseeker_expectedsalary);
	public List<JobSeeker> getAllJobSeeker();
	public JobSeeker getJobSeeker(String jobseeker_NIC);
	public String applyForJob(String jobId, String jobseekerNIC);
	public List<JobSeeker>getJobApplication(String jobId);
}
