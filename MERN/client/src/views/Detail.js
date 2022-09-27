import React, { useEffect, useState } from 'react'
import { useParams } from "react-router-dom";
import axios from 'axios';

const Detail = (props) => {
    const [goal, setGoal] = useState({})
    const { id } = useParams();

    useEffect(() => {
        axios.get('http://localhost:8000/api/goal/'+id)
            .then(res => {
                setGoal(res.data)
                //console.log(res.data)
            })
            .catch(err => console.error(err));
    }, [id]);

    return (
        <div>
            <p>Type of goal: {goal.goalType}</p>
            <p>Goal: {goal.goal}</p>
            <p>Time to complete: {goal.timeToCompletion}</p>
            <p>Challenges: {goal.challenges}</p>
        </div>
    )
}
export default Detail;