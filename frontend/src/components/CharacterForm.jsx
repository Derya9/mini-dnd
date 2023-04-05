import React, {useState} from 'react'
import {useNavigate} from "react-router-dom";
import Header from "./Header";


const CharacterForm = () => {
    const INITIAL_DATA = {
        name: "", race: "ELF", characterClass: "DRUID"
    }

    const [data, setData] = useState(INITIAL_DATA);
    const navigate = useNavigate()


    function updateData(newInput) {
        setData({
            ...data, ...newInput
        })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        console.log(data)

        const response = await fetch("/characters/add", {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const result = await response.json();
        console.log(result);
        // if (res.status === 200) {
        //     alert("You successfully added your character!")
        // } else {
        //     alert(`Error (${res.status})`)
        // }
        navigate("/");
    }

    return (<div className="characterForm">
            <form onSubmit={handleSubmit}>
                <label>Name:</label>
                <input
                    type='text'
                    id='name'
                    name='name'
                    onChange={(e) => updateData({...data, name: e.target.value})} required>
                </input>
                <br/>
                <label>Race:</label>
                <select
                    type="text"
                    name="race"
                    onChange={(e) => updateData({...data,race: e.target.value})} required>>
                    <option value="ELF">Elf</option>
                    <option value="DWARF">Dwarf</option>
                    <option value="HUMAN">Human</option>
                </select>
                <br/>
                <label>Character Class:</label>
                <select
                    type="text"
                    name="characterClass"
                    onChange={(e) => updateData({...data,characterClass: e.target.value})} required>>
                    <option value="DRUID">Druid</option>
                    <option value="FIGHTER">Fighter</option>
                    <option value="MAGE">Mage</option>
                </select>
                <br/>
                <button className="submitButton" type="submit" required>Add</button>
            </form>
        </div>)
}

export default CharacterForm;