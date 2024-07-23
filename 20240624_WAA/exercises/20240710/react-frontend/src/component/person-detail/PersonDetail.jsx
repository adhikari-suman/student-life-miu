import {useEffect, useState} from "react";
import axios from "axios";

export default function PersonDetail(props) {
    const [personDetailState, setPersonDetailState] = useState({});

    const getPersonDetail = async () => {
        const id = props.id; // GET from router params
        const response = await axios.get(`/persons/${id}`);
        setPersonDetailState(response.data);
    };

    useEffect(() => {
        getPersonDetail();
    }, []);


    return <></>;
}