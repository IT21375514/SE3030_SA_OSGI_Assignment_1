package com.mtit.osgi.trainingseekerConsumer;

import com.mtit.JobTrainerProducer.JobTrainerProducer;
import com.mtit.osgi.trainingProducer.TrainingProducer;

public interface TrainingSeeker {
	void getService(TrainingProducer trainingProducer, JobTrainerProducer jobTrainerRef);
}
