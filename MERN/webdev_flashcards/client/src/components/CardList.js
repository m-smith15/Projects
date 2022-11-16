import React from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

const CardList = (props) => {

    const { removeFromDom } = props;
    const deleteCard= (cardId) => {
        axios.delete('http://localhost:8000/api/card/' + cardId)
            .then(res => {
                removeFromDom(cardId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div>
            {props.card.map((card, i) =>
                <p key={i}>
                    <Link to={"/card/" + card._id + "/edit"}>
                        {card.cardTitle} | {card._id}
                    </Link>
                    <br />{card.price}
                    <br />{card.description}
                    <br /><button onClick={(e) => { deleteCard(card._id) }}>
                        Delete
                    </button>
                </p>
            )}
        </div>
    )
}

export default CardList;