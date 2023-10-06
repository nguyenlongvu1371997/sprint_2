import { date } from "yup";
import Header from "./Header";

export default function ShowtimeList() {

    return (
        <>
            <Header />

            <div className="container row" style={{ marginTop: '200px' }}>
                <div className="row" >


                </div>
                <div className="col-8">
                    <Movie />
                    <Movie />
                    <Movie />
                    <Movie />
                    <Movie />
                </div>
                <div className="col-4">
                    <h1>
                        This is the place for advertising
                    </h1>

                </div>
            </div>
        </>
    )
}

function Movie() {
    return (
        <>
            <div className="row mt-3" style={{ height: '200px' }}>
                <div className="col-2"><img src="https://m.media-amazon.com/images/M/MV5BMGEzZjdjMGQtZmYzZC00N2I4LThiY2QtNWY5ZmQ3M2ExZmM4XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg"></img></div>
                <div className="col-10">
                    <p>The Creator</p>
                    <p>Time: 2h30</p>
                    <div className="w-100 flex">
                        <div>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>
                            <span className="mx-2 px-2 border border-light rounded-3">12:30</span>



                        </div>


                    </div>
                </div>
                <hr className="mt-3"></hr>
            </div>
        </>
    )
} 