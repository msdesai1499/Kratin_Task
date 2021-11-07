import React, { useState, useEffect } from "react";
import Bank from './Bank';
import base_url from "../api/bootapi";
import axios from "axios";
import { toast } from "react-toastify";
const Allbanks = () => {

	useEffect(() => {
		document.title = 'View Banks';
	}, []);

	//Function to call server
	const getAllBanksFromServer = () => {
		axios.get(`${base_url}/banks`).then(
			(response) => {
				//For Success
				console.log(response)
				console.log(response.data)

				setBanks(response.data);
			},
			(error) => {
				//For Error
				console.log(error)
				toast.error("Something went wrong");
			}
		);
	};

	useEffect(() => {
		getAllBanksFromServer();
	}, []);

	const [banks, setBanks] = useState([])

	const updateBanks = (bankId) => {
		setBanks(banks.filter((c) => c.bankId != bankId))
	}

	return (
		<div className='text-center='>

			<h1>List of Banks</h1>


			{
				banks.length > 0 ? banks.map((item) => <Bank key={item.bankId} bank={item} update={updateBanks} />) : "No Banks Found"
			}
		</div>
	)

}

export default Allbanks;
