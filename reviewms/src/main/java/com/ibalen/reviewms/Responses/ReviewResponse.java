package com.ibalen.reviewms.Responses;

import com.ibalen.reviewms.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponse {

    String ResponseString;
    String ResponseCode;
    List<Review> reviewList;
    Review review;
}
