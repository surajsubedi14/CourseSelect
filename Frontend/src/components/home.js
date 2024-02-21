import React, { useEffect } from "react";
import { useState} from "react";

import './home.css'

import Initstate from "./datafetch";
import { useNavigate } from "react-router-dom";
// import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
// import ".../node_modules/bootstrap/dist/css/bootstrap.min.css"


function Home() {

  const navigate=useNavigate();

  useEffect(()=>{
    if(localStorage.getItem('login')!="true")
    {
      return navigate("/login");
    }
  })
  
  const[page, setpage]=useState(0);

  return (
    <div className="container">
      <div className="py-4">
      <h2> Select your stream:</h2>
      {/* <button onClick={() => setpage(1)}  disabled = {page} className="btn btn-outline-dark">CSE</button>  */}
      {/* <button onClick={() => setpage(1)}  disabled = {page}>CSE</button> */}
      {/* <button onClick={() => setpage(1)}  disabled = {page} type="button" class="btn btn-primary">CSE</button> */}
      {/* <button onClick={() => setpage(1)}  disabled = {page} type="button" class="btn btn-primary">ECE</button> */}
      {/* <button onClick={() => setpage(2)} disabled = {page}>ECE</button> */}

      <button onClick={() => setpage(1)} disabled={page} type="button" className="btn btn-primary" style={{ marginRight: '10px' }}>
      CSE
      </button>

      <button  onClick={() => setpage(2)}  disabled={page} type="button" className="btn btn-primary" style={{ marginLeft: '10px' }}
> ECE
</button>
      </div>
      <div>
        <PageSet value={page}/>
      </div>
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
export default Home;
