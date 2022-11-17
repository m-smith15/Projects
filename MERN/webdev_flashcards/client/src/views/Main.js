import React, { useEffect, useState } from 'react';
import CardList from '../components/CardList';
import CardForm from '../components/CardForm';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


const Main = (props) => {
    const [card, setCard] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8000/api/card')
            .then(res => {
                setCard(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = cardId => {
        setCard(card.filter(card => card._id !== cardId));
    }

    const navigateToCreate = () => {
        navigate('/create')
    }

    return (
        <div>
            <h1>WebDev Flashcards</h1>
            <p>Welcome to webdev flashcards! <br />
                The purpose of this app is to help aspiring webdevs practice and study up on concepts within the industry</p>
            <div>See one that needs to be added?</div>
            <button onClick={navigateToCreate}>
                Create a new flashcard!</button>
            <hr />
            {loaded && <CardList card={card} removeFromDom={removeFromDom} />}
        </div>
    )
}

export default Main;