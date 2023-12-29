package dev.ilker.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {

  @GetMapping
  public ResponseEntity<String> allMovies() {
    return new ResponseEntity<String>("All movies", HttpStatus.OK);
  }
}
