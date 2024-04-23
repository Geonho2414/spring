package dw.gameshop.Service;

import dw.gameshop.Model.Review;
import dw.gameshop.Repository.GameshopRepository;
import dw.gameshop.Repository.ReviewRepository;
import dw.gameshop.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    GameshopRepository gameshopRepository;
    @Autowired
    UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, GameshopRepository gameshopRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.gameshopRepository = gameshopRepository;
        this.userRepository = userRepository;
    }

    public Review saveReview(Review review){
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public List<Review> getReviewAll(){return reviewRepository.findAll();}
}
