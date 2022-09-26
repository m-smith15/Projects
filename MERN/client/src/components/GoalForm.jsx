import React, { useState } from 'react';
import axios from 'axios';

export default () => {
    const [goalType, setGoalType] = useState("");
    const [goal, setGoal] = useState("");
    const [timeToCompletion, setTimeToCompletion] = useState("");
    const [challenges, setChallenges] = useState("");


    //prevent default to stop page from reloading
    //make post request to create api in 
    const formSubmitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/goal', {
            goalType,
            goal,
            timeToCompletion,
            challenges
        })
            .then(res=>console.log(res))
            .catch(err=>console.log(err))
    }

    //need a form submission handler
    //also need onChange handlers for values in input fields - set__
    return (
        <form onSubmit={ formSubmitHandler }>  
            <div>
                <label>Type of Goal</label>
                <input type="text" onChange={(e)=>setGoalType(e.target.value)} value={goalType} />
            </div>
            <div>
                <label>Goal</label>
                <input type="text" onChange={(e)=>setGoal(e.target.value)} value={goal} />
            </div>
            <div>
                <label>How long will this take to accomplish?</label>
                <input type="text" onChange={(e)=>setTimeToCompletion(e.target.value)} value={timeToCompletion} />
            </div>
            <div>
                <label>What are some of the initial challenges you forsee?</label>
                <input type="text" onChange={(e)=>setChallenges(e.target.value)} value={challenges} />
            </div>
            <input type="submit" />
        </form>
    )
}