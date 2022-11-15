import React from 'react';
import AdditionForm from '../components/AdditionForm';

const Addition = (props) => {
    // const [test, setTest] = useState(0);

    //getting to know the API call here, and brushing up on useState

    // const buttonTest = () => {
    //     axios.get('http://api.mathjs.org/v4/?expr=2%2B2')
    //         .then(response => {
    //             console.log(response)
    //             setTest(response.data)
    //         })
    // }

    return (
        <div>
            <AdditionForm />
            <br/>
            {/* <button onClick = {buttonTest}> click this button to make API call</button>

            <div>
                peep this: {test}
            </div> */}
        </div>
    )
}
export default Addition