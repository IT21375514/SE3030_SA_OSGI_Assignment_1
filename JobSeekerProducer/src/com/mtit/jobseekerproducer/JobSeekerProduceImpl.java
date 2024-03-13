package com.mtit.jobseekerproducer;

import java.util.ArrayList;
import java.util.List;



public class JobSeekerProduceImpl implements JobSeekerProduce {

	public List<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();
	public List<JobApplication> jobApplications = new ArrayList<JobApplication>();


	//adding a new record 
	@Override
	public String addJobSeeker(String jobseeker_NIC, String jobseeker_name, String jobseeker_email, String jobseeker_highestqualifications, String jobseeker_preferedposition, String jobseeker_description, Double jobseeker_expectedsalary) {

		// Check if the NIC already exists
	    for (JobSeeker existingJobSeeker : jobSeekers) {
	        if (existingJobSeeker.getJobseeker_NIC().equalsIgnoreCase(jobseeker_NIC)) {
	            return "Job seeker with NIC " + jobseeker_NIC + " already exists!";
	        }
	    }
	    
		JobSeeker jobSeeker = new JobSeeker (jobseeker_NIC, jobseeker_name, jobseeker_email, jobseeker_highestqualifications,jobseeker_preferedposition,jobseeker_description,jobseeker_expectedsalary);
		jobSeekers.add(jobSeeker);
		return "New job seeker: " + jobSeeker.getJobseeker_name() +
			       ", with " + jobSeeker.getJobseeker_highestqualifications() +
			       " qualification, interested in " + jobSeeker.getJobseeker_preferedposition() +
			       ", entered successfully!";     
	}

	//Get all records 
	@Override
	public List <JobSeeker> getAllJobSeeker() {
		return jobSeekers;		
	}
	
	public JobSeeker getJobSeeker(String jobseeker_NIC) {
	    for (JobSeeker jobSeeker : jobSeekers) {
	        if (jobSeeker.getJobseeker_NIC().equalsIgnoreCase(jobseeker_NIC)) {
	            return jobSeeker;
	        }
	    }
	    return null;
	}

	//Delete Record
	@Override
	public void deleteJobSeeker(String jobseeker_NIC) {
	    for(JobSeeker jobSeeker : jobSeekers) {
	    	if(jobSeeker.getJobseeker_NIC().equalsIgnoreCase(jobseeker_NIC)) {
	    		int id =jobSeekers.indexOf(jobSeeker);
	    		jobSeekers.remove(id);
	    		System.out.println(" Job Seeker Record Deleted Successfully!");
	    		return ;
	    	}
	    }
		
	}

	@Override
	public void updateJobSeeker(String jobseeker_NIC, String jobseeker_highestqualifications, String jobseeker_preferedposition, String jobseeker_description, double jobseeker_expectedsalary) {
	    for (JobSeeker jobSeeker : jobSeekers) {
	        if (jobSeeker.getJobseeker_NIC().equalsIgnoreCase(jobseeker_NIC)) {
	            // Update the job seeker's attributes
	            jobSeeker.setJobseeker_highestqualifications(jobseeker_highestqualifications);
	            jobSeeker.setJobseeker_preferedposition(jobseeker_preferedposition);
	            jobSeeker.setJobseeker_description(jobseeker_description);
	            jobSeeker.setJobseeker_expectedsalary(jobseeker_expectedsalary);
	            System.out.println("Job Seeker Record Updated Successfully!");
	            return;
	        }
	    }
	    // If no job seeker with the provided NIC is found
	    System.out.println("Job Seeker with NIC " + jobseeker_NIC + " not found!");
	}

	@Override
	public String applyForJob(String jobId, String jobseekerNIC) {
		 for (JobApplication application : jobApplications) {
		        if (application.getJobId().equalsIgnoreCase(jobseekerNIC) && 
		        		application.getJobseekerNIC().equalsIgnoreCase(jobseekerNIC)) {
		            return "Job Seeker with NIC " + jobseekerNIC + " has already applied for this job!";
		        }
		    }
		    
		 	JobApplication jobApplication = new JobApplication (jobId, jobseekerNIC);
		 	jobApplications.add(jobApplication);
			return "New job seeker: " + jobApplication.getJobseekerNIC() +
				       " has applied for the Job No " + jobApplication.getJobId() + " successfully!";     
	}
	
	public List<JobSeeker> getJobApplication(String jobId) {
		// TODO Auto-generated method stub
		 //in above
		List<JobSeeker> AppliedJobSeeker = new ArrayList<>();     


		        for (JobApplication jobApp : jobApplications) {
		            if (jobApp.getJobId().equalsIgnoreCase(jobId)) {
		                for (JobSeeker jobSeeker : jobSeekers) {
		                    if (jobSeeker.getJobseeker_NIC().equalsIgnoreCase(jobApp.getJobseekerNIC())) {
		                    	AppliedJobSeeker.add(jobSeeker); // Add the matched JobSeeker to the list
		                    }
		                }
		            }
		        }

		        return  AppliedJobSeeker;
		    }

}
