package com.mtit.JobTrainerConsumer;



import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.JobTrainerProducer.JobTrainerProducer;


public interface JobTrainerConsumer {
	public void getService(JobTrainerProducer jobTrainerProducer, CompanyPublisher companyPublisher);
//	public void getService(JobTrainerProducer jobTrainerProducer);
}
