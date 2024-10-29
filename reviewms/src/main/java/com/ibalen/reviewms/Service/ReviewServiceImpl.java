package com.ibalen.reviewms.Service;

import com.ibalen.reviewms.Entity.Review;
import com.ibalen.reviewms.Repository.ReviewRepository;
import com.ibalen.reviewms.Responses.ReviewRequest;
import com.ibalen.reviewms.Responses.ReviewResponse;
import com.ibalen.reviewms.Utils.ReviewUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository rR){
        this.reviewRepository = rR;
    }

    @Override
    public ReviewResponse getAll() {
        return ReviewResponse.builder()
                .ResponseString(ReviewUtils.REVIEWS_OK)
                .ResponseCode(ReviewUtils.REVIEWS_OK_CODE)
                .reviewList(reviewRepository.findAll())
                .build();
    }

    @Override
    public ReviewResponse getReviewById(Long id) {
        Review review =  reviewRepository.findById(id).orElse(null);
        if(review == null) return ReviewResponse.builder()
                .ResponseString(ReviewUtils.REVIEW_NOT_EXISTS)
                .ResponseCode(ReviewUtils.REVIEW_NOT_EXISTS_CODE)
                .build();

        return ReviewResponse.builder()
                .review(review)
                .ResponseString(ReviewUtils.REVIEW_EXISTS)
                .ResponseCode(ReviewUtils.REVIEW_EXISTS_CODE)
                .build();
    }

    @Override
    public ReviewResponse updateReviewById(Long id, ReviewRequest reviewRequest) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review == null) return ReviewResponse.builder()
                .ResponseString(ReviewUtils.REVIEW_NOT_EXISTS)
                .ResponseCode(ReviewUtils.REVIEW_NOT_EXISTS_CODE)
                .build();

        review.setText(reviewRequest.getText());
        review.setStars(reviewRequest.getStars());
        reviewRepository.save(review);

        return ReviewResponse.builder()
                .review(review)
                .ResponseString(ReviewUtils.REVIEW_CREATED)
                .ResponseCode(ReviewUtils.REVIEW_CREATED_CODE)
                .build();
    }

    @Override
    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        Review review = Review.builder()
                .companyId(reviewRequest.getCompanyId())
                .stars(reviewRequest.getStars())
                .text(reviewRequest.getText())
                .build();

        reviewRepository.save(review);

        return ReviewResponse.builder()
                .review(review)
                .ResponseString(ReviewUtils.REVIEW_CREATED)
                .ResponseCode(ReviewUtils.REVIEW_CREATED_CODE)
                .build();
    }

    @Override
    public ReviewResponse deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review == null) return ReviewResponse.builder()
                .ResponseString(ReviewUtils.REVIEW_NOT_EXISTS)
                .ResponseCode(ReviewUtils.REVIEW_NOT_EXISTS_CODE)
                .build();

        reviewRepository.deleteById(id);

        return ReviewResponse.builder()
                .ResponseString(ReviewUtils.REVIEW_DELETED)
                .ResponseCode(ReviewUtils.REVIEW_DELETED_CODE)
                .build();
    }

    @Override
    public List<Review> getReviewsForCompanyId(Long companyId) {

        return reviewRepository.findAllByCompanyId(companyId);
    }
}
