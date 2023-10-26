import axios from "axios";

export async function  getTicket(arr){
    const res = await axios.post("http://localhost:8080/api/ticket/ticket",arr);
    return res.data;
}

export async function  checkTicket(arr){
    const res = await axios.post("http://localhost:8080/api/ticket/check-ticket",arr);
    return res.data;
}


export async function  getHistoryTicket(){
    const res = await axios.get("http://localhost:8080/api/ticket/history-ticket");
    return res.data;
}