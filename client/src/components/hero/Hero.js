import "./Hero.css";
import Carousel from "react-material-ui-carousel";
import { Paper } from "@mui/material";

const Hero = ({ movies }) => {
  if (!movies || !Array.isArray(movies)) return <div>Loading movies...</div>;
  return (
    <div className="movie-carousel-container">
      <Carousel>
        {movies.map((movie) => {
          return (
            <Paper>
              <div className="movie-card-container">
                <div className="movie-card">
                  <div className="movie-detail">
                    <div className="movie-poster">
                      <img src={movie.poster} alt="" />
                    </div>
                    <div className="movie-title">
                      <h3>{movie.title}</h3>
                    </div>
                  </div>
                </div>
              </div>
            </Paper>
          );
        })}
      </Carousel>
    </div>
  );
};

export default Hero;
