import {useEffect, useState} from "react";

const LandingPage = () => {
    const [character, setCharacter] = useState([]);

    const fetchData = () => {
        return fetch("http://localhost:8080/characters")
            .then((response) => response.json())
            .then(data => {setCharacter(data);
            })
    }

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <div>
            <p>LandingPage</p>
            <p>{character} ++ </p>
        </div>
    );
}

export default LandingPage;