import React from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

const PirateList = (props) => {

    const { removeFromDom } = props;
    const deletePirate = (pirateId) => {
        axios.delete('http://localhost:8000/api/pirate/' + pirateId)
            .then(res => {
                removeFromDom(pirateId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div>
            {props.pirate.map((pirate, i) =>
                <p key={i}>
                    {pirate.pirateName}
                    <br /><img src={pirate.image}></img>
                    <br />{pirate.treasure}
                    <br />{pirate.catchPhrase}
                    <br />{pirate.position}
                    <br /><button><Link to={"/pirate/" + pirate._id + "/edit"}>
                        update pirate
                    </Link>
                    </button>
                    <br/><button onClick={(e) => { deletePirate(pirate._id) }}>
                        Delete
                    </button>
                </p>
            )}
            <p>This is a test</p>
        </div>
    )
}

export default PirateList;