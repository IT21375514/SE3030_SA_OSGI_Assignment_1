package com.mtit.JobTrainerProducer;

public class JobTrainer {
	private String jobTrainer_ID;
	private String jobTrainer_Name;
	private String trainer_sessionType;
	private String trainer_shift;
	private String trainer_type;
	private String company;
	

	
	public JobTrainer(String jobTrainer_ID,String jobTrainer_Name, String trainer_sessionType,String trainer_type, String trainer_shift, String company) {
		super();
		this.jobTrainer_ID = jobTrainer_ID;
		this.jobTrainer_Name=jobTrainer_Name;
		this.trainer_sessionType = trainer_sessionType;
		this.trainer_shift = trainer_shift;
		this.trainer_type =trainer_type;
		this.company =company;
		
		
	}
	//Getters
	public String getjobTrainer_ID() {
		return jobTrainer_ID;
	}
	public String getTrainer_sessionType() {
		return trainer_sessionType;
	}
	public String getJobTrainer_Name() {
		return jobTrainer_Name;
	}
	public String getTrainer_shift() {
		return trainer_shift;
	}
	public String getTrainer_type() {
		return trainer_type;
	}
	public String getTrainer_Company() {
		return company;
	}
	
	//Setters
	public void setjobTrainer_ID(String jobTrainer_ID) {
		this.jobTrainer_ID = jobTrainer_ID;
	}
	public void setJobTrainer_Name(String jobTrainer_Name) {
		this.jobTrainer_Name = jobTrainer_Name;
	}
	public void setTrainer_sessionType(String trainer_sessionType) {
		this.trainer_sessionType = trainer_sessionType;
	}
	public void setTrainer_type(String trainer_type) {
		this.trainer_type = trainer_type;
	}
	public void setTrainer_shift(String trainer_shift) {
		this.trainer_shift = trainer_shift;
	}
	public void setTrainer_Company(String company) {
		this.company = company;
	}
}
