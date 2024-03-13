package com.mtit.osgi.trainingProducer;

import java.util.ArrayList;
import java.util.List;

public class TrainingProducerImpl implements TrainingProducer  {

	private List<Training> trainings = new ArrayList<>();
	
	@Override
	public String addTraining(String training_ID, String training_Name, String training_Email,
			String training_Type) {
		Training training = new Training(training_ID, training_Name, training_Email, training_Type);
        trainings.add(training);
        return "New Training Seeker has been added! \n " +"Training Seeker " +training.getTraining_Name() + " added by Trainer " + training.getTrainer_ID() + " at Training Type " + training.getTraining_Email() + " for " + training.getTraining_Type();
	}

	@Override
	public void deleteTraining(String training_ID) {
	      for (Training training : trainings) {
	            if (training.getTraining_ID().equalsIgnoreCase(training_ID)) {
	                trainings.remove(training);
	                System.out.println("Training Seeker's Record Deleted Successfully!");
	                return;
	            }
	        }
	}

	@Override
	public List<Training> getAllTrainings() {
		return trainings;
	}

	@Override
	public String updateTraining(String training_ID, String training_Name, String training_Email,
			String training_Type) {
		for (Training training : trainings) {
            if (training.getTraining_ID().equalsIgnoreCase(training_ID)) {
                if (!training_Name.isEmpty()) {
                    training.setTraining_Name(training_Name);
                }
                if (!training_Email.isEmpty()) {
                    training.setTraining_Email(training_Email);
                }
                if (!training_Type.isEmpty()) {
                    training.setTraining_Type(training_Type);
                }
                return "Training Seeker's Record Updated Successfully!";
            }
        }
        return "Training Seeker ID not found.";
	}

	@Override
	public Training getTraining(String training_ID) {
		for (Training training : trainings) {
            if (training.getTraining_ID().equalsIgnoreCase(training_ID)) {
                return training;
            }
        }
        return null;
    }

}
