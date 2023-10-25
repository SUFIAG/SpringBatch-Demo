/**
 * 
 */
package com.jgsudhakar.spring.batch.itemprocessor;

import org.springframework.batch.item.ItemProcessor;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File   : com.jgsudhakar.spring.batch.itemprocessor.StudentItemProcessor.java
 * @Date   : 2021-10-05
 */
@Log4j2
public class StudentItemProcessor implements ItemProcessor<StudentResponseDto, StudentResponseDto>{

	@Override
	public StudentResponseDto process(StudentResponseDto item) throws Exception {
		log.info(":: Processing the Student Record ::"+item.toString());
		return item;
	}

}
