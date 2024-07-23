package com.demo.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.CustomException.StudentNotFoundException;
import com.demo.Entity.Student;
import com.demo.Repo.StudentRepo;
import com.demo.Service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class MyConroller {

	@Autowired
	StudentService studentService;

	@PostMapping("addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("findAllStudent")
	public List<Student> findAllStudent(){
		return studentService.findAll();
	}

//	@PostMapping("findStudentById/{id}")
//	public Optional<Student> findStudentById(@PathVariable int id) {
//		return studentService.findById(id);
//	}
//	


	@PostMapping("findStudentById/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentService.findById(id).orElseThrow(()-> new StudentNotFoundException("Id is not found in DB"));
	}
	

	@DeleteMapping("deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable int id) {
		studentService.deleteById(id);
		return "delete successful";
	}
	
	@PutMapping("updateStudentById/{id}")
	public Student updateStudentById(@PathVariable int id ,@RequestBody Student student) {
		
		return studentService.updateStudent(id, student);
	}
	
	
}
