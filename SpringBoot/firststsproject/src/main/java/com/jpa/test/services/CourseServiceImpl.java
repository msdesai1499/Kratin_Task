package com.jpa.test.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.CourseDao;
import com.jpa.test.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
//	List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(123,"Core Java","This Course has basics of java"));
//		list.add(new Course(125,"Advanced Java","This Course has Advance Study of java"));
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course c=null;
//		
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		
		return courseDao.getById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=courseDao.getById(parseLong);
		courseDao.delete(entity);
		
	}

}
