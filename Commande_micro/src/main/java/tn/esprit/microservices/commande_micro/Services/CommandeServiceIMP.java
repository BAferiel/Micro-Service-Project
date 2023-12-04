package tn.esprit.microservices.commande_micro.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservices.commande_micro.Entity.Commande;
import tn.esprit.microservices.commande_micro.Repository.CommandeRepo;

import java.util.List;

@Service
public class CommandeServiceIMP {
    @Autowired
    private CommandeRepo commandeRepo;
    public Commande addCommande(Commande C){
        return commandeRepo.save(C);
    }

    public Commande updateCommande(long idCommande, Commande newCommande) {

        if (commandeRepo.findById(idCommande).isPresent()) {
            Commande existingCommande = commandeRepo.findById(idCommande).get();
            if(newCommande.getStatus_c()!=null){
                existingCommande.setStatus_c(newCommande.getStatus_c());}
            if(newCommande.getDateCommande()!=null){
                existingCommande.setDateCommande(newCommande.getDateCommande());}
            if (newCommande.getPrice()!=null){
                existingCommande.setPrice(newCommande.getPrice());}

            return commandeRepo.save(existingCommande);
        } else
            return null;
    }
    public String deleteCommande(long idCommande) {
        if (commandeRepo.findById(idCommande).isPresent()) {
            commandeRepo.deleteById(idCommande);
            return "Commande supprimé";
        } else
            return "Commande non supprimé";
    }
    public List<Commande> getAllCommande(){
        return commandeRepo.findAll();
    }

    public Commande getCommandeById(Long idCommande) {
        return commandeRepo.findById(idCommande).orElse(null);
    }
}
