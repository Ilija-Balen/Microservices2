package com.ibalen.reviewms.Service;

import com.ibalen.reviewms.Entity.Review;
import com.ibalen.reviewms.Responses.ReviewRequest;
import com.ibalen.reviewms.Responses.ReviewResponse;

import java.util.List;

public interface ReviewService {

    public ReviewResponse getAll();
    public ReviewResponse getReviewById(Long id);
    public ReviewResponse updateReviewById(Long id, ReviewRequest reviewRequest);
    public ReviewResponse createReview(ReviewRequest reviewRequest);
    public ReviewResponse deleteReviewById(Long id);
    public List<Review> getReviewsForCompanyId(Long companyId);
}
