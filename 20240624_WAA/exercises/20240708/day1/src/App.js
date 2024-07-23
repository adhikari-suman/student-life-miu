import logo from './logo.svg';
import './App.css';
import Counter from "./Counter";
import Person from "./Person";

function App() {
    const personList = [
        {id: 1, firstName: 'Allen', lastName: 'Walker'},
        {id: 2, firstName: 'Suman', lastName: 'Adhikari'},
    ];

  return (
    <div className="App">
        {
            personList.map((person) => (
                <Person fname={person.firstName} lname={person.lastName} key={person.id} />
            ))
        }
      <Counter />
    </div>
  );
}

export default App;
