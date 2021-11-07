package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	
}
