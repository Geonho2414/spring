package dw.gameshop.dto;

import dw.gameshop.Model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto {
    private long gameId;
    private String gameName;
    private String userId;
    private int reviewPoint;
    private String reviewText;

    //Review 엔티티를 ReviewDto 타입으로 형변환하는 메서드
    public ReviewDto toReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setReviewPoint(review.getPoint());
        reviewDto.setReviewText(review.getReviewText());
        reviewDto.setGameName(review.getGameshop().getTitle());
        reviewDto.setUserId(review.getUser().getUserId());
        reviewDto.setGameId(review.getGameshop().getId());
        return reviewDto;
    }
}
