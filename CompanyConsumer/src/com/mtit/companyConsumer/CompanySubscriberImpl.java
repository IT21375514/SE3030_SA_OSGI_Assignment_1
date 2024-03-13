package com.mtit.companyConsumer;


import java.util.List;
import java.util.Scanner;

import com.mtit.companyProducer.Company;
import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.companyProducer.Job;
import com.mtit.jobseekerproducer.JobApplication;
import com.mtit.jobseekerproducer.JobSeeker;
import com.mtit.jobseekerproducer.JobSeekerProduce;

public class CompanySubscriberImpl implements CompanySubscriber {

    String input;
    String companyId;
    String companyName;
    String industry;
    String location;
    String jobTitle;
    String description;
    Scanner scanner = new Scanner(System.in);

    public static final String ADD = "add";
    public static final String ADD_JOBS = "add_jobs";
    public static final String SHOW = "show_jobs";
    public static final String ALL = "all";
    public static final String DELETE = "delete";
    public static final String SELECT = "select";
    public static final String GET = "applications";    
	public static final String STOP ="stop";


    @Override
    public void getService(CompanyPublisher companyPublisher,JobSeekerProduce jobseekerproducer) {
	    System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
        System.out.println("Select the service from below . ");
        System.out.println();

        while (true) {
            input = getInput();

            if (input.equalsIgnoreCase(ADD)) {
                addRecord(companyPublisher);
            } else if (input.equalsIgnoreCase(ALL)) {
                getAllRecords(companyPublisher);
            } else if (input.equalsIgnoreCase(DELETE)) {
                deleteRecord(companyPublisher);
            } else if (input.equalsIgnoreCase(SELECT)) {
            	selectRecord(companyPublisher);
            } else if (input.equalsIgnoreCase(GET)) {
            	getApplication(jobseekerproducer,companyPublisher);
            } else if(input.equalsIgnoreCase(STOP)){
	    		  return;
            } else if(input.equalsIgnoreCase(ADD_JOBS)){
            	addJob(companyPublisher);
            } else if(input.equalsIgnoreCase(SHOW)){
            	showJobs(companyPublisher);
	    	} else {
                System.out.println("Invalid");
            }
        }
    }

    public String getInput() {
        System.out.println("Add Company:                    'Add'");
        System.out.println("View All Companies:             'All'");
        System.out.println("Add Jobs:                       'Add_Jobs'");
        System.out.println("Show Jobs:                       'Show_Jobs'");
        System.out.println("Delete a Company:               'Delete'");
        System.out.println("Select a Company:               'Select'");
        System.out.println("Get Job Seeker Applications       'applications'");
        System.out.println();
 	   System.out.println("Stop Service:                	'Stop'");
        System.out.println();
        String input = scanner.nextLine();
        return input;
    }

    public void addRecord(CompanyPublisher companyPublisher) {
    	System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
        System.out.println("Enter Company ID:");
        companyId = scanner.nextLine();

        System.out.println("Enter Company Name:");
        companyName = scanner.nextLine();

        System.out.println("Enter Industry:");
        industry = scanner.nextLine();

        System.out.println("Enter Location:");
        location = scanner.nextLine();
        
//        System.out.println("Enter Job Title:");
//        jobTitle = scanner.nextLine();
//
//        System.out.println("Enter Description:");
//        description = scanner.nextLine();

        String temp = companyPublisher.addCompany(companyId, companyName, industry, location);
        System.out.println(temp);
        System.out.println();
    }
    
    
    public void addJob(CompanyPublisher companyPublisher) {
    	System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
        System.out.println("Enter Company ID:");
        companyId = scanner.nextLine();
        
        //companyPublisher.addJob(companyId);


        
        System.out.println("Enter Job Title:");
        jobTitle = scanner.nextLine();

        System.out.println("Enter Description:");
        description = scanner.nextLine();

        String temp = companyPublisher.addJob(companyId, jobTitle, description);
        System.out.println(temp);
        System.out.println();
    }

    public void getAllRecords(CompanyPublisher companyPublisher) {
        List<Company> companies = companyPublisher.getAllCompanies();
        System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
        System.out.println("=====Displaying all Companies and Jobs==== ");
        System.out.println();
        for (Company company : companies) {
            System.out.println("Company ID: " + company.getCompanyId());
            System.out.println("Company Name: " + company.getCompanyName());
            System.out.println("Industry: " + company.getIndustry());
            System.out.println("Location: " + company.getLocation());

            List<Job> jobs = companyPublisher.getJobById(company.getCompanyId());
            System.out.println("Job Titles:");
            for (Job job : jobs) {
                System.out.println("\t- " + job.getJobTitle());
            }
            System.out.println(); // Add an empty line between companies
        }
        System.out.println();
    }


    
    
    public void showJobs(CompanyPublisher companyPublisher) {
        
    	  System.out.println("Enter Company ID to view jobs: ");
    	    String companyId = scanner.nextLine();
    	    
    	    List<Job> jobs = companyPublisher.getJobById(companyId);
    	    
    	    if (jobs.isEmpty()) {
    	        System.out.println("No jobs found for Company ID: " + companyId);
    	    } else {
    	        System.out.println("===== Displaying Jobs for Company ID: " + companyId + " =====");
    	        for (Job job : jobs) {
    	            System.out.println("Company ID: " + job.getCompanyId());
    	            System.out.println("Job ID: " + job.getJobId());
    	            System.out.println("Job Title: " + job.getJobTitle());
    	            System.out.println("Description: " + job.getDescription());
    	            System.out.println("-----------------------------");
    	        }
    	    }
        }
    
   
    
    private void deleteRecord(CompanyPublisher companyPublisher) {
        String companyId;
        System.out.println();
		System.out.println("=========== OpportunityNet ============");
		System.out.println("===== Job and Training Exchange Platform ======");  
	    System.out.println();
        System.out.println("Enter Company ID to be deleted: ");
        companyId = scanner.nextLine();
        companyPublisher.deleteCompany(companyId);
        System.out.println();
    }
    
    private void selectRecord(CompanyPublisher companyPublisher) {
    	String companyId;
    	
    	System.out.println("Company ID");
    	companyId = scanner.nextLine();
    	companyPublisher.getCompanyById(companyId);
    	 List<Job> jobs = companyPublisher.getJobById(companyId);
 	    
 	    if (jobs.isEmpty()) {
 	        System.out.println("No jobs found for Company ID: " + companyId);
 	    } else {
 	        System.out.println("===== Displaying Jobs for Company ID: " + companyId + " =====");
 	        for (Job job : jobs) {
 	            //System.out.println("Company ID: " + job.getCompanyId());
 	            System.out.println("Job ID: " + job.getJobId());
 	            System.out.println("Job Title: " + job.getJobTitle());
 	            System.out.println("Description: " + job.getDescription());
 	            System.out.println("-----------------------------");
 	        }
 	    }
    	
    }
    
    private void getApplication(JobSeekerProduce jobseekerproduce,CompanyPublisher companyPublisher) {
    	String companyId;
        String jobId;
        
        System.out.println("Enter Company ID:");
        companyId = scanner.nextLine();
        System.out.println("Enter Job ID:");
        jobId = scanner.nextLine();
        
        // Retrieve job details
        Company company = companyPublisher.getCompanyById(companyId);
        if (company == null) {
            System.out.println("Company not found for ID: " + companyId);
            return;
        }
        
        List<Job> job = companyPublisher.getJobById(jobId);
        if (job == null) {
            System.out.println("Job not found for ID: " + jobId);
            return;
        }
        
        // Retrieve job applications for the given job ID
        List<JobSeeker> jobApplications = jobseekerproduce.getJobApplication(jobId);
        
        if (jobApplications.isEmpty()) {
            System.out.println("No applications found for Job ID: " + jobId);
        } else {
            System.out.println("===== Displaying Job Applications =====");
            for (JobSeeker application : jobApplications) {
                System.out.println("Seeker Name: " + application.getJobseeker_name());
                System.out.println("NIC: " + application.getJobseeker_NIC());
                System.out.println("Email: " + application.getJobseeker_email());
                System.out.println("Qualification: " + application.getJobseeker_highestqualifications());
                System.out.println("-----------------------------");
            }
        }
    
    }
    
    
    
    
    
//    private void editRecord(CompanyPublisher companyPublisher) {
//    	 
//    	 String companyId;
//    	 
//    	 System.out.println("Company ID");
//     	 companyId = scanner.nextLine();
//     	 companyPublisher.updateCompany(companyId);
//    	
//    	 
//    }
}
