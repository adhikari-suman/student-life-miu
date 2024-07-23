import {useState} from "react";

function Counter() {

    const onMinusClicked = () => {
        setState(state - 1);

    }
    const onPlusClicked = () => {
        setState(state + 1);
    }
    const [state, setState] = useState(0)

    return (
        <div>
            <input type="button" value="-" onClick={onMinusClicked}/>
            <span> {state} </span>
            <input type="button" value="+" onClick={onPlusClicked}/>
        </div>
    );
}

export default Counter;