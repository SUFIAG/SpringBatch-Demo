package com.jgsudhakar.spring.batch.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.dto.StudentRequestDto
 * @Date : 05/10/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String rollNo;
	
	private String standard;

}
