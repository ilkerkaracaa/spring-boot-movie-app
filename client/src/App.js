import "./App.css";
import api from "./api/axiosConfig";
import { useState, useEffect } from "react";

function App() {
  const [movies, setMovies] = useState();
  const getMovies = async () => {
    try {
      const response = await api.get("/api/v1/movies");
      console.log(response.data);
      setMovies(response.data);
    } catch (err) {
      console.log(err);
    }
  };
  useEffect(() => {
    getMovies();
  }, []);
  return <div className="App"></div>;
}

// import "./App.css";
// import React, { useState, useEffect } from "react";
// import axios from "axios";

// function App() {
//   const [films, setFilms] = useState([]);

//   useEffect(() => {
//     // Endpoint URL'nizi buraya yazın
//     const endpoint = "http://localhost:8080/api/v1/movies"; // Örnek URL

//     // Axios ile veri isteği yapma
//     axios
//       .get(endpoint)
//       .then((response) => {
//         setFilms(response.data);
//       })
//       .catch((error) => {
//         console.error("Error fetching data:", error);
//       });
//   }, []);

//   console.log(films);

//   return (
//     <div>
//       <h1>Filmler</h1>
//       <ul>
//         {films.map((film) => (
//           <li key={film.imdbId}>{film.title}</li>
//         ))}
//       </ul>
//     </div>
//   );
// }

export default App;
