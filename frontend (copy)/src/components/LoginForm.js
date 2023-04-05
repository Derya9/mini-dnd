import React, {useState} from 'react'
import '../css/LoginForm.css';
import {useNavigate} from "react-router-dom";
import {Buffer} from "buffer";


const LoginForm = () => {
    const [data, setData] = useState({email: "", password: ""});
    const navigate = useNavigate();

    async function login(e) {
        e.preventDefault()
        const headers = new Headers();
        console.log(data)
        console.log(data.email)
        console.log(data.password)
        const auth = Buffer.from(data.email + ":" + data.password).toString("base64");
        console.log(auth)
        headers.set("Authorization", "Basic " + auth)

        fetch('http://localhost:8080/auth/login', {
            method: 'GET',
            headers: {headers}
        }).then(response => response.text())
            .then(text => console.log("Success: " + text))
            .catch(error => console.error(error))
        // if (response.ok) {
        //     const token = await response.text()
        //     console.log(token)
        //     localStorage.setItem('token', token)
        //     navigate("/")
        // } else {
        //     const error = await response.text()
        //     console.log(error)
        //     localStorage.setItem('loggedInUserEmail', JSON.stringify(data.email));
        //     alert("Wrong username or password")
        // }
    }

    function updateData(newInput) {
        setData({
            ...data, ...newInput
        })
    }

    return (
        <div className='accountDataForm'>
            <form onSubmit={login}>
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
                    password:
                    <input type="password"
                           name="password"
                           id="password"
                           onChange={(e) => updateData({...data, password: e.target.value})} required/>
                </label>
                <br/>
                <button className="submitButton" type="submit">Login</button>
            </form>
        </div>
    )
}

export default LoginForm
