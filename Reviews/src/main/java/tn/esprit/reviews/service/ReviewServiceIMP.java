package tn.esprit.reviews.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.reviews.entity.Review;
import tn.esprit.reviews.repo.ReviewRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceIMP implements IReview {
    private ReviewRepo reviewRepo;

    @Override
    public Review addReview(Review review) {

        review.setReviewDate(LocalDate.now());
        return reviewRepo.save(review);
    }

    @Override
    public Review getReviewById(Long idReview) {
        return reviewRepo.findById(idReview).orElse(null);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review updateReview(Long idReview, Review updatedReview) {
        return reviewRepo.save(updatedReview);
    }

    @Override
    public void deleteReview(Long idReview) {
        reviewRepo.deleteById(idReview);

    }

    @Override
    public List<Review> findByServiceName(String serviceName) {
        return reviewRepo.findByServiceName(serviceName);
    }
}
