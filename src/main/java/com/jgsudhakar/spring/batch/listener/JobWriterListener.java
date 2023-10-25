/**
 * 
 */
package com.jgsudhakar.spring.batch.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.listener.JobWriterListener.java
 * @Date : 2021-10-06
 */
@Log4j2
public class JobWriterListener implements ItemWriteListener<StudentResponseDto> {
	
	@Override
	public void beforeWrite(List<? extends StudentResponseDto> items) {
		log.info(":: Student Job writing before started ::");
	}

	@Override
	public void afterWrite(List<? extends StudentResponseDto> items) {
		log.info(":: Student Job writing Successfully completed ::");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends StudentResponseDto> items) {
		log.info(":: Student Job writing Error ::" + exception.getMessage());
	}

}
