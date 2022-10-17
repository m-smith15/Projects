import React, { useEffect, useState } from 'react';
import PirateForm from '../components/PirateForm';
import PirateList from '../components/PirateList';
import axios from 'axios';
import { Link } from 'react-router-dom'


const Main = (props) => {
    const [pirate, setPirate] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/pirate')
            .then(res => {
                setPirate(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = pirateId => {
        setPirate(pirate.filter(pirate => pirate._id !== pirateId));
    }

    return (
        <div>
            <br />
            <button >
                <Link to={"/pirate/new"}>
                    Create new pirate
                </Link>
            </button>
            <hr />
            {loaded && <PirateList pirate={pirate} removeFromDom={removeFromDom} />}
        </div>
    )
}
export default Main;