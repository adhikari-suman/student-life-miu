import './App.css';
import Counter from "./Counter";
import Person from "./component/person/Person";
import axios from "axios";
import {useEffect, useState} from "react";

function App() {
    const personList = [
        {id: 1, firstName: 'Allen', lastName: 'Walker'}
    ];

    const [personState, setPersonState] = useState(personList);

    const getAllPerson = async () => {
        const result = await axios.get("http://localhost:8080/persons");
        setPersonState(result.data);
    }

    useEffect(() => {
        getAllPerson();
    }, []);

    return (
        <div className="App">
            {
                personState.map((person) => (
                    <Person fname={person.firstName} lname={person.lastName} key={person.id}/>
                ))
            }
            <Counter/>
        </div>
    );
}

export default App;
