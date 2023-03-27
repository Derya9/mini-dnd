import {useEffect, useState} from "react";

const CharacterDetails = () => {
    const [data, setData] = useState([]);

    const fetchData = () => {
        return fetch("/characters")
            .then((response) => response.json())
            .then(data => {setData(data);
            })
    }

    useEffect(() => {
        fetchData();
    }, [])
    console.log(data);

    return (
        <div>
            <p>Mini-DnD</p>
            {data.map((character) => (
                <div className="characterDetails" key ={character.id}>

                    <p>Name:
                            {character && character.name}
                    </p>
                    <p>Race: {character && character.race} </p>
                    <p>Character Class: {character && character.characterClass} </p>
                </div>
            ))}
        </div>
    );
}

export default CharacterDetails;