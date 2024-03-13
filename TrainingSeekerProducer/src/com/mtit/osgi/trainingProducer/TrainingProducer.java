package com.mtit.osgi.trainingProducer;

import java.util.List;

public interface TrainingProducer {
	String addTraining(String training_ID, String training_Name, String training_Email, String training_Type);

    void deleteTraining(String training_ID);

    List<Training> getAllTrainings();

    String updateTraining(String training_ID, String training_Name, String training_Email, String training_Type);

    Training getTraining(String training_ID);
}
