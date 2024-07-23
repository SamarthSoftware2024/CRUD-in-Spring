package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.Entity.Student;

@Service
public interface StudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> findAll();
	
	public Optional<Student> findById(int id);
	
//	public Student findById2(int id);
	
	public String deleteById(int id);
	
	public Student updateStudent(int id,Student student);

}
