package tn.esprit.microservices.commande_micro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.microservices.commande_micro.Entity.Commande;

public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
