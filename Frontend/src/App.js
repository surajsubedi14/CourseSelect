import React from "react";
import { useState} from "react";
import Initstate from "./components/datafetch";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import { BrowserRouter, Routes,Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./components/home";
import Protected from "./components/Protected"
import Login from "./components/login"


function App() {
  
  const[page, setpage]=useState(0);

  return (
    <div className="App">
       {/* <Navbar/>   */}
    <BrowserRouter>
   {/* <Navbar/>  */}
   {/* <Route path='/' element={<Navbar/>}/> */}
   <Routes>
   <Route path='/' element={<Navbar/>}/>

    
     {/* <Route path='/home' element={<Home/>}/> */}
     <Route path='/home' element={<Protected Component={Home}/>}/>
     <Route path='/login' element={<Login />}/>
   </Routes>
   </BrowserRouter>
   
  </div>
  );
}

function PageSet(props)
{
  if(props.value === 0)
  {
     return ;
  }
  if(props.value === 1)
  {
     return <Initstate value="10"/>
  }
  if(props.value === 2)
  {
     return  <Initstate value="20"/>
  }
}
export default App;
