package tn.esprit.microsubscription.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sub;
    @Enumerated(EnumType.STRING)
    private TypeSubscription type_sub;
    @Temporal(TemporalType.DATE)
    private Date dateExp_sub;
    //@OneToOne(mappedBy = "subscription")
    //private User user;
}
