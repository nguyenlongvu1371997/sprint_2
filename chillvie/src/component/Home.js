
import { useState } from "react"
import Header from "./Header"

export default function Home() {
    const [currentlyShowingMovies, setCurrentlyShowingMovies] = useState([]);
    const [upcomingMovies, setUpcomingMovies] = useState([]);
    return (
    
        <>
            <Header />
            <div style={{  marginTop: '120px' }} >
                <section className="home container"  id="home">
                    {/* Home Image */}
                    <img
                        src="https://www.elleman.vn/app/uploads/2018/03/09/xep-hang-phim-sieu-anh-hung-marvel-elle-man-feature-10.jpg"
                        alt="home-img"
                        className="home-img"
                    />
                    {/* Home Text */}
                    <div className="home-text">

                    </div>
                </section>
            </div>
            <section className="popular container" id="popular">
      {/* Heading */}
      <div className="heading">
        <h2 className="heading-title">Showing Movies</h2>
        <div className="swiper-btn">
          <div className="swiper-button-prev"></div>
          <div className="swiper-button-next"></div>
        </div>
      </div>
      {/* Content */}
      <div className="popular-content swiper">
        <div className="swiper-wrapper">
          {/* Movie Box Start */}
          {currentlyShowingMovies.map((m) => (
            <div className="swiper-slide" key={m.id}>
              <div className="movie-box">
                <img src={m.img} alt="" className="movie-box-img" />
                <div className="box-text">
                  <h2 className="movie-title">{m.getMovieName()}</h2>
                  <span className="movie-type">{m.getMovieTypes().getMovieTypes()}</span>
                  <a href={`/home/play_page/${m.id}`} className="promo-button play-btn">
                    <i className="bx bx-right-arrow"></i>
                  </a>
                </div>
              </div>
            </div>
          ))}
          {/* Movie Box End */}
        </div>
      </div>
    </section>

    <section className="movies container" id="movies">
      {/* Heading */}
      <div className="heading">
        <h2 className="heading-title">Upcoming Movies</h2>
      </div>

      {/* Upcoming Movies */}
      <div className="movies-content">
        {/* Movie Box Start */}
        {upcomingMovies.map((m) => (
          <div className="movie-box" key={m.id}>
            <img src={m.img} alt="" className="movie-box-img" />
            <div className="box-text">
              <h2 className="movie-title">{m.getMovieName()}</h2>
              <span className="movie-type">{m.getMovieTypes().getMovieTypes()}</span>
              <a href={`/home/play_page/${m.id}`} className="promo-button play-btn">
                <i className="bx bx-right-arrow"></i>
              </a>
            </div>
          </div>
        ))}
        {/* Movie Box End */}
      </div>
    </section>
        </>
    )
}