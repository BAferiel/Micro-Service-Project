package tn.esprit.microservices.commande_micro.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;



@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCommande;
    private Long id_user;

    private Long idService;

    @Enumerated(EnumType.STRING)

    private StatusCommande status_c;

    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    private  Float price;
}
