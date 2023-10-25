/**
 * 
 */
package com.jgsudhakar.spring.batch.listener;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.listener.JobStatusListerner.java
 * @Date : 2021-10-05
 */
@Log4j2
public class JobStatusListerner extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info(":: Job Execution done, and the staus is ::");
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}else if(jobExecution.getStatus() == BatchStatus.FAILED){
            System.out.println(":: Job failed with following exceptions ");
            List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
            for(Throwable th : exceptionList){
                System.err.println("exception :" +th.getLocalizedMessage());
            }
        }
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info(":: Job Execution started, and the JobId is ::"+jobExecution.getJobId());
	}
}
