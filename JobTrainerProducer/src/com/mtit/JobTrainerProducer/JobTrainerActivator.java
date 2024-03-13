package com.mtit.JobTrainerProducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class JobTrainerActivator implements BundleActivator {

    ServiceRegistration serviceReference;

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Job Trainer Producer Started");
        JobTrainerProducer jobTrainerProducer = new JobTrainerProducerImpl();
        serviceReference = bundleContext.registerService(JobTrainerProducer.class.getName(), jobTrainerProducer, null);
    }


	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Job Trainer Producer Stopped");
//		jobTrainerServiceRegistration.unregister();
	}
}
