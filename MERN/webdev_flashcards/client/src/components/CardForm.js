import React, { useState } from 'react';
import axios from 'axios';

export default () => {
    const [cardTitle, setCardTitle] = useState("");
    const [cardDescription, setDescription] = useState("");

    //prevent default to stop page from reloading
    //make post request to create api in 
    const formSubmitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/create/card', {
            cardTitle,
            cardDescription
        })
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }

    //need a form submission handler
    //also need onChange handlers for values in input fields - set__
    return (
        <div>
            <form onSubmit={formSubmitHandler}>
                <div>
                    <label>Title</label>
                    <input type="text" onChange={(e) => setCardTitle(e.target.value)} value={cardTitle} />
                </div>
                <div>
                    <label>Description</label>
                    <textarea onChange={(e) => setDescription(e.target.value)} value={cardDescription} />
                </div>
                <input type="submit" value="Add Card" />
            </form>
        </div>
    )
}