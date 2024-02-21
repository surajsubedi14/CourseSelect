import {useState ,React} from 'react'
import './login.css'
import axios from 'axios';
import Home from './home';
import { useNavigate  } from 'react-router-dom';

export default function Login  ()  {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loginError, setLoginError] = useState('');
    const navigate = useNavigate(); 


    async function llogin() {
        console.warn(email, password);
    
        try {
          let result = await axios.post(
            'http://localhost:8081/check',
            {
              email: email,
              password: password,
            },
            {
              headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
              },
            }
          );

          
    
          
    
          if (result.data !== 0) {
            // Redirect to Home component
            
              console.log('The value return is', result.data);
            // history.push("/home");
            localStorage.setItem('login',"true"); 
            localStorage.setItem('student_id',result.data);
            navigate("/home");

            // Adjust the path to match your route
        
          } else {
            // Set login error
            // console.log('wrong');
            alert(`Incorrect email or password`)
            setLoginError('Incorrect email or password');

          }
        } catch (error) {
          console.error('Error making the request:', error);
          // Handle error
          setLoginError('An error occurred during login');
        }
      }
      const handleSubmit = (e) => {
        e.preventDefault();
        llogin();
      };

      
  return (
    <div className='mp'>
    <div className="auth-form-container">
        <h2>Login</h2>
        <form className="login-form" onSubmit={handleSubmit}>
            <label htmlFor="Email">Email </label>
            <input value={email} onChange={(e) => setEmail(e.target.value)} type="Email" placeholder="Email" id="Email" name="Email" />
            <label htmlFor="password">Password </label>
            <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
            <button  type="submit">Log In</button>
        </form>
        {/* <button className="link-btn">Don't have an account? Register here.</button> */}
    </div>
</div>
  )
}
