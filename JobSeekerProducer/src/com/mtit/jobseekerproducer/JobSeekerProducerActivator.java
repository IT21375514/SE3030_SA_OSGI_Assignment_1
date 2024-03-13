package com.mtit.jobseekerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class JobSeekerProducerActivator implements BundleActivator {

//	private static BundleContext context;
	ServiceRegistration jobSeekerServiceRegistration;

//	static BundleContext getContext() {
//		return context;
//	}

	
	public void start(BundleContext context) throws Exception {
		   System.out.println("Job Seeker Producer Started");
            JobSeekerProduce jobSeekerProduce = new JobSeekerProduceImpl();
            jobSeekerServiceRegistration = context.registerService(JobSeekerProduce.class.getName(), jobSeekerProduce, null);		
	}

	public void stop(BundleContext Context) throws Exception {
		   System.out.println("Job Seeker Producer Stopped");
		
	}

}
