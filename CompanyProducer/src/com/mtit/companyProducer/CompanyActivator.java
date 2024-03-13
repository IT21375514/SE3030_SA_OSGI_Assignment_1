package com.mtit.companyProducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CompanyActivator implements BundleActivator {

    ServiceRegistration companyServiceRegistration;

    public void start(BundleContext context) throws Exception {
        System.out.println("Company Publisher Started");
        CompanyPublisher companyPublisher = new CompanyPublishImpl();
        companyServiceRegistration = context.registerService(CompanyPublisher.class.getName(), companyPublisher, null);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Company Publisher Stopped");
        companyServiceRegistration.unregister();
    }

}
