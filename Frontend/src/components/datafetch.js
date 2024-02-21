
import { useState, useEffect } from "react";
import Display from "./display";


export default function Initstate(props)
{
    const[course, setcourse]=useState(null);
    const[preq, setpreq]=useState(null);
    const[error , setError]= useState(null);


useEffect(()=>{
fetch(`http://localhost:8081/cdomain/get_by_domain/${props.value}`)
.then((response)=>{
        if(!response.ok)
            {
                throw new Error(`This is an HTTP error: the status is ${response.status}`);
            }
          return response.json() ;
        })
        .then((actualData)=>{setcourse(actualData);setError(null)})
        .catch((err)=>{console.log(err.message);});
fetch(`http://localhost:8081/Pre/get`)
.then((response)=>{
        if(!response.ok)
            {
                throw new Error(`This is an HTTP error: the status is ${response.status}`);
            }
        return response.json() ;
        })
        .then((actualData)=>{setpreq(actualData);setError(null)})
        .catch((err)=>{console.log(err.message);});
},[])
return (
    <div>
        <Display course={course} preq={preq}/>
    </div>

)

}
