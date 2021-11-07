import axios from 'axios';
import React from 'react';
import { toast } from 'react-toastify';
import {
	Card, CardImg, CardText, CardBody,
	CardTitle, CardSubtitle, Button, CardFooter, Container
} from 'reactstrap';
import base_url from '../api/bootapi';
import { useHistory } from 'react-router';

const Course = ({ course, update }) => {
	const history = useHistory();

	const deleteCourse = (id) => {
		axios.delete(`${base_url}/courses/${id}`).then(
			(response) => {
				console.log(response);
				toast.success("Task is deleted Successfully");
				update(id);
			},
			(error) => {
				console.log(error);
				toast.success("Something went wrong");
			}
		)
	}
	return (
		<div>
			<Card className="text-center">

				<CardBody>

					<CardTitle tag="h5">{course.title}</CardTitle>
					<CardSubtitle >{course.id}</CardSubtitle>
					<CardText>{course.description}</CardText>
					<Container >
						<Button color='danger' onClick={() => {
							deleteCourse(course.id);
						}} >Completed</Button>

					</Container>
				</CardBody>
			</Card>
		</div>
	);

}

export default Course;