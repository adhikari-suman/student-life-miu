import './App.css';
import axios from "axios";
import {useEffect, useState} from "react";
import {Link, Route, Routes} from "react-router-dom";
import Person from "./component/person/Person";

const People = ({people}) => {
    return <ul>
        {people.map(person =>
            <Person key={person.id} fName={person.firstName} lName={person.lastName}/>
        )}
    </ul>;
}

const Home = () => <h2>Home sweet home</h2>;

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
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <ul className="navbar-nav">
                    <li className="nav-item"><Link to="/">Home</Link></li>
                    <li className="nav-item"><Link to="/persons">All Persons</Link></li>
                    <li className="nav-item"><Link to="/persons/add">Add a person</Link></li>
                </ul>
            </nav>

            <div>
                <Routes>
                    <Route path="/" element={<Home/>} index="true"/>
                    <Route path="/persons" element={<People people={personState}/>}/>
                    <Route path="/persons/add" element={<Home/>}/>
                </Routes>
            </div>

        </div>
    );
}

export default App;
