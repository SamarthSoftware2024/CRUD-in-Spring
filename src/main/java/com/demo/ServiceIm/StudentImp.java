package com.demo.ServiceIm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.Entity.Student;
import com.demo.Repo.StudentRepo;
import com.demo.Service.StudentService;

@Component
public class StudentImp implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	@Override
	public Student addStudent(Student student) {
		
		return studentRepo.save(student);
		
	}
	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}
	@Override
	public Optional<Student> findById(int id) {
		
		return studentRepo.findById(id);
	}
	@Override
	public String deleteById(int id) {
		studentRepo.deleteById(id);
		return "delete successful";
		
	}
	@Override
	public Student updateStudent(int id, Student student) {
		
		Student std = studentRepo.findById(id).get();
		std.setfName(student.getfName());
		std.setsName(student.getsName());
		
		return studentRepo.save(std);
	}
//	@Override
//	public Student findById2(int id) {
//		
//	 return studentRepo.findById(id).get();
//	}

}
