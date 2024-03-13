package com.mtit.companyProducer;

import java.util.List;
import java.util.Map;

public interface CompanyPublisher {
    
    String addCompany(String companyId, String companyName, String industry, String location);

    void deleteCompany(String companyId);

    List<Company> getAllCompanies();
    
    Company getCompanyById(String companyId);
    
    List<Job> getJobById(String companyId);
    
    String addJob(String companyId,String jobTitle,String description );
    
    void updateJob(String companyId);
    
    public Map<Job, Company> getPreferredJobs(String jobTitle);
    
   // public List<Company> getRelatedJobs(String jobTitle);
}
