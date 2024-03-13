package com.mtit.JobTrainerProducer;

import java.util.List;

public interface JobTrainerProducer {
	public	String addJobTrainer(String jobTrainer_ID, String jobTrainer_Name, String trainer_sessionType, String trainer_type, String trainer_shift, String company);
	public void deleteJobTrainer(String jobTrainer_ID);
	public List<JobTrainer> getAllJobTrainer();
	public String updateJobTrainer(String jobTrainer_ID, String jobTrainer_Name, String trainer_sessionType, String trainer_type, String trainer_shift, String company);
	public JobTrainer getJobTrainer(String jobTrainer_ID);
	public List<JobTrainer> getRelatedTrainingTypes(String trainingType);
}
