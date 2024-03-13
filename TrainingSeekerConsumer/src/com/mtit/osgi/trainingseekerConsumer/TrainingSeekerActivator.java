package com.mtit.osgi.trainingseekerConsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.JobTrainerProducer.JobTrainerProducer;
import com.mtit.osgi.trainingProducer.TrainingProducer;


public class TrainingSeekerActivator implements BundleActivator {

	ServiceReference trainingProducerReference;
    

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("TrainingSeeker Started");
        trainingProducerReference = bundleContext.getServiceReference(TrainingProducer.class.getName());
        var servReferenceJob = bundleContext.getServiceReference(JobTrainerProducer.class.getName());
        
        TrainingProducer trainingProducer = (TrainingProducer)bundleContext.getService(trainingProducerReference);
        JobTrainerProducer jobTrainerRef = (JobTrainerProducer) bundleContext.getService(servReferenceJob);
            TrainingSeeker trainingSeeker = new TrainingSeekerImpl();
            trainingSeeker.getService(trainingProducer,jobTrainerRef);
       
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("TrainingSeeker Stopped");
        if (trainingProducerReference != null) {
            bundleContext.ungetService(trainingProducerReference);
        }
	}

}
