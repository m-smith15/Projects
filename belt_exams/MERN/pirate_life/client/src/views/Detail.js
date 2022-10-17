import React, { useEffect, useState } from 'react'
import { useParams } from "react-router-dom";
import axios from 'axios';

const Detail = (props) => {
    const [pirate, setPirate] = useState({})
    const { id } = useParams();

    useEffect(() => {
        axios.get('http://localhost:8000/api/pirate/' + id)
            .then(res => {
                setPirate(res.data)
                //console.log(res.data)
            })
            .catch(err => console.error(err));
    }, [id]);

    return (
        <div>
            <p>name: {pirate.pirateName}</p>
            <p>image: {pirate.image}</p>
            <p>treausre: {pirate.treausre}</p>
            <p>catchPhrase: {pirate.catchPhrase}</p>
            <p>position: {pirate.position}</p>
            <p>peg_leg: {pirate.peg_leg}</p>
            <p>eye_patch: {pirate.eye_patch}</p>
            <p>hook_hand: {pirate.hook_hand}</p>

        </div>
    )
}

export default Detail;