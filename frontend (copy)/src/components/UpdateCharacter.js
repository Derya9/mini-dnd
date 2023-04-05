import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";


const UpdateCharacter = () => {
    const [data, setData] = useState([])
    const {id} = useParams();
    const navigate = useNavigate()


    const fetchData = () => {
        return fetch("/characters/" + id)
            .then((response) => response.json())
            .then(data => {
                setData(data);
            })
    }

    useEffect(() => {
        fetchData();
    }, [])


    function updateData(newInput) {
        setData({
            ...data, ...newInput
        })
    }


    const updateCharacter = async () => {

        const request = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        };

        fetch("/characters/" + id + "/update", request)
            .then(response => response.json())
            .then(data => this.setState({ name: data.name }));
        navigate("/characters/" + id)
    }

    return (
        <div>
            <p>Mini-DnD</p>
            <div className="characterDetails" key={data.id}>

                <form onSubmit={updateCharacter}>
                    <label>Name:</label>
                    <input
                        type='text'
                        id='name'
                        name='name'
                        onChange={(e) => updateData({...data, name: e.target.value})} required>
                    </input>
                <p>Race: {data && data.race} </p>
                <p>Character Class: {data && data.characterClass} </p>
                <button className="updateButton" type="submit" onClick={updateCharacter}>Update Character
                </button> </form>

            </div>
        </div>);



}

export default UpdateCharacter;