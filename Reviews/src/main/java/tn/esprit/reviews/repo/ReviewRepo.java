package tn.esprit.reviews.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.reviews.entity.Review;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByServiceName(String serviceName);
}
