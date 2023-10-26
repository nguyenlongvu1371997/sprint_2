import { useEffect, useState } from "react";
import { getHistoryTicket } from "../service/Ticket";
import Header from "./Header";

export default function HistoryTicket() {
    const [tickets, setTickets] = useState([]);
    const getTickets = async () => {
        const res = await getHistoryTicket();
        setTickets((pre) => res);
    }
    useEffect(() => {
        getTickets();
    }, []);
    const getPrice = (date)=>{
        const day = new Date(date);
        if (date) {
            const options = { weekday: 'long' };
            const date = day.toLocaleString('en-US', options);
            if (date === "Saturday" || date === "Sunday") {
                return "2,5 USD";
            } else {
                return "2 USD";
            }
        }
    }
    return (
        <div>
            <Header />
           <div className="mt-5 pt-5" />
            <div className="mt-5 pt-5">
                <h1>TICKET HISTORY</h1>
                <table>
                    <tr>
                        <td></td>
                        <td>Movie</td>
                        <td>Room</td>
                        <td>Seat</td>
                        <td>Time</td>
                        <td>Price</td>
                    </tr>
                    {tickets.map((t) => (
                        <tr key={t.id}>
                            <td><img src={t.picture} style={{width:'3rem', height: '4.5rem'}}></img></td>
                            <td>{t.nameMovie}</td>
                            <td>{t.room}</td>
                            <td>{t.seat}</td>
                            <td>{t.timeShow.substring(0,16)}</td>
                            <td>{getPrice(t.timeShow.substring(0,10))}</td>
                        </tr>
                    ))}
                </table>
            </div>
        </div>
    )
}