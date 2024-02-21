import { useState } from "react";
import './display.css'
import axios from "axios";
import { useNavigate  } from 'react-router-dom';

function Display(props) 
{
    
    const [checkstate, Setcheckstate]=useState(Array(100).fill(false));
    const [number, Setnumber]=useState(0);
    const [subm, setSub] =useState(0);
    const navigate = useNavigate(); 
   
    //console.log("hey",localStorage.getItem('student_id'))

    if(props.course==null)
    {
        return;
    }
    let cour=props.course;
    //console.log(cour);
    if(props.preq==null)
    {
        return;
    }
    let pre=props.preq;
    //console.log(pre[1]);


    
    let courMap=new Array(cour.length);
    cour.map((title ,index)=>(
        courMap[index]=title.courseID
     ))

    let check=checkstate;

    const handleChange=(event)=>
    {
        if(checkstate[event.target.value]===false)
        {
            Setnumber(number+1)
            check[event.target.value]=!check[event.target.value];
        }
        else
        {
            Setnumber(number-1)
            check[event.target.value]=!check[event.target.value];
        }
       
       Setcheckstate(check)
    }
    const courses = { 
        studentId : 0,
        id : []
        // id1: 0,
        // id2: 0,
        // id3: 0,
        // id4: 0,
        // id5: 0,
        // id6: 0,
      };
    
    const  handleSubmit=(e)=>
    {
        let ans =false;
        if(number<4)
        {
            e.preventDefault();
            alert(`Select atleast four courses`)

        }
        else
        {
            for(var i=0; i< pre.length;i++)
            {
                if(checkstate[courMap.indexOf(pre[i].courseID.courseID)] && checkstate[courMap.indexOf(pre[i].preq.courseID)]===false)
                {
                    ans = true;
                }
            }
            if(ans)
            {
                alert(`All Prerequisites not fulfilled for all course`)
                e.preventDefault();
            }
            else
            {
                let output=[];
                for( i=0; i< cour.length;i++)
                {
                    output.push(checkstate[i]===true);
                    // if(checkstate[i]===true)
                    // {
                        //output.push(cour[i].courseID);
                        //console.log(cour[i]);
                        //output.push(cour[i].courseID);
                        //courses[i]=cour[i].courseID;
                        // if(cour[i].courseID === 1) {
                        //     courses.id1 = 1;
                        // }
                        // if(cour[i].courseID === 2) {
                        //     courses.id2 = 1;
                        // }
                        // if(cour[i].courseID === 3) {
                        //     courses.id3 = 1;
                        // }
                        // if(cour[i].courseID === 4) {
                        //     courses.id4 = 1;
                        // }
                        // if(cour[i].courseID === 5) {
                        //     courses.id5 = 1;
                        // }
                        // if(cour[i].courseID === 6) {
                        //     courses.id6 = 1;
                        // }
                    //}
                } 
                courses.id = output;
                courses.studentId = localStorage.getItem('student_id');
                //const dataObject = {};
                //console.log(courses);

                //output.forEach((item) => {
                //dataObject[JSON.stringify(item)] = ''; // You can set a default value or leave it empty
                //    });
                //console.log("The value  of subbmitted1",dataObject);
                //for (const key in dataObject) {
                //    if (dataObject.hasOwnProperty(key)) {
                        //console.log(`Value of ${key}: ${dataObject[key]}`);
                //    }
                //}

                // fetch(`http://localhost:8081/Courses/postt`, {
                //     method: 'POST' ,
                //     mode: 'cors',
                //     body:{
                //         id1: 0,
                //         id2: 0,
                //         id3: 0,
                //         id4: 0,
                //         id5: 0,
                //         id6: 0,
                //       }
                // })
                e.preventDefault();
                 setSub(1);
                const response =  axios.post('http://localhost:8081/Courses/postt', courses);
                
            }
        }

    }

    const handleLogout = () => {
        // Clear user-related data or perform other cleanup
        localStorage.removeItem("student_id");
        localStorage.setItem('login','false'); 
    
        // Redirect to the login page
        navigate("/login");
      };
if(subm===0)
{
  return (
    <div>
    <form onSubmit={handleSubmit}  className="form-table">
     <table className="table">
        <thead>
            <th scope="col"></th>
            <th scope="col">COURSES:</th>
            <th scope="col">FACULTY:</th>
            <th scope="col">COURSECODE:</th>
            <th scope="col">CREDITS</th>
            <th scope="col">TERM:</th>
            <th scope="col" >YEAR:</th>
            <th scope="col">CAPACITY:</th>
            <th scope="col">PREREQUISITE:</th>
        </thead>
       {/* title: Represents the current element of the array (in this case, a course object).
            index: Represents the index of the current element in the array. */
        }
        {cour.map((title, index)=>(    
            
            <tbody  className="td" key={index}>
                
                <td><input type="checkbox" value={index}  checked={checkstate[index]} disabled={number>=6 && !checkstate[index]} onChange= {handleChange}/></td>
                    <td style={{ color: 'blue' }} > {title.name} </td>
                    <td> {title.faculty} </td>
                    <td>{title.courseCode} </td>
                    <td> {title.credit} </td>
                    <td>{title.term} </td>
                    <td> {title.year} </td>
                    <td> {title.capacity} </td>
                    <td >
                        {pre.map(({id,courseID,preq})=>(
                          <PreReq title={title.courseID} cou={courseID.courseID} preq={preq.name}/>
                        ))}
                    </td>
                    
                </tbody>
        ))}
     </table>
    <span>
        <h1 style={{ color: 'blue' }} >{number}/6</h1>
        <input
  type="submit"
  value="Submit"
  style={{
    backgroundColor: 'green',    // Change the background color
    color: 'white',              // Change the text color
    padding: '10px 20px',        // Add padding
    borderRadius: '5px',         // Add rounded corners
    border: 'none',              // Remove border
    cursor: 'pointer',           // Add a pointer cursor on hover
  }}
/>

    </span>
   
    </form>
    
    </div>
  )
}
else
{
    
    return (
        <div>
      
         
    <h4 className="submitted-message">Your choices have been submitted</h4>
    <br></br><br></br>
 
    <button type="button" class="btn btn-danger" onClick={handleLogout}>Logout</button>
    
    </div>
    


   
   
    )
    
}

}

function PreReq(props)
{
    if(props.title === props.cou)
    {
       return <span style={{ color: 'red' }}>  * {props.preq}</span>
    }
}

export default  Display;