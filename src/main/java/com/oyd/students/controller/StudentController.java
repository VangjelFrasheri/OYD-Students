package com.oyd.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyd.students.model.Student;
import com.oyd.students.repository.StudentRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/student/{first}/{last}")
	public List<Student> getStudentByName(@PathVariable String first, @PathVariable String last) {
		return studentRepo.findByFirstNameAndLastName(first, last);
		
	}
}
