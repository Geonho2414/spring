package dw.gameshop.Service;

import dw.gameshop.Model.Review;
import dw.gameshop.Repository.GameshopRepository;
import dw.gameshop.Repository.ReviewRepository;
import dw.gameshop.Repository.UserRepository;
import dw.gameshop.dto.ReviewDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
// DayaBase 용어 데이터를 insert 할때, 하나의 리소스에서 타겟으로 출발하는
// Data 여러개의 저장 '묶음'을 전송하는데 데이터를 열고, 저장하고, 닫을때까지의 모든 과정을 Transaction 이라고 한다.
// 묶음이 보내지다 중간에 끊어지면 갑자기 에러가 나면 그 묶음 전체를 무효화 시키는 것이 @Transactional 이다.
// @Transactional 을 안쓸시 진행을 안하고 취소를 해도 값은 이미 변경되서 있을것이다.
// ex) 결제를 중간에 취소했는데 이미 돈이 보내짐
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

    //DTO
    //어려운 방법
//    public List<ReviewDto> getReviewAllByDto() {
//        List<Review> reviewList = reviewRepository.findAll();
//        List<ReviewDto> reviewDtoList = new ArrayList<>();
//        for (int i=0; i<reviewList.size(); i++) {
//            ReviewDto reviewDto = new ReviewDto();
//            reviewDto.setReviewPoint(reviewList.get(i).getPoint());
//            reviewDto.setReviewText(reviewList.get(i).getReviewText());
//            reviewDto.setGameName(reviewList.get(i).getGameshop().getTitle());
//            reviewDto.setUserId(reviewList.get(i).getUser().getUserId());
//            reviewDto.setGameId(reviewList.get(i).getGameshop().getId());
//            reviewDtoList.add(reviewDto);
//        }
//        return reviewDtoList;
//    }
    //쉬운 방법 - 나머지 긴 줄들은 Dto에 작성
    public List<ReviewDto> getReviewAllByDto() {
        List<Review> reviewList = reviewRepository.findAll();
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            ReviewDto reviewDto = new ReviewDto();
            reviewDtoList.add(reviewDto.toReviewDto(reviewList.get(i)));
        }
        return reviewDtoList;
    }
}
