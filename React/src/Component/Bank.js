import axios from 'axios';
import React from 'react';
import { toast } from 'react-toastify';
import {
	Card, CardImg, CardText, CardBody,
	CardTitle, CardSubtitle, Button, CardFooter, Container
} from 'reactstrap';
import bankimg from '../images/bank.jpg'
import base_url from '../api/bootapi';
import { useHistory } from "react-router-dom";


const Bank = ({ bank, update }) => {

	const history = useHistory();
	const deleteBank = (bankId) => {
		axios.delete(`${base_url}/banks/${bankId}`).then(
			(response) => {
				console.log(response);
				toast.success("Bank is deleted Successfully");
				update(bankId);
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
					<CardImg

						height="250px"
						src={bankimg}
						alt="GFG Logo" />
					<CardTitle tag="h5">{bank.bankName}</CardTitle>
					<CardSubtitle >{bank.bankAccNo}</CardSubtitle>
					<CardText>{bank.bankBranch}</CardText>

					<Container >
						<Button color='danger' onClick={() => {
							deleteBank(bank.bankId);
						}} >Remove Bank</Button>
						<Button style={{ margin: '10px' }} onClick={() => {
							history.push('/withdraw');
						}} color='warning'>WithDraw Cash</Button>
					</Container>
				</CardBody>
			</Card>
		</div>
	);

}

export default Bank;