package tn.esprit.reviews.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.reviews.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
