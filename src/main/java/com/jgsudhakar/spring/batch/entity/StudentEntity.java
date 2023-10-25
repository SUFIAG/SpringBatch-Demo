package com.jgsudhakar.spring.batch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.entity.StudentEntity
 * @Date : 05/10/2020
 */
@Entity(name = "SB_STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements Serializable {

	/**
	 * Default Serial Id
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //, generator = "STU_SEQ")
//	@SequenceGenerator(name = "STU_SEQ", sequenceName = "STU_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ROLL_NO")
	private String rollNo;
	
	@Column(name = "STANDARD")
	private String standard;
	
	
}
