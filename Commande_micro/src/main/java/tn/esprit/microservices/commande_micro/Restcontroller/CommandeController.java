package tn.esprit.microservices.commande_micro.Restcontroller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservices.commande_micro.Entity.Commande;
import tn.esprit.microservices.commande_micro.Services.CommandeServiceIMP;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Commande")
public class CommandeController {
    @Autowired
    public CommandeServiceIMP commandeServiceImp;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Commande> addCommande(@RequestBody Commande C){
        return new ResponseEntity<>(commandeServiceImp.addCommande(C),HttpStatus.OK);
    }
    @PutMapping(value = "/{idCommande}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "idCommande") int idCommande, @RequestBody Commande C){
        return new ResponseEntity<>(commandeServiceImp.updateCommande(idCommande,C),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{idCommande}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCommande(@PathVariable(value = "idCommande") int idCommande){
        return new ResponseEntity<>(commandeServiceImp.deleteCommande(idCommande), HttpStatus.OK);
    }
    @GetMapping("/getAllCommande")
    public List<Commande> getAllCommande(){
        return commandeServiceImp.getAllCommande();
    }
    @GetMapping("/getCommandeByid/{idCommande}")
    public Commande getCommandeById(@PathVariable Long idCommande){
        return commandeServiceImp.getCommandeById(idCommande);
    }


}
