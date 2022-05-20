package com.prasad.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prasad.sms.entity.Student;
import com.prasad.sms.repository.StudentRepository;
import com.prasad.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
		
	}


	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.getById(id);
	}

}
