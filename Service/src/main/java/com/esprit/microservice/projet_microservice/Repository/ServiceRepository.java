package com.esprit.microservice.projet_microservice.Repository;

import com.esprit.microservice.projet_microservice.entite.ServiceE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceE,Long> {
}
