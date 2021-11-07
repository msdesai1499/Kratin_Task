package com.jpa.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entity.Bank;
import com.jpa.test.entity.Course;
import com.jpa.test.services.BankService;
import com.jpa.test.services.CourseService;



@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private BankService bankService;
	
	
	
	//Get The Courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		
		
		return this.courseService.getCourses();
	}
	
	//Get Single Course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//Add new Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	//Update Course using PUT Request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	//Delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
		this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/banks")
	public List<Bank> getBanks() {
		
		
		return this.bankService.getBanks();
	}
	
	@PostMapping("/banks")
	public Bank addBank(@RequestBody Bank bank) {

		return this.bankService.addBank(bank);
	}
	
	//Delete the course
		@DeleteMapping("/banks/{bankId}")
		public ResponseEntity<HttpStatus> deleteBank(@PathVariable String bankId){
			try {
			this.bankService.deleteBank(Long.parseLong(bankId));
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	

}
