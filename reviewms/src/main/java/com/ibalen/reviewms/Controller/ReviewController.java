package com.ibalen.reviewms.Controller;

import com.ibalen.reviewms.Entity.Review;
import com.ibalen.reviewms.Responses.ReviewRequest;
import com.ibalen.reviewms.Responses.ReviewResponse;
import com.ibalen.reviewms.Service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewServiceImpl reviewServiceImpl;

    @Autowired
    public ReviewController(ReviewServiceImpl rs){
        this.reviewServiceImpl = rs;
    }

    @RequestMapping("")
    public ReviewResponse getAllReviews(){
        return reviewServiceImpl.getAll();
    }

    @PostMapping("/create")
    public ReviewResponse createJob(@RequestBody ReviewRequest reviewRequest){
        return reviewServiceImpl.createReview(reviewRequest);
    }

    @PutMapping("/update/{id}")
    public ReviewResponse updateJob(@PathVariable Long id, @RequestBody  ReviewRequest reviewRequest){
        return reviewServiceImpl.updateReviewById(id, reviewRequest);
    }

    @GetMapping("/{id}")
    public ReviewResponse getJobById(@PathVariable Long id){
        return  reviewServiceImpl.getReviewById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ReviewResponse deleteJobById(@PathVariable Long id){
        return reviewServiceImpl.deleteReviewById(id);
    }

    @GetMapping
    public List<Review> getReviewsForCompany(@RequestParam(value = "company") Long companyId){

        return reviewServiceImpl.getReviewsForCompanyId(companyId);
    }

}
