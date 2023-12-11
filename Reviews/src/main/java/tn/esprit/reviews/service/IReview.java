package tn.esprit.reviews.service;

import tn.esprit.reviews.entity.Review;

import java.util.List;

public interface IReview {
    Review addReview(Review review);

    Review getReviewById(Long idReview);

    List<Review> getAllReviews();

    Review updateReview(Long idReview, Review updatedReview);

    void deleteReview(Long idReview);

    List<Review> findByServiceName(String serviceName);
}
