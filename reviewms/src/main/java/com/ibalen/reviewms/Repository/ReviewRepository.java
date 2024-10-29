package com.ibalen.reviewms.Repository;

import com.ibalen.reviewms.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("FROM Review rt WHERE rt.companyId = :companyId")
    public List<Review> findAllByCompanyId(@Param("companyId") Long companyId);
}
