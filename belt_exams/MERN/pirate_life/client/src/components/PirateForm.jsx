import React, { useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

export default () => {
    const [pirateName, setPirateName] = useState("");
    const [image, setImage] = useState("");
    const [treasure, setTreasure] = useState(0);
    const [catchPhrase, setCatchPhrase] = useState("");
    const [position, setPosition] = useState("");
    const [peg_leg, setPeg_leg] = useState(true);
    const [eye_patch, setEye_patch] = useState(true);
    const [hook_hand, setHook_hand] = useState(true);
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();

    //prevent default to stop page from reloading
    //make post request to create api in 
    const formSubmitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/pirate', {
            pirateName,
            image,
            treasure,
            catchPhrase,
            position,
            peg_leg,
            eye_patch,
            hook_hand
        })
            .then(res => { console.log(res)
            navigate('/')
        })
            .catch(err => {
                const errorResponse = err.response.data.errors;
                const errorArr = [];
                for (const key of Object.keys(errorResponse)) {
                    errorArr.push(errorResponse[key].message)
                }
                setErrors(errorArr);
            })
            
    }

    //need a form submission handler
    //also need onChange handlers for values in input fields - set__
    return (
        <form onSubmit={formSubmitHandler}>
            {errors.map((err, index) => <p key={index}>{err}</p>)}
            <p>
                <label>pirateName</label><br />
                <input type="text"
                    name="pirateName"
                    value={pirateName}
                    onChange={(e) => { setPirateName(e.target.value) }} />
            </p>
            <p>
                <label>image</label><br />
                <input type="text"
                    name="image"
                    value={image}
                    onChange={(e) => { setImage(e.target.value) }} />
            </p>
            <p>
                <label>treasure</label><br />
                <input type="number"
                    name="treasure"
                    value={treasure}
                    onChange={(e) => { setTreasure(e.target.value) }} />
            </p>
            <p>
                <label>catchPhrase</label><br />
                <input type="text"
                    name="catchPhrase"
                    value={catchPhrase}
                    onChange={(e) => { setCatchPhrase(e.target.value) }} />
            </p>
            <p>
                <label>position</label><br />
                <select type="text"
                    onChange={(e) => { setPosition(e.target.value) }} >
                    <option value=""> -- Please Select a Value -- </option>
                    <option value="Captain"> Captain </option>
                    <option value="First mate"> First mate </option>
                    <option value="Quarter Master"> Quarter Master </option>
                    <option value="Boatswain"> Boatswain </option>
                    <option value="Powder Monkey"> Powder Monkey </option>
                </select>
            </p>
            <p>
                <label>peg_leg</label><br />
                <input type="checkbox"
                    name="peg_leg"
                    checked={peg_leg}
                    onChange={(e) => { setPeg_leg(e.target.checked) }} />
            </p>
            <p>
                <label>eye_patch</label><br />
                <input type="checkbox"
                    name="eye_patch"
                    checked={eye_patch}
                    onChange={(e) => { setEye_patch(e.target.checked) }} />
            </p>
            <p>
                <label>hook_hand</label><br />
                <input type="checkbox"
                    name="hook_hand"
                    checked={hook_hand}
                    onChange={(e) => { setHook_hand(e.target.checked) }} />
            </p>
            <input type="submit" />
        </form>
    )
}