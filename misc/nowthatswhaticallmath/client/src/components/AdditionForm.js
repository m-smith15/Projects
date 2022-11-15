import React, { useState } from 'react';
import axios from 'axios'


export default () => {
    let answer = 0;
    const [userAnswer, setUserAnswer] = useState(0);
    const [varA, setVarA] = useState(Math.ceil(Math.random() * 30));
    const [varB, setVarB] = useState(Math.ceil(Math.random() * 30));
    const [correct, setCorrect] = useState(false);
    const [incorrect, setIncorrect] = useState(false);


    const formSubmitHandler = async (e) => {
        e.preventDefault();

        //setting result notice to false after resubmission
        setCorrect(false)
        setIncorrect(false)
        //check submitted answer vs correct answer here, console logging early & often!!

        // console.log('http://api.mathjs.org/v4/?expr='+varA+'%2B'+varB)

        await axios.get('http://api.mathjs.org/v4/?expr='+varA+'%2B'+varB)
            .then(response => {
                // console.log(response)
                answer = response.data;
                console.log("Actual answer: " + answer);
                console.log("User answer: " + userAnswer);
            })
            .catch(err => console.error(err))

        // checking answer vs user's answer here and proving messaging accordingly
        if(answer == userAnswer){
            console.log('correct!')
            setCorrect(true);
        } else {
            console.log('incorrect!')
            setIncorrect(true);
        }
    }
    
    //can simply re-set state of the values to generate a new problem!
    const newProblem = () =>{
        setVarA(Math.ceil(Math.random() * 30));
        setVarB(Math.ceil(Math.random() * 30));
        setUserAnswer(0);
        setCorrect(false)
        setIncorrect(false)
    }

    //adding in to display correct/incorrect messaging
    const Correct = () => <h2>Correct!!</h2>
    const Incorrect = () => <h2>Not quite, give it another go!</h2>

    return (
        <div>
        <form onSubmit={ formSubmitHandler }>
            <div>
                {varA} + {varB} =
            </div><br/>
            <input type="number" value={userAnswer} onChange={ (e) => setUserAnswer(e.target.value)} /> <br/><br/>
            <input type="submit" value="Submit" />
        </form>
        <br/>
        {correct ? <Correct /> : <h2/>}
        {incorrect ? <Incorrect /> : <h2/>}
        <button onClick={newProblem}>Get Another Problem!</button>
        </div>
    )
}


