import React, { useEffect, useState } from 'react';
import PirateForm from '../components/PirateForm';
import axios from 'axios';


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


    return (
        <div>
            <br />
            <PirateForm />
            <hr />
        </div>
    )
}
export default Main;