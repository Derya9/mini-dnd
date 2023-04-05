import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";

const CharacterDetails = () => {
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
    console.log(data);

    let deleteCharacter = async () => {
        await fetch("/characters/" + id, {
            method: "DELETE",
        });
        navigate("/");
    };





    return (
        <div>
            <p>Mini-DnD</p>
            <div className="characterDetails" key={data.id}>

                <p>Name:{data && data.name}</p>
                <a href={"/characters/" + data.id + "/update"}><button>Change Name</button> </a>

                <p>Race: {data && data.race} </p>
                <p>Character Class: {data && data.characterClass} </p>
                <button className="deleteButton" type="submit" onClick={deleteCharacter}>Delete Character
                </button>

            </div>
        </div>);
}

export default CharacterDetails;