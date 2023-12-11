package com.esprit.microservice.projet_microservice.Restcontroler;

import com.esprit.microservice.projet_microservice.ServiceImp.ServiceServiceImp;
import com.esprit.microservice.projet_microservice.entite.ServiceE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ServiceE")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceResteControle {
    @Autowired
    public ServiceServiceImp serviceServiceImp;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ServiceE> addService(@RequestBody ServiceE S){
        return new ResponseEntity<>(serviceServiceImp.addService(S),HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServiceE> updateCandidat(@PathVariable(value = "id") int id, @RequestBody ServiceE E){
        return new ResponseEntity<>(serviceServiceImp.updateService(id,E),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(serviceServiceImp.deleteService(id), HttpStatus.OK);
    }
    @GetMapping("/getallservice")
    public List<ServiceE> getAllServices(){
        return serviceServiceImp.getAllServices();
    }
    @GetMapping("/getServiceByid/{idService}")
    public ServiceE getServiceById(@PathVariable Long idService){
        return serviceServiceImp.getServiceById(idService);
    }
}
