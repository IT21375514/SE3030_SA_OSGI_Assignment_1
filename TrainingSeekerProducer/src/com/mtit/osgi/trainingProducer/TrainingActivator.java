package com.mtit.osgi.trainingProducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TrainingActivator implements BundleActivator {

	ServiceRegistration<TrainingProducer> trainingProducerServiceRegistration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		 System.out.println("Training Producer Started");
	        TrainingProducer trainingProducer = new TrainingProducerImpl();
	        trainingProducerServiceRegistration = bundleContext.registerService(TrainingProducer.class, trainingProducer, null);	
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		 System.out.println("Training Producer Stopped");
	     trainingProducerServiceRegistration.unregister();	
	}

}
