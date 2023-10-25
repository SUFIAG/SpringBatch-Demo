package com.jgsudhakar.spring.batch.api;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;
import com.jgsudhakar.spring.batch.service.StudentService;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/api/student")
@RestController
@Log4j2
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job processJob;

	@Qualifier("writeToFile")
	@Autowired
	private Job writeToFile;

	@GetMapping("/{name}")
	public String sayHi(@PathVariable(name = "name", required = true) String name) {
		return "Welcome " + name + ". Hope you are doing Good :)";
	}

	@GetMapping("/retrieve")
	public List<StudentResponseDto> fetchStudentlistExample() {
		log.info(":: In the Fetch Student List Method ::");
		return service.fetchStuList();
	}

	@GetMapping("/processbatch")
	public String processBatch() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);
        
        return ":) Job Started Successfully ! :)";
	}
	
	@GetMapping("/processbatchtofile")
	public String processbatchtofile() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder().addLong("dateTime", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(writeToFile, jobParameters);
		
		return ":) Job Started Successfully ! :)";
	}

}
