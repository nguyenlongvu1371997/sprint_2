import axios from "axios";

export async function getSeatByShowtimeId(id){
    const res = await axios.get("http://localhost:8080/api/seat/showtime?id="+id);
    return res.data;
}