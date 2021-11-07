import React from "react";
import { ListGroup, ListGroupItem } from 'reactstrap';
import { Link } from "react-router-dom";

const Menu = () => {

	return (
		<ListGroup style={{ opacity: 0.9 }}>
			<Link className='list-group-item list-group-item-action' tag='a' to='/' action>Home</Link>
			<Link className='list-group-item list-group-item-action' tag='a' to='/add-course' action>Add Task</Link>
			<Link className='list-group-item list-group-item-action' tag='a' to='/view-courses' action>View Tasks</Link>
			<Link className='list-group-item list-group-item-action' tag='a' to='/add-bank' action>Add Bank</Link>
			<Link className='list-group-item list-group-item-action' tag='a' to='/view-banks' action>View Banks</Link>
			<Link className='list-group-item list-group-item-action' tag='a' to='/about' action>About Me</Link>


		</ListGroup>
	)

}

export default Menu;