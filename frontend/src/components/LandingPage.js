import {useEffect, useState} from "react";

const LandingPage = () => {
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
            <a href="/characters/add"><p>Add character</p></a>
            {data.map((character) => (
                    <div className="characterContainer" key ={character.id}>

                            <p>Name:
                                <a href={"characters/" + character.id}>
                                    {character && character.name} </a>
                                </p>
                        <p>Race: {character && character.race} </p>
                        <p>Character Class: {character && character.characterClass} </p>
                    </div>
                ))}
        </div>
    );
}

export default LandingPage;