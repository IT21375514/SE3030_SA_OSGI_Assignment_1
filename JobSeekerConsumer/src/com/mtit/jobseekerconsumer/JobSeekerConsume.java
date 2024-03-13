package com.mtit.jobseekerconsumer;

import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.jobseekerproducer.JobSeekerProduce;

public interface JobSeekerConsume {
	  public void getService(JobSeekerProduce jobSeekerProduce, CompanyPublisher companyPublish);
}