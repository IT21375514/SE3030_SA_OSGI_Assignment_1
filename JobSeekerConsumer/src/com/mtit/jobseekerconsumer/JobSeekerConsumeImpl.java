package com.mtit.jobseekerconsumer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mtit.companyProducer.Company;
import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.companyProducer.Job;
import com.mtit.jobseekerproducer.JobSeeker;
import com.mtit.jobseekerproducer.JobSeekerProduce;


public class JobSeekerConsumeImpl implements JobSeekerConsume {
	
	String input;
	String jobId;
	String jobseeker_NIC;
	String jobseeker_name;
    String jobseeker_email;
    String jobseeker_highestqualifications;
    String jobseeker_preferedposition;
    String jobseeker_description;
	Double jobseeker_expectedsalary;
	
	Scanner sc = new Scanner(System.in);

	public static final String ADD ="add";
	public static final String All ="all";
	public static final String GET ="get";
	public static final String DELETE ="delete";
	public static final String UPDATE ="update";
	public static final String STOP ="stop";
	public static final String JOBS ="jobs";
	public static final String APPLY ="apply";
	
	@Override
	public void getService(JobSeekerProduce jobSeekerProduce, CompanyPublisher companyPublish) {
		System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
	      System.out.println("Select the service from below . ");
	      System.out.println();
	      
	      while(true) {
	    	  input = getInput();
	    	  
	    	  if (input != null && !input.trim().isEmpty()) {
	    		  if(input.equalsIgnoreCase(ADD)) {
		    		  addRecord( jobSeekerProduce);
		    	  }
		    	  else if (input.equalsIgnoreCase(All)) {
		    		  getAllRecords( jobSeekerProduce);
		    	  }
		    	  else if (input.equalsIgnoreCase(DELETE)) {
		    		  deleteRecord( jobSeekerProduce);
		    	  }
		    	  else if (input.equalsIgnoreCase(UPDATE)) {
		    		  updateRecord( jobSeekerProduce);
		    	  }
		    	  else if (input.equalsIgnoreCase(GET)) {
		    		  getRecord( jobSeekerProduce);
		    	  }
		    	  else if (input.equalsIgnoreCase(JOBS)) {
		    		  getRelatedJobs( companyPublish);
		    	  }
		    	  else if(input.equalsIgnoreCase(APPLY)){
		    		  applyForJob( jobSeekerProduce);
		    	  }
		    	  else if(input.equalsIgnoreCase(STOP)){
		    		  return;
		    	  }
		    	  else {
		    		  System.out.println("Invalid");
		    	  }
	    	  }
	      }
		
	}


public String getInput() {
	   System.out.println("Add Job Seeker Details :		'Add'");
	   System.out.println("View  All the Job Seekers :		'All'");
	   System.out.println("View a Job Seeker :			'Get'");
	   System.out.println("Delete a Job Seeker :			'Delete'");
	   System.out.println("Update a Job Seeker Details :		'Update'");
	   System.out.println("");
	   System.out.println("Get Related Jobs:                   	'Jobs'");
	   System.out.println("Apply for a Job:                	'Apply'");
	   System.out.println("");
	   System.out.println("Stop Service:                	  	'Stop'");
	   System.out.println();
	   String input =sc.nextLine();
	   return input;
	   
   }
   
   public void addRecord(JobSeekerProduce jobSeekerProduce) {
	   
	   System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
	   
	   System.out.println("Enter Your NIC :");
	   jobseeker_NIC = sc.nextLine();	   
	   System.out.println("Enter Your Name :");
	   jobseeker_name = sc.nextLine();   
	   System.out.println("Enter Your Email :");
	   jobseeker_email = sc.nextLine();
	   System.out.println("Enter Your Highest Qualifications :");
	   jobseeker_highestqualifications = sc.nextLine();
	   System.out.println("Enter Your Prefered Position :");
	   jobseeker_preferedposition = sc.nextLine();
	   System.out.println("Enter Additional Information :");
	   jobseeker_description = sc.nextLine();
	   System.out.println("Enter Your Expected Salary :");
	   jobseeker_expectedsalary = sc.nextDouble();
	   
	   String temp = jobSeekerProduce.addJobSeeker(jobseeker_NIC,jobseeker_name, jobseeker_email, jobseeker_highestqualifications, jobseeker_preferedposition, jobseeker_description, jobseeker_expectedsalary);
	   System.out.println(temp);
	   System.out.println();
   }
   
   public void getAllRecords(JobSeekerProduce jobSeekerProduce) {
	   List<JobSeeker> jobSeekers = jobSeekerProduce.getAllJobSeeker();
	   System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
	   System.out.println("=====Displaying All Job Seekers Information==== ");
	   System.out.println();
	   
	   for(JobSeeker jobSeeker : jobSeekers ) {
		   System.out.println();
		   System.out.println("NIC : "+jobSeeker.getJobseeker_NIC());
		   System.out.println("Name : "+jobSeeker.getJobseeker_name());
		   System.out.println("Email : "+jobSeeker.getJobseeker_email());
		   System.out.println("Highest Qualification : "+jobSeeker.getJobseeker_highestqualifications());
		   System.out.println("Preferred Position : "+jobSeeker.getJobseeker_preferedposition());
		   System.out.println("Description : "+jobSeeker.getJobseeker_description());
		   System.out.println("Expected Salary : "+jobSeeker.getJobseeker_expectedsalary().toString());
		   System.out.println();
	   }

   }
   
   private void getRecord(JobSeekerProduce jobSeekerProduce) {
		// TODO Auto-generated method stub
	   String getJobseeker_NIC;
		
	   System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
		System.out.println("Enter NIC of Job Seeker to Retrive: ");
		getJobseeker_NIC = sc.nextLine();
		
		JobSeeker jobSeeker = jobSeekerProduce.getJobSeeker(getJobseeker_NIC);
		
	    if (jobSeeker != null) {
	        System.out.println();
	        System.out.println("Name : " + jobSeeker.getJobseeker_name());
	        System.out.println("Email : " + jobSeeker.getJobseeker_email());
	        System.out.println("Highest Qualification : " + jobSeeker.getJobseeker_highestqualifications());
	        System.out.println("Preferred Position : " + jobSeeker.getJobseeker_preferedposition());
	        System.out.println("Description : " + jobSeeker.getJobseeker_description());
	        System.out.println("Expected Salary : " + jobSeeker.getJobseeker_expectedsalary().toString());
	        System.out.println();
	    } else {
	        System.out.println("Job Seeker with NIC " + getJobseeker_NIC + " not found!");
	        System.out.println();
	    }
		
	}

   private void getRelatedJobs(CompanyPublisher companyPublish) {
		// TODO Auto-generated method stub
	   String getJobseeker_preferedposition;
		
	   System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
		System.out.println("Enter Preferred Job Position : ");
		getJobseeker_preferedposition = sc.nextLine();
		
		Map<Job, Company> preferredJobs = companyPublish.getPreferredJobs(getJobseeker_preferedposition);
		
		System.out.println();   
		System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
		   System.out.println("=====Displaying All Related Vacancies==== ");
		   System.out.println();
		   
		   for (Map.Entry<Job, Company> entry : preferredJobs.entrySet()) {
	            Job job = entry.getKey();
	            Company company = entry.getValue();

	            System.out.println("Job No: " + job.getJobId());
	            System.out.println("Job Title: " + job.getJobTitle());
	            System.out.println("Description: " + job.getDescription());
	            System.out.println("Company Name: " + company.getCompanyName());
	            System.out.println("Location: " + company.getLocation());
	            System.out.println();
	        }
	}

 public void applyForJob(JobSeekerProduce jobSeekerProduce) {
	   
	 System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
	   
	   System.out.println("Enter Job ID :");
	   jobId = sc.nextLine();   
	   System.out.println("Enter Your NIC :");
	   jobseeker_NIC = sc.nextLine();	   
	   
	   String temp = jobSeekerProduce.applyForJob(jobId,jobseeker_NIC);
	   System.out.println(temp);
	   System.out.println();
   }
   
   
   private void deleteRecord(JobSeekerProduce jobSeekerProduce) {
		String getJobseeker_NIC;
		
		System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
		System.out.println("Enter NIC to be deleted: ");
		getJobseeker_NIC = sc.nextLine();
		jobSeekerProduce.deleteJobSeeker(getJobseeker_NIC);
		System.out.println();
	}

   private void updateRecord(JobSeekerProduce jobSeekerProduce) {
		String getJobseeker_NIC;
		System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
		System.out.println("Enter NIC to be Updated: ");
		getJobseeker_NIC = sc.nextLine();
		System.out.println("Enter Your Highest Qualifications :");
		jobseeker_highestqualifications = sc.nextLine();
		System.out.println("Enter Your Prefered Position :");
		jobseeker_preferedposition = sc.nextLine();
		System.out.println("Enter Additional Information :");
		jobseeker_description = sc.nextLine();
		System.out.println("Enter Your Expected Salary :");
		jobseeker_expectedsalary = sc.nextDouble();
		jobSeekerProduce.updateJobSeeker(getJobseeker_NIC,jobseeker_highestqualifications,jobseeker_preferedposition,jobseeker_description,jobseeker_expectedsalary);
		System.out.println();
	}
   
}
