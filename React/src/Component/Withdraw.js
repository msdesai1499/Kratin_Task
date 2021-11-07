import React from "react";
import '../withdraw.css';
import { useHistory } from "react-router-dom";
import { toast } from "react-toastify";

const Withdraw = () => {
	const history = useHistory();
	return (
		<>
			<div className="container-fluid" id="loginid">
				<div className="row no-gutter">
					<div classNameName="col-md-6 d-none d-md-flex bg-image"></div>


					<div classNameName="col-md-6 bg-light">
						<div classNameName="login d-flex align-items-center py-5">
							<div className="container">
								<div className="row">
									<div className="col-lg-10 col-xl-7 mx-auto">
										<h3 className="display-4">Cash Withdraw</h3>
										<p className="mb-4" style={{ color: "white" }}>Our Employee will come at your location and deliver your Cash.</p>
										<form >
											<div className="form-group mb-3">
												<input type="text" required="" placeholder="Please enter Account Number" autofocus="" className="form-control rounded-pill 
												border-0 shadow-sm px-4"
												/>
											</div>
											<div className="form-group mb-3">
												<input id="inputPassword" type="password" placeholder="Please Enter Password" required="" className="form-control rounded-pill border-0 shadow-sm px-4 text-primary"
												/>
											</div>
											<div className="form-group mb-3">
												<input type="text" required="" type="text" placeholder="Please Emter Amount to be Withdrawn" autofocus="" className="form-control rounded-pill 
												border-0 shadow-sm px-4"
												/>
											</div>
											<div className="custom-control custom-checkbox mb-3">
												<input id="customCheck1" type="checkbox" checked className="custom-control-input" />
												<label for="customCheck1" className="custom-control-label">Remember password</label>
											</div>
											<div className="form-group mb-3">
												<input type="submit" className="btn btn-primary btn-block  mb-2 rounded-pill shadow-sm" value="Withdraw"
													onClick={() => {
														toast.success("Our Employee will come at your location and deliver your Cash.", {
															position: "bottom-center"
														});
														history.push('/view-banks');
													}}
												/>
											</div>


										</form>
									</div>
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>

		</>
	)

}

export default Withdraw;