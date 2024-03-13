package com.mtit.JobTrainerConsumer;

import com.mtit.companyProducer.CompanyPublisher;
import com.mtit.JobTrainerProducer.JobTrainerProducer;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class JobTrainerActivator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner sc = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Job Trainer Consumer Started ");
		serviceReference = context.getServiceReference(JobTrainerProducer.class.getName());
		var servRef2= context.getServiceReference(CompanyPublisher.class.getName());
		
		JobTrainerProducer jobTrainerProducer = (JobTrainerProducer)context.getService(serviceReference);
		CompanyPublisher companyPublisher = (CompanyPublisher) context.getService(servRef2);
		
	    JobTrainerConsumer jobTrainerConsumer = new JobTrainerConsumerImpl();
	    jobTrainerConsumer.getService(jobTrainerProducer,companyPublisher);     
}
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Job Trainer Consumer Stopped");
	}

}
