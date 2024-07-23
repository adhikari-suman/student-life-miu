import {Component} from "react";


function Person(props){

    return (
        <div>
            Firstname: {props.fname}
            Lastname: {props.lname}
        </div>
    );
}

export default Person;