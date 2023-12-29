package dev.ilker.movies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private MovieRepository movieRepository;

  public Review createReview(String reviewBody, String imdbId) {
    Review review = reviewRepository.save(new Review(reviewBody)); // Yeni inceleme oluştur

    Optional<Movie> optionalMovie = movieRepository.findMovieByImdbId(imdbId); // İlgili filmi bul

    if (optionalMovie.isPresent()) {
      Movie movie = optionalMovie.get();
      movie.getReviewIds().add(review); // Filmdeki inceleme listesine yeni incelemeyi ekle
      movieRepository.save(movie); // Filmi güncelle
    } else {
      // İlgili film bulunamadı, burada uygun bir hata işleme mekanizması kullanılabilir
      throw new IllegalArgumentException("Movie with IMDb ID " + imdbId + " not found");
    }

    return review;
  }
}


// @Service
// public class ReviewService {

//   @Autowired
//   private ReviewRepository reviewRepository;

//   @Autowired
//   private MongoTemplate mongoTemplate;

//   public Review createReview(String reviewBody, String imdbId) {
//     Review review = reviewRepository.insert(new Review(reviewBody));

//     mongoTemplate.update(Movie.class)
//       .matching(Criteria.where("imdbId").is(imdbId))
//       .apply(new Update().push("reviewsIds").value(review))
//       .first();

//       return review;
//   }
// }


