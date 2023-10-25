package com.jgsudhakar.spring.batch.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.dto.StudentResponseDto
 * @Date : 05/10/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String rollNo;
	
	private String standard;

}
