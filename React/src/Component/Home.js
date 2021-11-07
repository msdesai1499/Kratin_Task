import React from "react";
import { Jumbotron, Button } from 'reactstrap';
import { useEffect } from "react";
function Home() {
	useEffect(() => {
		document.title = 'Home';
	}, [])

	return (
		<div>
			<Jumbotron className='text-center' style={{ backgroundColor: '#D3D3D3', padding: 20, borderRadius: 10 }}>
				<h1 >Old Age Helpers</h1>
				<p className="lead">This is a web based platform designed with intention to help Old age peoples.</p>
				<hr className="my-2" />
				<p>Currently this site is providing service like adding day-to-day task , providing banking service like withdrawal.</p>
				<p className="lead">
					<Button color="primary">Learn More</Button>
				</p>
			</Jumbotron>
		</div>
	);
}

export default Home;