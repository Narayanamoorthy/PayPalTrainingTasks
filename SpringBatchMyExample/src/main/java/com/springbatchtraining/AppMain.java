package com.springbatchtraining;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring/batch/jobs/job-my-hello-world.xml" );
	JobLauncher joblauncher = (JobLauncher)context.getBean("jobLauncher");
	Job job = (Job)context.getBean("helloworldjob");
	JobExecution jobexcecution;
	try {
		jobexcecution = joblauncher.run(job, new JobParameters());
		System.out.println("job name ::: " + job.getName() + "   job status :::" + jobexcecution.getStatus());
		
	} catch (JobExecutionAlreadyRunningException e) {
		e.printStackTrace();
	} catch (JobRestartException e) {
		e.printStackTrace();
	} catch (JobInstanceAlreadyCompleteException e) {
		e.printStackTrace();
	} catch (JobParametersInvalidException e) {
		e.printStackTrace();
	}
	System.out.println("Batch is done");
	
	}
}
