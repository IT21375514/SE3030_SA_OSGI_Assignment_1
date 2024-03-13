package com.mtit.companyProducer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CompanyPublishImpl implements CompanyPublisher {

    public List<Company> companies = new ArrayList<>();
    public List<Job> jobs = new ArrayList<>();

    // Add a new company record
    @Override
    public String addCompany(String companyId, String companyName, String industry, String location){
    	
    	for (Company comp : companies) {
            if (comp.getCompanyId().equalsIgnoreCase(companyId)) {
                return "Company already exists!";
            }
        }

        // If the loop completes without finding a matching company ID, add the new company
        Company company = new Company(companyId, companyName, industry, location);
        companies.add(company);
        return "New company " + companyName + " added successfully!";
    }

    // Get all company records
    @Override
    public List<Company> getAllCompanies() {
        return companies;
    }

    // Delete a company record
    @Override
    public void deleteCompany(String companyId) {
    	
    	 List<Job> jobsToRemove = new ArrayList<>();

    	    // Collect jobs to be removed
    	    for (Job job : jobs) {
    	        if (job.getCompanyId().equalsIgnoreCase(companyId)) {
    	            jobsToRemove.add(job);
    	            System.out.println("Job record marked for deletion!");
    	        }
    	    }

    	    // Remove the collected jobs
    	    jobs.removeAll(jobsToRemove);
    	    System.out.println(jobsToRemove.size() + " job(s) record deleted successfully!");

        for (Company company : companies) {
            if (company.getCompanyId().equalsIgnoreCase(companyId)) {
                companies.remove(company);
                System.out.println("Company record deleted successfully!");
                return;
            }
        }
        
    }


	public Company getCompanyById(String companyId) {
        for (Company company : companies) {
            if (company.getCompanyId().equalsIgnoreCase(companyId)) {
            	
            	 if (company != null) {
                     // Print company details
                     System.out.println("Company Details:");
                     System.out.println("Company ID: " + company.getCompanyId());
                     System.out.println("Company Name: " + company.getCompanyName());
                     System.out.println("Industry: " + company.getIndustry());
                     System.out.println("Location: " + company.getLocation());
                     
                 } else {
                     System.out.println("Company not found for ID: " + companyId);
                 }
                return company;
            }
        }
        return null; // Return null if company with given ID is not found
    }


	public void updateJob(String companyId) {
		
		for (Job job : jobs) {
            if (job.getCompanyId().equalsIgnoreCase(companyId)) {
            	
            	  for (Company company : companies) {
      	            if (company.getCompanyId().equalsIgnoreCase(companyId)) {
      		          
      	           
            	  System.out.println("Company Details:");
                  System.out.println("Company ID: " + company.getCompanyId());
                  System.out.println("Company Name: " + company.getCompanyName());
                  System.out.println("Industry: " + company.getIndustry());
                
                  Scanner scanner= new Scanner(System.in);
                  System.out.println("Enter new Job Title:");
                  String jobTitle = scanner.nextLine();
                  job.setJobTitle(jobTitle);

                  System.out.println("Enter New Description:");
                  String Description = scanner.nextLine();
                  job.setDescription(Description);
                  
                  System.out.println("Updated succesfully");
      	          }
                  }
                    	
                  
            }	
            
         }
		
	}

//	@Override
//	public List<Company> getRelatedJobs(String jobTitle) {
//		List<Company> matchingCompanyData = new ArrayList<>();
//        for (Job job : jobs) {
//        	 if (job.getJobTitle().equalsIgnoreCase(jobTitle)) {
//        		 String companyId= job.getCompanyId();
//        		 
//        		  for (Company company : companies) {
//        	            if (company.getCompanyId().equalsIgnoreCase(companyId)) {
//        		          matchingCompanyData.add(company);
//        	            }
//            }
//        }
//        return matchingCompanyData;
//	}
//	}

	@Override
	public String addJob(String companyId,String jobTitle,String description ) {
		// TODO Auto-generated method stub
		for (Company company : companies) {
            if (company.getCompanyId().equalsIgnoreCase(companyId)) {

                 
            	  Job job = new Job(companyId, jobTitle, description);
            	  jobs.add(job);
                  System.out.println("added succesfully");
                  
            }	
            
         }
		
		
		return null;
	}
	
	public List<Job> getJobById(String companyId) {
	    List<Job> jobById = new ArrayList<>();

	        	
	        	 for (Job job : jobs) {
	        		 if (job.getCompanyId().equalsIgnoreCase(companyId)) {
	        		 jobById.add(job);
	 	            
        		 }

	          }
	        	 return jobById;

	}
	
	@Override
	public Map<Job, Company> getPreferredJobs(String jobTitle) {
		
		List<Job> matchingJobData = new ArrayList<>();
		List<Company> matchingCompanyData = new ArrayList<>();
		

		
		for (Job job : jobs) {
            if (job.getJobTitle().equalsIgnoreCase(jobTitle)) {
                matchingJobData.add(job);
                
                // Find the corresponding company using companyId
                for (Company company : companies) {
                    if (company.getCompanyId().equals(job.getCompanyId())) {
                        matchingCompanyData.add(company);
                    }
                }
            }
        }
		 Map<Job, Company> preferredJobs = new HashMap<>();
	        
		 for (int i = 0; i < matchingJobData.size(); i++) {
	            preferredJobs.put(matchingJobData.get(i), matchingCompanyData.get(i));
	        }

	        return preferredJobs;
	}
}

