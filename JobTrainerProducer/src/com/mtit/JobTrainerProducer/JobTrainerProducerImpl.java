package com.mtit.JobTrainerProducer;

import java.util.ArrayList;
import java.util.List;

public class JobTrainerProducerImpl implements JobTrainerProducer{
	public List<JobTrainer> JobTrainers = new ArrayList<JobTrainer>();

	@Override
	public String addJobTrainer(String jobTrainer_ID, String jobTrainer_Name, String trainer_sessionType, String trainer_type, String trainer_shift, String company){
		JobTrainer JobTrain = new JobTrainer(jobTrainer_ID, jobTrainer_Name,trainer_sessionType, trainer_type, trainer_shift,company );
		JobTrainers.add(JobTrain);
		return "New Trainer: " + JobTrain.getJobTrainer_Name() + " at " + JobTrain.getTrainer_Company() +" " + "in " + JobTrain.getTrainer_shift()  +" " + "to train " + JobTrain.getTrainer_type()+ " entered successfully!";
	}

	@Override
	public void deleteJobTrainer(String jobTrainer_ID) {
		for(JobTrainer JobTrainer : JobTrainers) {
	    	if(JobTrainer.getjobTrainer_ID().equalsIgnoreCase(jobTrainer_ID)) {
	    		int id =JobTrainers.indexOf(JobTrainer);
	    		JobTrainers.remove(id);
	    		System.out.println(" JobTraining Record deleted Successfully!");
	    		return ;
	    	}
	    }
		
	}

	@Override
	public List<JobTrainer> getAllJobTrainer() {
		// TODO Auto-generated method stub
		return JobTrainers;
	}

	@Override
	public String updateJobTrainer(String trainer_ID, String newTrainerName, String newShift, String newSessionType, String newType, String newCompany) {
	    for (JobTrainer jobTrainer : JobTrainers) {
	        if (jobTrainer.getjobTrainer_ID().equalsIgnoreCase(trainer_ID)) {
	            // Update job trainer record with new & updated values
	            if (!newTrainerName.isEmpty()) {
	                jobTrainer.setJobTrainer_Name(newTrainerName);// Corrected parameter
	            }
	            if (!newShift.isEmpty()) {
	                jobTrainer.setTrainer_shift(newShift);// Corrected parameter
	            }
	            if (!newType.isEmpty()) {
	                jobTrainer.setTrainer_type(newType); // Corrected parameter
	            }
	            if (!newSessionType.isEmpty()) {
	                jobTrainer.setTrainer_sessionType(newSessionType); // Corrected parameter
	            }
	            
	            if (!newCompany.isEmpty()) {
	                jobTrainer.setTrainer_Company(newCompany); // Corrected parameter
	            }
	            return "Job Training record updated successfully!";
	        }
	    }
	    return "Job Training ID not found.";
	}
	
	public JobTrainer getJobTrainer(String jobTrainer_ID) {
        for (JobTrainer jobTrainer : JobTrainers) {
            if (jobTrainer.getjobTrainer_ID().equalsIgnoreCase(jobTrainer_ID)) {
                return jobTrainer;
            }
        }
        return null; // Return null if not found
    }
	@Override
	public List<JobTrainer> getRelatedTrainingTypes(String trainer_type) {
		List<JobTrainer> matchingTrainerData = new ArrayList<>();
        for (JobTrainer trainer : JobTrainers) {
        	 if (trainer.getTrainer_type().equalsIgnoreCase(trainer_type)) {
        		 matchingTrainerData.add(trainer);
            }
        }
        return matchingTrainerData;
	}
	
}
