import React, { useState } from "react";
import { Fragment } from "react/cjs/react.production.min";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import { useEffect } from "react";
import base_url from "../api/bootapi";
import axios from "axios";
import { toast } from "react-toastify";
const AddCourse = () => {
	useEffect(() => {
		document.title = 'Add Courses';
	}, []);

	const [course, setCourse] = useState({});

	//Form Handler Function
	const handleForm = (e) => {

		console.log(course);
		postDatatoServer(course);

		e.preventDefault();
	};

	//Creating Function to put data on server

	const postDatatoServer = (data) => {
		axios.post(`${base_url}/courses`, data).then(
			(response) => {
				console.log(response);
				toast.success("Course added successfully");
				console.log("success");
			}, (error) => {
				console.log(error);
				toast.error("Something went wrong");
				console.log("error");
			}
		)
	}

	return (
		<Fragment>

			<h1 className="text-center my-3">Fill Task Details</h1>
			<Form onSubmit={handleForm}>
				<FormGroup style={{ marginTop: 15 }}>
					<label for="userId" >Task Priority</label>
					<Input
						type="text"
						placeholder="Enter Name"
						name="userId"
						id="userId"
						onChange={(e) => {
							setCourse({ ...course, id: e.target.value });
						}}
					/>
				</FormGroup>
				<FormGroup style={{ marginTop: 15 }} >
					<label for="title" >Task Title</label>
					<Input
						type="text"
						placeholder="Enter Title"
						name="title"
						id="title"
						onChange={(e) => {
							setCourse({ ...course, title: e.target.value });
						}}
					/>
				</FormGroup>
				<FormGroup style={{ marginTop: 15 }} >
					<label for="description" >Task Description</label>
					<Input
						type="textarea"
						placeholder="Enter description"
						name="description"
						id="description"
						onChange={(e) => {
							setCourse({ ...course, description: e.target.value });
						}}
						style={{ height: 100 }}
					/>
				</FormGroup>

				<Container style={{ marginTop: 15 }} className="text-center">
					<Button type="submit" color="success">Add task</Button>
					<Button type="reset" style={{ marginLeft: 10 }} color="secondary">Clear</Button>
				</Container>
			</Form>
		</Fragment>
	);
}

export default AddCourse;