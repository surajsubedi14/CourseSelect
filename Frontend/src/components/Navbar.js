import {useState ,React} from 'react'
import Login from './login'
import {Link} from 'react-router-dom'

const Navbar = () => {
  const [isLoginVisible, setLoginVisible] = useState(true);

  const handleLoginClick = () => {
    setLoginVisible(!isLoginVisible);
  };
  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">Academic Portal</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    {/* <button className='btn btn-outline-light'onClick={handleLoginClick}>Login</button> */}
   
  </div>
</nav>

  {isLoginVisible && <Login />}
    </div>
  )
}

export default Navbar