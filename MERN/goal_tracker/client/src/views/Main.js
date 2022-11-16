import React, { useEffect, useState } from 'react';
import GoalList from '../components/GoalList'
import axios from 'axios';

const Main = (props) => {
    const [goal, setGoal] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/goal')
            .then(res=>{
                setGoal(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err))
    }, []);

    const removeFromDom = goalId => {
        setGoal(goal.filter(goal => goal._id !== goalId));
    }

    return(
        <div>
            {loaded && <GoalList goal={goal} removeFromDom={removeFromDom} /> }
        </div>
    )
}

export default Main;