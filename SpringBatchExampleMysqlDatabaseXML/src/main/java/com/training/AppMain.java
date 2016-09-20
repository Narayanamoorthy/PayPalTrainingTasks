package com.training;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
public static void main(String[] args) {
	AppMain app = new AppMain();
	app.run();
			
}

public void run()
{
	String[] springConfig = { "spring/batch/job/job-extract-users.xml" };
ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
Job job = (Job)context.getBean("testJob");

try {
	JobParameters param = new JobParametersBuilder().addString("numofrivers", "2").toJobParameters();
	JobExecution execution;
	execution = joblauncher.run(job, param);
	System.out.println("Exit Status : " + execution.getStatus());
	System.out.println("Exit Status : " + execution.getAllFailureExceptions());
} catch (JobExecutionAlreadyRunningException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JobRestartException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JobInstanceAlreadyCompleteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JobParametersInvalidException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



}
}
