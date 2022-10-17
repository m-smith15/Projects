import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const Update = (props) => {
    const { id } = useParams();
    const [pirateName, setPirateName] = useState("");
    const [image, setImage] = useState("");
    const [treasure, setTreasure] = useState(0);
    const [catchPhrase, setCatchPhrase] = useState("");
    const [position, setPosition] = useState("");
    const [peg_leg, setPeg_leg] = useState(false);
    const [eye_patch, setEye_patch] = useState(false);
    const [hook_hand, setHook_hand] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8000/api/pirate/' + id)
            .then(res => {
                setPirateName(res.data.pirateName);
                setImage(res.data.image);
                setTreasure(res.data.treasure);
                setCatchPhrase(res.data.catchPhrase);
                setPosition(res.data.position);
                setPeg_leg(res.data.peg_leg);
                setEye_patch(res.data.eye_patch);
                setHook_hand(res.data.hook_hand);
            })
    }, []);

    const updatePirate = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/pirate/' + id, {
            pirateName,
            image,
            treasure,
            catchPhrase,
            position,
            peg_leg,
            eye_patch,
            hook_hand
        })
            .then(res => {
                console.log(res)
                navigate('/')
            })
            .catch(err => console.error(err));
    }
    const updatePeg_leg = (e) => {
        e.preventDefault();
        setPeg_leg(!peg_leg)
    }
    const updateEye_patch = (e) => {
        e.preventDefault();
        setEye_patch(!eye_patch)
    }
    const updateHook_hand = (e) => {
        e.preventDefault();
        setHook_hand(!hook_hand)
    }

    return (
        <div>
            <h1>Update a Pirate</h1>
            <form onSubmit={updatePirate}>
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
                    <img src={image} />
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
                        name="position"
                        value={position}
                        onChange={(e) => { setPosition(e.target.value) }} >
                        <option value="Captain"> Captain </option>
                        <option value="First mate"> First mate </option>
                        <option value="Quarter Master"> Quarter Master </option>
                        <option value="Boatswain"> Boatswain </option>
                        <option value="Powder Monkey"> Powder Monkey </option>
                    </select>
                </p>
                <p>
                    <label>peg_leg</label><br />
                    <input type="text"
                        name="peg_leg"
                        value={peg_leg}
                        readOnly />
                        <button onClick={ updatePeg_leg }>Add/Remove peg_leg</button>
                </p>
                <p>
                    <label>eye_patch</label><br />
                    <input type="text"
                        name="eye_patch"
                        value={eye_patch}
                        readOnly />
                        <button onClick={ updateEye_patch }>Add/Remove eye_patch</button>
                </p>
                <p>
                    <label>hook_hand</label><br />
                    <input type="text"
                        name="hook_hand"
                        value={hook_hand}
                        readOnly />
                        <button onClick={ updateHook_hand }>Add/Remove hook_hand</button>
                </p>
                <input type="submit" />
            </form>
        </div>
    )
}
export default Update;