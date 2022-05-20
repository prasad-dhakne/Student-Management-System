package com.prasad.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prasad.sms.entity.Student;
import com.prasad.sms.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentEmptyForm(Model model) {
		Student student1=new Student();
		model.addAttribute("student", student1);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/update/{id}")
	public String updateFormForStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable("id") Long id,
									@ModelAttribute("student") Student student) {
		Student existsStudent = studentService.getStudent(id);
		existsStudent.setId(id);
		existsStudent.setFirstName(student.getFirstName());
		existsStudent.setLastName(student.getLastName());
		existsStudent.setEmail(student.getEmail());
		studentService.saveStudent(existsStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
