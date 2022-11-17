import React, { useEffect, useState } from 'react';
import CardForm from '../components/CardForm';
import { useNavigate } from 'react-router-dom';


const Create = (props) => {
    const navigate = useNavigate();

    const navigateToHome = () => {
        navigate('/')
    }
    
    return(
    <div>
        <h2>Create a new flashcard!</h2>
        <br/>
        <CardForm />
        <hr/>
        <button onClick={navigateToHome}>
            Back to home
        </button>
    </div>
    )
}

export default Create;