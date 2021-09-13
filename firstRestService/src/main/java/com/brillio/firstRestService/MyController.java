package com.brillio.firstRestService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.firstRestService.entity.SDetails1DTO;
import com.brillio.firstRestService.entity.SDetailsDTO;
import com.brillio.firstRestService.service.SDetailsService;

@RestController
@Component
public class MyController {
	@Autowired
	StudentDAO studentDAO;

	@Autowired
	Student1DAO student1DAO;

	@Autowired
	MarksDAO marksDAO;
	
	@Autowired
	SDetailsService sdetailsService;

	@GetMapping("/")
	public String firstMethod() {
		return "welcome to spring boot";
	}

	@GetMapping("/students")
	public List<SDetailsDTO> getStudents() {
		return sdetailsService.findAll();
	}

	@GetMapping("/students/{id}")
	public Optional<SDetailsDTO> getAnyStudent(@PathVariable String id) {
		return studentDAO.findById(id);
	}

	@GetMapping("/students/fname/{fname}")
	public Optional<SDetailsDTO> getAnyStudentByFname(@PathVariable String fname) {
		return studentDAO.findByFname(fname);
	}

	@GetMapping("/students/name/{fname}+{lname}")
	public List<SDetailsDTO> getAnyStudentByName(@PathVariable String fname, @PathVariable String lname) {
		return studentDAO.findAllByFnameAndLname(fname, lname);
	}

	@GetMapping("/students/marks")
	public List<SDetails1DTO> getAllStudentsMarks() {
		return student1DAO.findAll();
	}

	@GetMapping("/students/city")
	public List<List<String>> getNameAndCity() {
		return studentDAO.getNameAndCity();
	}

	@GetMapping("/students/avgmarks")
	public List<List<String>> getAvgMarks() {
		return marksDAO.getAvgMarks();
	}

}
