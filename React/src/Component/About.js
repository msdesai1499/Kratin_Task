import React from "react";
import '../OurTeam.css'
import mandar from '../images/Profile.jpeg'
const About = () => {
	return (
		<div className="ourteam" style={{ marginTop: "3%" }}>
			<section id="trainers" className="trainers">
				<div className="container" data-aos="fade-up">

					<div className="row" data-aos="zoom-in" data-aos-delay="100">
						<div className="d-flex align-items-stretch">
							<div className="member">
								<img src={mandar} style={{ width: 250, height: 250 }} className="img-fluid" alt="" />
								<div className="member-content">
									<h2>Mandar Desai</h2>
									<span>9146657495</span>
									<p>
										<h4>Willingness to adopt fresh ideas, embrace new technologies and responsibly explore opportunities to achieve sustainable project growth.</h4>

									</p>


								</div>
							</div>
						</div>



					</div>

				</div>
			</section>
		</div>
	)
}

export default About