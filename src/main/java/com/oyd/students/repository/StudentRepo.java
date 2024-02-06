package com.oyd.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyd.students.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

	List<Student> findAll();

	
}
