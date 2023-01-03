package com.web.jobsentry.service;

import java.util.Map;

import com.web.jobsentry.dao.JobDetail;
import com.web.jobsentry.utils.Constants;
import com.web.jobsentry.utils.Descriptions;

public class JobService {

	public JobDetail getJobDetails(String location, String category) {
		
		JobDetail jobDetail = new JobDetail();
		Descriptions jobs = new Descriptions();
		Map<String, String> map = jobs.getData(category);
		if(map.containsKey(Constants.TITLE)) {
			 jobDetail.setTitle(map.get(Constants.TITLE));
			 jobDetail.setDescription(map.get(Constants.DESC));
			 jobDetail.setQualification(map.get(Constants.QUAL));
			 jobDetail.setResponsibility(map.get(Constants.RESP));
			 jobDetail.setLocation(location);
		} else {
			jobDetail.setError(Constants.ERROR);
		}
		
		 
		 return jobDetail;
	}
	
	

}
