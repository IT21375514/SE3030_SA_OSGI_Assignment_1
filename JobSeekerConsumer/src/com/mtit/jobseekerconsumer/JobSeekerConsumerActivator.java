package com.mtit.jobseekerconsumer;

import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.jobseekerproducer.JobSeekerProduce;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class JobSeekerConsumerActivator implements BundleActivator {

//	private static BundleContext context;
//
//	static BundleContext getContext() {
//		return context;
//	}
//
//	public void start(BundleContext bundleContext) throws Exception {
//		JobSeekerConsumerActivator.context = bundleContext;
//	}
//
//	public void stop(BundleContext bundleContext) throws Exception {
//		JobSeekerConsumerActivator.context = null;
//	}
	ServiceReference serviceReference;
    Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
			System.out.println("Job Seeker Consumer Started");
	          serviceReference = context.getServiceReference(JobSeekerProduce.class.getName());
	          var sr2 = context.getServiceReference(CompanyPublisher.class.getName());

	          JobSeekerProduce jobSeekerProduce = (JobSeekerProduce)context.getService(serviceReference);
	          CompanyPublisher companyPublish = (CompanyPublisher)context.getService(sr2);

	          JobSeekerConsume jobSeekerConsume = new JobSeekerConsumeImpl();
	          jobSeekerConsume.getService(jobSeekerProduce,companyPublish);     
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Job Seeker Consumer Stopped");
	}
}
