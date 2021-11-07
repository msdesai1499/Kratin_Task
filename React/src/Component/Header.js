import React from "react";
import { Card, CardBody } from "reactstrap";

function Header() {

	return (
		<div style={{ margin: 20, color: 'white', opacity: 0.8 }} className='text-center'>
			<Card className='bg-secondary'>
				<CardBody >
					<h1>Welcome to Elderly service site</h1>
				</CardBody>
			</Card>

		</div>

	);
}

export default Header;