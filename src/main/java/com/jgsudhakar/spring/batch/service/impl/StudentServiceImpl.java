package com.jgsudhakar.spring.batch.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgsudhakar.spring.batch.dto.StudentRequestDto;
import com.jgsudhakar.spring.batch.dto.StudentResponseDto;
import com.jgsudhakar.spring.batch.entity.StudentEntity;
import com.jgsudhakar.spring.batch.repo.StudentRepository;
import com.jgsudhakar.spring.batch.service.StudentService;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.service.impl.StudentServiceImpl
 * @Date : 05/10/2020
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentResponseDto> fetchStuList() {
		return Optional.ofNullable(studentRepository.findAll()).orElse(Collections.emptyList()).stream()
				.map(student -> new StudentResponseDto(student.getId(), student.getName(), student.getRollNo(),
						student.getStandard()))
				.collect(Collectors.toList());
	}

	@Override
	public void save(StudentRequestDto dto) {
		StudentEntity entity = new StudentEntity();
		entity.setName(dto.getName());
		entity.setRollNo(dto.getRollNo());
		entity.setStandard(dto.getStandard());
		studentRepository.save(entity);
	}

	@Override
	public List<StudentResponseDto> retrieveStudents(Pageable pageable) {
		return Optional.ofNullable(studentRepository.findAll(pageable)).get().getContent().stream()
				.map(student -> new StudentResponseDto(student.getId(), student.getName(), student.getRollNo(),
						student.getStandard()))
				.collect(Collectors.toList());
	}
}
