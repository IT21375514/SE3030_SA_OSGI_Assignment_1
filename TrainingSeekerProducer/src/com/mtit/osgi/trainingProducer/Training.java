package com.mtit.osgi.trainingProducer;

public class Training {
	private String training_ID;
    private String training_Name;
    private String training_Email;
    private String trainer_ID;
    private String training_Type;
    
    
    public Training(String training_ID, String training_Name, String training_Email, String training_Type ) {
        super();
    	this.training_ID = training_ID;
        this.training_Name = training_Name;
        this.training_Email = training_Email;
//        this.trainer_ID = trainer_ID;
        this.training_Type = training_Type;
        
    }
    
    
    //Getters
	public String getTraining_ID() {
		return training_ID;
	}

	public String getTraining_Name() {
		return training_Name;
	}
	
	public String getTrainer_ID() {
		return trainer_ID;
	}
	
	public String getTraining_Email() {
		return training_Email;
	}
	
	public String getTraining_Type() {
		return training_Type;
	}
	
	
	//Setters
	public void setTraining_ID(String training_ID) {
		this.training_ID = training_ID;
	}
	public void setTraining_Name(String training_Name) {
		this.training_Name = training_Name;
	}
	
	public void setTrainer_ID(String trainer_ID) {
		this.trainer_ID = trainer_ID;
	}

	public void setTraining_Email(String training_Email) {
		this.training_Email = training_Email;
	}

	public void setTraining_Type(String training_Type) {
		this.training_Type = training_Type;
	}
	
}
