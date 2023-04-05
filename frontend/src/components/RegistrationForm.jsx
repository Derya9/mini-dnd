import React, {useState} from 'react'
import '../css/RegistrationForm.css';
import {useNavigate} from "react-router-dom";


const RegistrationForm = () => {
    const INITIAL_DATA = {
        userName: "",
        email: "",
        password: ""
    }

    const [data, setData] = useState(INITIAL_DATA);
    const navigate = useNavigate();

    function updateData(newInput) {
        setData({
            ...data, ...newInput
        })
    }


    async function onSubmit(e) {
        e.preventDefault()
        console.log(data)

        const response = await fetch("http://localhost:8080/auth/registration", {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {

            const result = await response.text();
            console.log(result);
            localStorage.setItem('result', result)
            alert("Account created successfully")
            // if (res.status === 200) {
            //     alert("You successfully added your character!")
            // } else {
            //     alert(`Error (${res.status})`)
            // }
        }
        navigate("/");
    }


    return (
        <div className='accountDataForm'>
            <form onSubmit={onSubmit}>
                <label>
                    Username:
                    <input type="userName"
                           id="userName"
                           name="userName"
                           onChange={(e) => updateData({...data, userName: e.target.value})} required>

                    </input>
                </label>
                <br/>

                <label>
                    E-Mail:
                </label>
                <input
                    type='email'
                    id='email'
                    name='email'
                    onChange={(e) => updateData({...data, email: e.target.value})} required>
                </input>
                <br/>

                <label>
                    password (must contain 8 characters, a capital letter, an uppercase letter, a digit):
                    <input type="password"
                           name="password"
                           id="password"
                           // pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"
                           title="Must contain 8 characters, a capital letter, an uppercase letter, a digit"
                           onChange={(e) => updateData({...data, password: e.target.value})} required/>
                </label>
                <br />

                {/*<label>*/}
                {/*    repeat password:*/}
                {/*    <input type="password"*/}
                {/*           name="password2"*/}
                {/*           id="password2"/>*/}
                {/*</label>*/}
                {/*<br />*/}

                <button className="submitButton" type="submit">Register</button>
            </form>
        </div>
    )
}

export default RegistrationForm