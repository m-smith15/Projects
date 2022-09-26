import React from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

const GoalList = (props) => {

    const { removeFromDom } = props;
    const deleteGoal= (goalId) => {
        axios.delete('http://localhost:8000/api/goal/' + goalId)
            .then(res => {
                removeFromDom(goalId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div>
            {props.goal.map((goal, i) =>
                <p key={i}>
                    <Link to={"/goal/" + goal._id + "/edit"}>
                        {goal.goalType} | {goal._id}
                    </Link>
                    <br />{goal.goal}
                    <br />{goal.timeToCompletion}
                    <br />{goal.challenges}
                    <br /><button onClick={(e) => { deleteGoal(goal._id) }}>
                        Delete
                    </button>
                </p>
            )}
        </div>
    )
}

export default GoalList;