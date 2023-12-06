package tn.esprit.microsubscription.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microsubscription.Entities.Subscription;
@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription,Long> {
}
