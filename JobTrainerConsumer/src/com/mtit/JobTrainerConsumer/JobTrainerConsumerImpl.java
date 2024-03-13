package com.mtit.JobTrainerConsumer;

import java.util.List;
import java.util.Scanner;

import com.mtit.companyProducer.Company;
import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.JobTrainerProducer.JobTrainer;
import com.mtit.JobTrainerProducer.JobTrainerProducer;

public class JobTrainerConsumerImpl implements JobTrainerConsumer{
	String user_data;
	String jobTrainer_ID;
	String trainer_shift;
	String trainer_type;
	String trainer_sessionType;
	String jobTrainer_Name;
	String company;
	Scanner sc = new Scanner(System.in);
	private List<JobTrainer> jobTrainers;
	private List<Company> companies;
	
	
	public static final String ADD ="add";
	public static final String ALL ="all";
	public static final String GET ="get";
	public static final String EDIT ="edit";
	public static final String DELETE ="delete";
	public static final String STOP ="stop";

	@Override
	public void getService(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
	      System.out.println();
		System.out.println("=========== OpportunityNet ============");
    	System.out.println("===== Job and Training Exchange Platform ======");  
	      System.out.println();
    	System.out.println(" Job Trainer Record ");
	      System.out.println();
	      System.out.println("Select the action from below. ");
	      System.out.println();
	      System.out.println( "Add Job Training Details:         'Add'");
		   System.out.println("View All Job Training Details:    'All'");
		   System.out.println("Edit Job Training Details:        'Edit'");
		   System.out.println("Get Job Trainer Details:          'Get'");
		   System.out.println("Delete a Job Training Details:    'Delete'");
		      System.out.println();
		   System.out.println("Stop Viewing Details:             'Stop'");
	      
	      while (true) {
	            String userInput = getUserInput();

	            if(userInput.equalsIgnoreCase(ADD)) {
	                    addJobTrainer(jobTrainerProducer);
	            }
	            else if (userInput.equalsIgnoreCase(ALL)) {
	                    getAllRecords(jobTrainerProducer, companyProducer);
	            }
	            else if (userInput.equalsIgnoreCase(EDIT)) {
	                	editRecord(jobTrainerProducer);
	            }
	            else if (userInput.equalsIgnoreCase(GET)) {
	            		filterRecords(jobTrainerProducer,companyProducer);         		
	            }
	            else if (userInput.equalsIgnoreCase(DELETE)) {
	                    deleteRecord(jobTrainerProducer);
	            }
	            else if (userInput.equalsIgnoreCase(STOP)) {
	                return;
	            }
	            else {
	                    System.out.println("Invalid Action");
	            }
	        }
		
	}

private void addJobTrainer(JobTrainerProducer jobTraainerProducer) {
	   System.out.println();
	   System.out.println(" Job Trainer Details ");
	   
	   System.out.println();
	   System.out.println("Enter Job Trainer ID:");
	   jobTrainer_ID = sc.nextLine();
	   
	   System.out.println("Enter Job Trainer Name:");
	   jobTrainer_Name= sc.nextLine();
	   
	   System.out.println("Enter Job Trainer Shift");
	   trainer_shift= sc.nextLine();

	   System.out.println("Enter Training Type:");
	   trainer_type = sc.nextLine();
	   
	   System.out.println("Enter Job Trainer Company:");
	   company = sc.nextLine();
	   
	   System.out.println("Enter Job Trainer Session Type:");
	   trainer_sessionType = sc.nextLine();
	     
	   String temp = jobTraainerProducer.addJobTrainer(jobTrainer_ID, jobTrainer_Name, trainer_sessionType, trainer_type, trainer_shift, company);
	    System.out.println(temp);
	    System.out.println();
		
	}

private String getUserInput() {
    System.out.println("Enter your choice:");
    return sc.nextLine().trim();
}


public void getAllRecords(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
    List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
    List<Company> companies = companyProducer.getAllCompanies();
    System.out.println();
    System.out.println("Job Trainer Details");
    System.out.println();
    System.out.println("Displaying all Job Trainer Details");
    System.out.println();



    for (int i = 0; i < jobTrainers.size(); i++) {
        JobTrainer jobTrain = jobTrainers.get(i);
        Company company = null; // Initialize company to null

        if (i < companies.size()) {
            company = companies.get(i); // Get the company at the current index
        }
        System.out.println(); 
        System.out.println(jobTrain.getjobTrainer_ID());
        System.out.println(jobTrain.getJobTrainer_Name());
        System.out.println(jobTrain.getTrainer_Company());
        System.out.println(jobTrain.getTrainer_type());
        System.out.println(jobTrain.getTrainer_shift());
        System.out.println(jobTrain.getTrainer_sessionType());
        System.out.println(company != null ? company.getLocation() : "null");
        System.out.println(company != null ? company.getIndustry() : "null");
        System.out.println();
    }
}


 public void filterRecords(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
	 List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
	    List<Company> companies = companyProducer.getAllCompanies();
	   System.out.println();
	   System.out.println("Filter options:");
	    System.out.println("1. Filter by Trainer Name");
	    System.out.println("2. Filter by Training Type");
	    System.out.println("3. Filter by Company");
	    System.out.println("4. Filter by Session Type");
	    System.out.println("5. Return to main menu");
	    System.out.println("Enter your choice:");
	    String filterOption = sc.nextLine().trim();
	    	if(filterOption.equals("1")) {
	            filterByTrainerName(jobTrainerProducer,companyProducer);
	    	}  
	    	else if(filterOption.equals("2")) {
	    		
	            filterByTrainingType(jobTrainerProducer, companyProducer);
	    	}
	    	else if(filterOption.equals("3")) {
	    		    filterByCompany(jobTrainerProducer, companyProducer);
	    	}
	    	else if(filterOption.equals("4")) {  
	    		filterBySessionType(jobTrainerProducer,companyProducer);
	    	}
	    	else if(filterOption.equals("5")) {  
	            return;
	    	}
	    	else {
	            System.out.println("Invalid choice. Returning to main menu.");
	    	}
	    }
 
 private void filterByTrainerName(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
	    List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
	    List<Company> companies = companyProducer.getAllCompanies();
	    System.out.println("Enter Trainer Name:");
	    String trainerName = sc.nextLine().trim();
	    for (int i = 0; i < jobTrainers.size(); i++) {
	        JobTrainer jobTrain = jobTrainers.get(i);
	        Company company = null; 

	        if (i < companies.size()) {
	            company = companies.get(i); 
	        }
	        if (jobTrain.getJobTrainer_Name().equalsIgnoreCase(trainerName)) {
	        	 System.out.println(jobTrain.getjobTrainer_ID());
	             System.out.println(jobTrain.getJobTrainer_Name());
	             System.out.println(jobTrain.getTrainer_Company());
	             System.out.println(jobTrain.getTrainer_type());
	             System.out.println(jobTrain.getTrainer_shift());
	             System.out.println(jobTrain.getTrainer_sessionType());
	             System.out.println(company != null ? company.getLocation() : "null");
	             System.out.println(company != null ? company.getIndustry() : "null");   
	        	 System.out.println();
	        }
	    }
	}

 private void filterByTrainingType(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
	    List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
	    List<Company> companies = companyProducer.getAllCompanies();
	    System.out.println("Enter Training Type:");
	    String trainingType = sc.nextLine().trim();

	    for (int i = 0; i < jobTrainers.size(); i++) {
	        JobTrainer jobTrain = jobTrainers.get(i);
	        Company company = null; 

	        if (i < companies.size()) {
	            company = companies.get(i); 
	        }
	        if (jobTrain.getTrainer_type().equalsIgnoreCase(trainingType)) {
	        	System.out.println(jobTrain.getjobTrainer_ID());
	            System.out.println(jobTrain.getJobTrainer_Name());
	            System.out.println(jobTrain.getTrainer_Company());
	            System.out.println(jobTrain.getTrainer_type());
	            System.out.println(jobTrain.getTrainer_shift());
	            System.out.println(jobTrain.getTrainer_sessionType());
	            System.out.println(company != null ? company.getLocation() : "null");
	            System.out.println(company != null ? company.getIndustry() : "null");
	            System.out.println();
	        }
	    }
	}

	private void filterByCompany(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
	    List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
	    List<Company> companies = companyProducer.getAllCompanies();
	    System.out.println("Enter Company:");
	    String company_input = sc.nextLine().trim();
	    System.out.println("ID\tName\tCompany\tType\tShift\tSession Type\tCompany Location\t Industry");
	    for (int i = 0; i < jobTrainers.size(); i++) {
	        JobTrainer jobTrain = jobTrainers.get(i);
	        Company company = null; 

	        if (i < companies.size()) {
	            company = companies.get(i); 
	        }
	        if (jobTrain.getTrainer_Company().equalsIgnoreCase(company_input)) {
	        	System.out.println(jobTrain.getjobTrainer_ID());
	            System.out.println(jobTrain.getJobTrainer_Name());
	            System.out.println(jobTrain.getTrainer_Company());
	            System.out.println(jobTrain.getTrainer_type());
	            System.out.println(jobTrain.getTrainer_shift());
	            System.out.println(jobTrain.getTrainer_sessionType());
	            System.out.println(company != null ? company.getLocation() : "null");
	            System.out.println(company != null ? company.getIndustry() : "null");
	    			}
	    		}
	    	}   

	private void filterBySessionType(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyProducer) {
	    List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
	    List<Company> companies = companyProducer.getAllCompanies();
	    System.out.println("Enter Session Type:");
	    String sessionType = sc.nextLine().trim();
	    System.out.println("ID\tName\tCompany\tType\tShift\tSession Type");
	    for (int i = 0; i < jobTrainers.size(); i++) {
	        JobTrainer jobTrain = jobTrainers.get(i);
	        Company company = null; 

	        if (i < companies.size()) {
	            company = companies.get(i); 
	        }
	        if (jobTrain.getTrainer_sessionType().equalsIgnoreCase(sessionType)) {
	        	System.out.println(jobTrain.getjobTrainer_ID());
	            System.out.println(jobTrain.getJobTrainer_Name());
	            System.out.println(jobTrain.getTrainer_Company());
	            System.out.println(jobTrain.getTrainer_type());
	            System.out.println(jobTrain.getTrainer_shift());
	            System.out.println(jobTrain.getTrainer_sessionType());
	            System.out.println(company != null ? company.getLocation() : "null");
	            System.out.println(company != null ? company.getIndustry() : "null");
	    			}
	    		}
	        }
	
 private void deleteRecord(JobTrainerProducer jobTrainerProducer) {
		String trainer_ID;
	
		System.out.println("Job Trainer Details");
		System.out.println();
		System.out.println("Enter Job Trainer ID to be deleted: ");
		trainer_ID = sc.nextLine();
		jobTrainerProducer.deleteJobTrainer(trainer_ID);
		System.out.println();
	}
		
 private void editRecord(JobTrainerProducer jobTrainerProducer) {
	    String trainer_ID;
	    
	    System.out.println("Enter Job Trainer ID to be edited: ");
	    trainer_ID = sc.nextLine();
	    
	    // Checking the provided ID exists
	    JobTrainer jobTrainer = jobTrainerProducer.getJobTrainer(trainer_ID);
	    if (jobTrainer == null) {
	        System.out.println("Job Trainer ID not found.");
	        return;
	    }
	    
	    // Display current details
	    System.out.println("Current Job Trainer Details:");
	    System.out.println("ID: " + jobTrainer.getjobTrainer_ID());
	    System.out.println("Name: " + jobTrainer.getJobTrainer_Name());
	    System.out.println("Shift: " + jobTrainer.getTrainer_shift());
	    System.out.println("Type: " + jobTrainer.getTrainer_type());
	    System.out.println("Session type: " + jobTrainer.getTrainer_sessionType());
	    System.out.println("Company: " + jobTrainer.getTrainer_Company());
	    System.out.println();
	    
	    // Prompt user for new details
	    System.out.println("Enter new Job Trainer Name (leave blank to keep current):");
	    String newTrainerName = sc.nextLine();
	    
	    System.out.println("Enter new Job Trainer Shift (leave blank to keep current):");
	    String newShift = sc.nextLine();
	    
	    System.out.println("Enter new Job Trainer Training Type (leave blank to keep current):");
	    String newType = sc.nextLine();
	    
	    System.out.println("Enter new Job Trainer Session Type (leave blank to keep current):");
	    String newSessionType = sc.nextLine();
	    
	    System.out.println("Enter new Job Trainer Company (leave blank to keep current):");
	    String newCompany = sc.nextLine();
	    
	    // Call the producer method to update the record
	    String result = jobTrainerProducer.updateJobTrainer(trainer_ID, newTrainerName, newShift, newType,newSessionType, newCompany);
	    System.out.println(result);
	    System.out.println();
	}
 


}
