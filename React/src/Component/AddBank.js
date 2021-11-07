import React, { useState } from "react";
import { Fragment } from "react/cjs/react.production.min";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import { useEffect } from "react";
import base_url from "../api/bootapi";
import axios from "axios";
import { toast } from "react-toastify";
const AddBank = () => {
	useEffect(() => {
		document.title = 'Add Banks';
	}, []);

	const [bank, setBank] = useState({});

	//Form Handler Function
	const handleForm = (e) => {

		console.log(bank);
		postDatatoServer(bank);

		e.preventDefault();
	};

	//Creating Function to put data on server

	const postDatatoServer = (data) => {
		axios.post(`${base_url}/banks`, data).then(
			(response) => {
				console.log(response);
				toast.success("Bank added successfully");
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

			<h1 className="text-center my-3">Fill Bank Details</h1>
			<Form onSubmit={handleForm}>
				<FormGroup style={{ marginTop: 15 }}>
					<label for="bankId" >Bank Id</label>
					<Input
						type="text"
						placeholder="Enter Bank ID"
						name="bankId"
						id="bankId"
						onChange={(e) => {
							setBank({ ...bank, bankId: e.target.value });
						}}
					/>
				</FormGroup>
				<FormGroup style={{ marginTop: 15 }} >
					<label for="bankName" >Bank  Name</label>
					<Input
						type="text"
						placeholder="Enter bank Name"
						name="bankName"
						id="bankName"
						onChange={(e) => {
							setBank({ ...bank, bankName: e.target.value });
						}}
					/>
				</FormGroup>
				<FormGroup style={{ marginTop: 15 }} >
					<label for="bankAccNo" >Account Number</label>
					<Input
						type="text"
						placeholder="Enter Account Number"
						name="bankAccNo"
						id="bankAccNo"
						onChange={(e) => {
							setBank({ ...bank, bankAccNo: e.target.value });
						}}

					/>
				</FormGroup>
				<FormGroup style={{ marginTop: 15 }} >
					<label for="bankBranch" >Bank Branch</label>
					<Input
						type="text"
						placeholder="Enter Branch"
						name="bankBranch"
						id="bankBranch"
						onChange={(e) => {
							setBank({ ...bank, bankBranch: e.target.value });
						}}

					/>
				</FormGroup>

				<Container style={{ marginTop: 15 }} className="text-center">
					<Button type="submit" color="success">Add Bank</Button>
					<Button type="reset" style={{ marginLeft: 10 }} color="secondary">Clear</Button>
				</Container>
			</Form>
		</Fragment>

	)
}

export default AddBank;