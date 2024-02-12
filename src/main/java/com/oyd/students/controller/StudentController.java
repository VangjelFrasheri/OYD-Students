package com.oyd.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyd.students.exception.ResourceNotFoundException;
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
		List<Student> students = studentRepo.findAll();
		return studentRepo.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getAllStudentById(@PathVariable Long id){
		Student student = studentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student not found with id "+ id));
		return student;
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		System.out.println(student.toString());
		return studentRepo.save(student);
	}
	
	@GetMapping("/student/{first}/{last}")
	public List<Student> getStudentByName(@PathVariable String first, @PathVariable String last) {
		return studentRepo.findByFirstNameAndLastName(first, last);
		
	}
	
	@PutMapping("/update/student/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student studentBody) {
		Student student = studentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student not found with id "+ id));
		
		student.setBelt(studentBody.getBelt());
		student.setEmail(studentBody.getEmail());
		student.setFirstName(studentBody.getFirstName());
		student.setLastName(studentBody.getLastName());
		student.setIsActive(studentBody.getIsActive());
		student.setPhone(studentBody.getPhone());
		
		return studentRepo.save(student);
	}
}
