package tn.esprit.microsubscription.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microsubscription.Entities.Subscription;
import tn.esprit.microsubscription.Service.SubscriptionServiceIMP;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionController {
    public SubscriptionServiceIMP subscriptionSeviceIMP;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription sub){
        return new ResponseEntity<>(subscriptionSeviceIMP.addSubscription(sub),HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Subscription> updateSubscription(@PathVariable(value = "id") long id_sub, @RequestBody Subscription sub){
        return new ResponseEntity<>(subscriptionSeviceIMP.updateSubscription(id_sub,sub),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBubscription(@PathVariable(value = "id") long id_sub){
        return new ResponseEntity<>(subscriptionSeviceIMP.deleteBubscription(id_sub), HttpStatus.OK);
    }
    @GetMapping("/getAllSubscription")
    public List<Subscription> getAllSubscription(){
        return subscriptionSeviceIMP.getAllSubscription();
    }
    @GetMapping("/getSubscriptionById/{id}")
    public Subscription getSubscriptionById(@PathVariable(value = "id") long id_sub){
        return subscriptionSeviceIMP.getSubscriptionById(id_sub);
    }
}
