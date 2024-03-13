package com.mtit.companyConsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.jobseekerproducer.JobSeeker;
import com.mtit.jobseekerproducer.JobSeekerProduce;

public class CompanyActivator implements BundleActivator {

    ServiceReference serviceReference;
    ServiceReference serviceReference2;
    
    Scanner scanner = new Scanner(System.in);

    public void start(BundleContext context) throws Exception {
        System.out.println("Started Company Subscriber");
        serviceReference = context.getServiceReference(CompanyPublisher.class.getName());
        serviceReference2 = context.getServiceReference(JobSeekerProduce.class.getName());
        
        CompanyPublisher companyPublisher = (CompanyPublisher) context.getService(serviceReference);        
        JobSeekerProduce jobseekeProducer = (JobSeekerProduce) context.getService(serviceReference2);
     
        CompanySubscriber companySubscriber = new CompanySubscriberImpl();
        companySubscriber.getService(companyPublisher,jobseekeProducer);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Stopped Company Subscriber");
    }
}
