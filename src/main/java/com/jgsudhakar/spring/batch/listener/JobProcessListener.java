/**
 * 
 */
package com.jgsudhakar.spring.batch.listener;

import org.springframework.batch.core.ItemProcessListener;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.listener.JobProcessListener.java
 * @Date : 2021-10-06
 */
@Log4j2
public class JobProcessListener implements ItemProcessListener<StudentResponseDto, StudentResponseDto> {

	@Override
	public void beforeProcess(StudentResponseDto item) {
		log.info(":: Student Job Process Item received and gonna process ::");

	}

	@Override
	public void afterProcess(StudentResponseDto item, StudentResponseDto result) {
		log.info(":: Student Job Item processed Successfully ::");
	}

	@Override
	public void onProcessError(StudentResponseDto item, Exception e) {
		log.info(":: Student Job Process Error ::" + e.getMessage());
	}

}
