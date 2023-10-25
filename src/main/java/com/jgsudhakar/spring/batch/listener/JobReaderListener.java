/**
 * 
 */
package com.jgsudhakar.spring.batch.listener;

import org.springframework.batch.core.ItemReadListener;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File   : com.jgsudhakar.spring.batch.listener.JobReaderListener.java
 * @Date   : 2021-10-06
 */
@Log4j2	
public class JobReaderListener implements ItemReadListener<StudentResponseDto>{

	@Override
	public void beforeRead() {
		log.info(":: Started Reading the Student Job ::");
	}

	@Override
	public void afterRead(StudentResponseDto item) {
		log.info(":: Red the Student Job ::");
	}

	@Override
	public void onReadError(Exception ex) {
		log.info(":: Error Reading the Student Job ::" + ex.getMessage());
	}

}
