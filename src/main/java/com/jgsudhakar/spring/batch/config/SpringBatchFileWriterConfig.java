/**
 * 
 */
package com.jgsudhakar.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;
import com.jgsudhakar.spring.batch.itemprocessor.StudentItemProcessor;
import com.jgsudhakar.spring.batch.itemreader.StudentItemReader;
import com.jgsudhakar.spring.batch.itemwriter.StudentItemWriteToFile;
import com.jgsudhakar.spring.batch.listener.JobProcessListener;
import com.jgsudhakar.spring.batch.listener.JobReaderListener;
import com.jgsudhakar.spring.batch.listener.JobStatusListerner;
import com.jgsudhakar.spring.batch.listener.JobWriterListener;
import com.jgsudhakar.spring.batch.service.StudentService;

/**
 * @Author : Sudhakar Tangellapalli
 * @File   : com.jgsudhakar.spring.batch.config.SpringBatchFileWriterConfig.java
 * @Date   : 2021-10-09
 */
@Configuration
public class SpringBatchFileWriterConfig {


	@Autowired
	public JobBuilderFactory jobFileWriterFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private StudentService service;

	/**
	 * Job To configure the flow of execution with listerner configuration
	 * @return
	 */
	@Bean
	@Qualifier("writeToFile")
	public Job writeToFile() {
		return jobFileWriterFactory
				.get("writeToFile")
				.incrementer(new RunIdIncrementer())
				.listener(listener()) // job status listener
				.listener(jobFileWriterFactory)
				.flow(writeToFileStep())
				.end()
				.build();
	}

	@Bean
	public Step writeToFileStep() {
		return stepBuilderFactory.get("writeToFile") // Step name
				.<StudentResponseDto, StudentResponseDto>chunk(2) // Iterm Processor Input and output Classes
				.reader(new StudentItemReader(service)) // Item Reader class
				.processor(new StudentItemProcessor()) // Item Processor class
				.writer(new StudentItemWriteToFile()) // Item Writer class
				.listener(readListener()) // read listener
				.listener(processListener()) // process listener
				.listener(writeListener()) // write listener
				.build();
	}

	/**
	 * This is to Listen to the job status
	 * 
	 * @return
	 */
	@Bean
	public JobExecutionListener listener() {
		return new JobStatusListerner();
	}
	/**
	 * This is to Listen to the job status
	 * 
	 * @return
	 */
	@Bean
	public JobReaderListener readListener() {
		return new JobReaderListener();
	}
	/**
	 * This is to Listen to the job processing 
	 * 
	 * @return
	 */
	@Bean
	public JobProcessListener processListener() {
		return new JobProcessListener();
	}
	/**
	 * This is to Listen to the job writing
	 * 
	 * @return
	 */
	@Bean
	public JobWriterListener writeListener() {
		return new JobWriterListener();
	}


}
