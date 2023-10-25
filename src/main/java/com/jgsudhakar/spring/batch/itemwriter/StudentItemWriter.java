/**
 * 
 */
package com.jgsudhakar.spring.batch.itemwriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.jgsudhakar.spring.batch.dto.StudentRequestDto;
import com.jgsudhakar.spring.batch.dto.StudentResponseDto;
import com.jgsudhakar.spring.batch.service.StudentService;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File   : com.jgsudhakar.spring.batch.itemwriter.StudentItemWriter.java
 * @Date   : 2021-10-05
 */
@Log4j2
@Component
public class StudentItemWriter implements ItemWriter<StudentResponseDto>{

	private StudentService studentService;
	
	
	public StudentItemWriter(StudentService studentService) {
		this.studentService = studentService;
	}
	

	@Override
	public void write(List<? extends StudentResponseDto> items) throws Exception {
		log.info(":: Student Item Writer ::");
		for (StudentResponseDto studentResponseDto : items) {
			System.out.println(":: Writing the data of Student :: "+ studentResponseDto.toString());
			StudentRequestDto dto = new StudentRequestDto();
			dto.setName(studentResponseDto.getName());
			dto.setRollNo(studentResponseDto.getRollNo());
			dto.setStandard(studentResponseDto.getStandard());
			studentService.save(dto);
		}
	}

}
