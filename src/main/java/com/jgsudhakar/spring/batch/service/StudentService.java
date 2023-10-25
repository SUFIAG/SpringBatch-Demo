package com.jgsudhakar.spring.batch.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jgsudhakar.spring.batch.dto.StudentRequestDto;
import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.service.StudentService
 * @Date : 05/10/2020
 */
public interface StudentService {
	
	public List<StudentResponseDto> fetchStuList();
	
	public void save(StudentRequestDto dto);
	
	public List<StudentResponseDto> retrieveStudents(Pageable pageable);
	
}
