package com.prasad.sms.service;

import java.util.List;

import com.prasad.sms.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	void deleteStudent(Long id);
	Student getStudent(Long id);
	

}
