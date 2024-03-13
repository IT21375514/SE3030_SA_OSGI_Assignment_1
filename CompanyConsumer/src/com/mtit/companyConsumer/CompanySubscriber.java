package com.mtit.companyConsumer;


import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.jobseekerproducer.JobSeekerProduce;

public interface CompanySubscriber {
    void getService(CompanyPublisher companyPublisher,JobSeekerProduce jobseekeProducer);
}
