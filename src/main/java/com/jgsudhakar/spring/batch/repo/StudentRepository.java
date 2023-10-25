package com.jgsudhakar.spring.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.spring.batch.entity.StudentEntity;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.repo.StudentRepository
 * @Date : 05/10/2020
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
