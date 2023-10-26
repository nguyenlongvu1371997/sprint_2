import { useParams } from "react-router-dom";
import { getMovieById } from "../service/MovieService";
import { useEffect } from "react";

export default function DetailMovie() {
    const [movie, setMovie] = useState();
    useEffect(() => {
        getMovie();
    }, [])

    const getMovie = async () => {
        const id = useParams();
        const res = getMovieById(id);
        setMovie((pre) => res);
    }
    return (
        <>
        </>
    )
}