package com.apress.springenterpriserecipes.springbatch.solution1;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Throwable {
		ClassPathXmlApplicationContext classPathXmlApplicationContext =
                        new ClassPathXmlApplicationContext("solution2.xml");
		classPathXmlApplicationContext.start();
		JobLauncher jobLauncher = (JobLauncher) classPathXmlApplicationContext.getBean("jobLauncher");
		Job job = (Job) classPathXmlApplicationContext.getBean("insertIntoDbFromCsvJob");
		jobLauncher.run(job, new JobParametersBuilder().addDate("date", new Date())
				.addString("input.file", "registrations" ).toJobParameters());
	}
}
