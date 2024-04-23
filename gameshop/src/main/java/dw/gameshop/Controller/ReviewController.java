package dw.gameshop.Controller;

import dw.gameshop.Model.Review;
import dw.gameshop.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review")
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.saveReview(review), HttpStatus.OK);
    }

    @GetMapping("/review")
    public ResponseEntity<List<Review>> getReviewAll() {
        return new ResponseEntity<>(reviewService.getReviewAll(),HttpStatus.OK);
    }
}
