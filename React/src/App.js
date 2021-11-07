
import './App.css';
import { ToastContainer, toast } from 'react-toastify';
import Header from './Component/Header'
import { Button, Container, Row, Col } from 'reactstrap';
import Home from './Component/Home';
import Course from './Component/Course';
import Allcourses from './Component/Allcourses';
import AddCourse from './Component/AddCourse';
import Menu from './Component/Menu';
import About from './Component/About';
// import { CorsRequest } from 'cors';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import AddBank from './Component/AddBank';
import Allbanks from './Component/Allbanks';
import Withdraw from './Component/Withdraw';
function App() {

  const btnHandle = () => {
    toast.success('Hello Welcome', {
      position: 'top-center'
    })
  }
  return (
    <div id="apppage">
      <Router>
        <ToastContainer />
        <Container>
          <Header></Header>
          <Row>
            <Col md={4}>
              <Menu />
            </Col>
            <Col md={8}>
              <Route path='/' component={Home} exact />
              <Route path='/add-course' component={AddCourse} exact />
              <Route path='/view-courses' component={Allcourses} exact />
              <Route path='/add-bank' component={AddBank} exact />
              <Route path='/view-banks' component={Allbanks} exact />
              <Route path='/about' component={About} exact />
              <Route path='/withdraw' component={Withdraw} exact />

            </Col>
          </Row>
        </Container>
      </Router>
    </div>
  );
}

export default App;
