import React, { useState, useEffect } from "react";
import Course from './Course'
import base_url from "../api/bootapi";
import axios from "axios";
import { toast } from "react-toastify";
const Allcourses = () => {

	useEffect(() => {
		document.title = 'View Tasks';
	}, []);

	//Function to call server
	const getAllCoursesFromServer = () => {
		axios.get(`${base_url}/courses`).then(
			(response) => {
				//For Success
				console.log(response)
				console.log(response.data)
				toast.success("Tasks has been loaded", {
					position: "bottom-center"
				});
				setCourses(response.data);
			},
			(error) => {
				//For Error
				console.log(error)
				toast.error("Something went wrong");
			}
		);
	};

	useEffect(() => {
		getAllCoursesFromServer();
	}, []);

	const [courses, setCourses] = useState([])

	const updateCourses = (id) => {
		setCourses(courses.filter((c) => c.id != id))
	}

	return (
		<div className='text-center='>

			<h1>All Tasks</h1>
			<p>List of Tasks</p>

			{
				courses.length > 0 ? courses.map((item) => <Course key={item.id} course={item} update={updateCourses} />) : "No Courses Found"
			}
		</div>
	)

}

export default Allcourses;
