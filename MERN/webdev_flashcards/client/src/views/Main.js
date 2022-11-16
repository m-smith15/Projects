import React, { useEffect, useState } from 'react';
import CardList from '../components/CardList';
import CardForm from '../components/CardForm';
import axios from 'axios';


const Main = (props) => {
    const [card, setCard] = useState([]);
    const [loaded, setLoaded] =useState(false);

    useEffect(()=> {
        axios.get('http://localhost:8000/api/card')
            .then(res=>{
                setCard(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = cardId => {
        setCard(card.filter(card => card._id !== cardId));
    }
    
    return(
    <div>
        <br/>
        <CardForm />
        <p>placeholder</p>
        <hr/>
        {loaded && <CardList card={card} removeFromDom={removeFromDom} />}
    </div>
    )
}

export default Main;