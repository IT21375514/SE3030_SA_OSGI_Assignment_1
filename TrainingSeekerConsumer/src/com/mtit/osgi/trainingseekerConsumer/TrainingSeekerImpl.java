package com.mtit.osgi.trainingseekerConsumer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mtit.JobTrainerProducer.JobTrainer;
import com.mtit.JobTrainerProducer.JobTrainerProducer;
import com.mtit.osgi.trainingProducer.Training;
import com.mtit.osgi.trainingProducer.TrainingProducer;


public class TrainingSeekerImpl implements TrainingSeeker {
	private Scanner scanner = new Scanner(System.in);

    private static final String ADD = "add";
    private static final String VIEW = "view";
    private static final String EDIT = "edit";
    private static final String GET = "get";
    private static final String DELETE = "delete";
    private static final String STOP = "stop";

    @Override
    public void getService(TrainingProducer trainingProducer,JobTrainerProducer jobTrainerRef) {	
    	System.out.println();
    	System.out.println("=========== OpportunityNet ============");
    	System.out.println("===== Job and Training Exchange Platform ======");
    	System.out.println();
    	System.out.println("Training Seekers Details");
        System.out.println();
        System.out.println("-----Select an action from below:-----");
        System.out.println();
        System.out.println("Add Training Seeker Details: 'add'");
        System.out.println("View All Training Seekers' Details: 'view'");
        System.out.println("Edit Training Seeker Details: 'edit'");
        System.out.println("Delete Training Seeker Details: 'delete'");
        System.out.println("Get Training Details: 'get'");
        System.out.println();
        System.out.println("Stop: 'stop'");
        System.out.println();
        while (true) {
            String userInput = getUserInput();

            if(userInput.equalsIgnoreCase(ADD)) {
                    addTraining(trainingProducer);
            }
            else if (userInput.equalsIgnoreCase(VIEW)) {
                    viewAllTrainings(trainingProducer);
            }
            else if (userInput.equalsIgnoreCase(EDIT)) {
                    editTraining(trainingProducer);
            }
            else if (userInput.equalsIgnoreCase(GET)) {
            	filterRecords(trainingProducer,jobTrainerRef);
            }
            else if (userInput.equalsIgnoreCase(DELETE)) {
                    deleteTraining(trainingProducer);
            }
            else if (userInput.equalsIgnoreCase(STOP)) {
            	return;
            }
            else {
                    System.out.println("Invalid Action");
            }
        }
    }

    private void addTraining(TrainingProducer trainingProducer) {
        System.out.println();
        System.out.println("---Add Training Details---");
        System.out.println();
        System.out.println("Enter Training Seeker ID:");
        String training_ID = scanner.nextLine();
        System.out.println("Enter Training Seeker Name:");
        String training_Name = scanner.nextLine();
        System.out.println("Enter Training Seeker Email:");
        String training_Email = scanner.nextLine();
        System.out.println("Enter Training For:");
        String training_Type = scanner.nextLine();

        String result = trainingProducer.addTraining(training_ID, training_Name, training_Email, training_Type);
        System.out.println(result);
        System.out.println();
    }

    private void viewAllTrainings(TrainingProducer trainingProducer) {
        System.out.println();
        System.out.println("All Training Seekers' Details");
        System.out.println();
        List<Training> trainings = trainingProducer.getAllTrainings();
        for (Training training : trainings) {
            System.out.println("Training Seeker Name: " + training.getTraining_Name());
            System.out.println("Training Seeker Email: " + training.getTraining_Email());
            System.out.println("Training For: " + training.getTraining_Type());
            System.out.println();
        }
    }

    private void editTraining(TrainingProducer trainingProducer) {
        System.out.println();
        System.out.println("Edit Training Seeker Details");
        System.out.println("Enter Training Seeker's ID to be edited:");
        String training_ID = scanner.nextLine();
        Training training = trainingProducer.getTraining(training_ID);
        if (training == null) {
            System.out.println("Training Seeker with the given ID not found.");
            return;
        }
        System.out.println("Current Training Seeker Name: " + training.getTraining_Name());
        System.out.println("Enter New Training Seeker Name (or press Enter to keep current):");
        String newTrainingName = scanner.nextLine();
        if (!newTrainingName.isEmpty()) {
            training.setTraining_Name(newTrainingName);
        }
//        System.out.println("Current Trainer ID: " + training.getTrainer_ID());
//        System.out.println("Enter New Trainer ID (or press Enter to keep current):");
//        String newTrainerID = scanner.nextLine();
//        if (!newTrainerID.isEmpty()) {
//            training.setTrainer_ID(newTrainerID);
//        }
        System.out.println("Current Training Email: " + training.getTraining_Email());
        System.out.println("Enter New Training Email (or press Enter to keep current):");
        String newTrainingEmail = scanner.nextLine();
        if (!newTrainingEmail.isEmpty()) {
            training.setTraining_Email(newTrainingEmail);
        }
        System.out.println("Current Training For: " + training.getTraining_Type());
        System.out.println("Enter New Training For (or press Enter to keep current):");
        String newTraining_Type = scanner.nextLine();
        if (!newTraining_Type.isEmpty()) {
            training.setTraining_Type(training_ID);
        }
        String result = trainingProducer.updateTraining(training_ID, newTrainingName, newTrainingEmail, newTraining_Type);
        System.out.println(result);
        System.out.println();
    }

    private void deleteTraining(TrainingProducer trainingProducer) {
    	   	System.out.println();
    	    System.out.println("Delete Training Details");
    	    System.out.println("Enter Training ID to be deleted:");
    	    String training_ID = scanner.nextLine();
    	    trainingProducer.deleteTraining(training_ID); // Call the method without assigning the return value
    	    System.out.println("Training Seeker's Record Deleted Successfully!"); // Print success message directly
    	    System.out.println();
    }

    private String getUserInput() {
    	System.out.println();
        System.out.println("Enter your selection:");
        return scanner.nextLine().trim();
    }
    
    public void filterRecords( TrainingProducer trainingProducer, JobTrainerProducer jobTrainerProducer) {
   	 List<JobTrainer> jobTrainers = jobTrainerProducer.getAllJobTrainer();
   	List<Training> trainingSeekers= trainingProducer.getAllTrainings();

   	   System.out.println();
   	   System.out.println("Filter options:");
   	    System.out.println("1. Filter by Training Seeker Name");
   	    System.out.println("2. Filter by Training For");
   	    System.out.println("3. Return to main menu");
   	    System.out.println("Enter your choice:");
   	    String filterOption = scanner.nextLine().trim();
   	    	if(filterOption.equals("1")) {
   	            filterByTrainingSeekerName(trainingSeekers);
   	    	}  
   	    	else if(filterOption.equals("2")) {
   	            filterByTrainingFor(jobTrainerProducer);
   	    	}
   	    	else if(filterOption.equals("3")) {  
   	            return;
   	    	}
   	    	else {
   	            System.out.println("Invalid choice. Returning to main menu.");
   	    	}
   	    }
    
    private void filterByTrainingSeekerName(List<Training> trainingSeeker) {
	    System.out.println("Enter Training Seeker Name:");
	    String trainingSeekerName = scanner.nextLine().trim();
	    for (Training training : trainingSeeker) {
	        if (training.getTraining_Name().equalsIgnoreCase(trainingSeekerName)) {
	            System.out.println(training.getTraining_ID() +"\t " +" "+ training.getTraining_Name()+"\t " +" "+ training.getTraining_Email()+"\t " +" "+ training.getTraining_Type());
	        }
	    }
	}
    
    private void filterByTrainingFor(JobTrainerProducer jobTrainerProducer) {
        System.out.println();
        System.out.println("=========== Training Seeker ============");
        System.out.println();
        System.out.println("Enter Preferred Training Type:");
        String trainingType = scanner.nextLine().trim();

        List<JobTrainer> preferredTypeTrainers = jobTrainerProducer.getRelatedTrainingTypes(trainingType);

        if (preferredTypeTrainers.isEmpty()) {
            System.out.println("No trainers found for the preferred training type: " + trainingType);
            return;
        }

        System.out.println();
        System.out.println("=========== Preferred Trainers ============");
        System.out.println("Displaying Trainers for Preferred Training Type: " + trainingType);
        System.out.println();

        for (JobTrainer trainer : preferredTypeTrainers) {
            System.out.println("Trainer ID: " + trainer.getjobTrainer_ID());
            System.out.println("Trainer Name: " + trainer.getJobTrainer_Name());
            System.out.println("Training Type: " + trainer.getTrainer_type());
            System.out.println("Company: " + trainer.getTrainer_Company());
            System.out.println("Session Type: " + trainer.getTrainer_sessionType());
            System.out.println();
        }
    }
    
}
