package tn.esprit.microsubscription.Service;

import tn.esprit.microsubscription.Entities.Subscription;

import java.util.List;

public interface ISubscription {
    public Subscription addSubscription(Subscription sub);
    public Subscription updateSubscription(long id_sub, Subscription newSub);
    public String deleteBubscription(long id_sub);
    public List<Subscription> getAllSubscription();
    public Subscription getSubscriptionById(Long id_sub);
}
