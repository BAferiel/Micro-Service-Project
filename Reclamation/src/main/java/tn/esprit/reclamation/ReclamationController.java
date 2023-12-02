package tn.esprit.reclamation;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
public class ReclamationController {

    private final ReclamationServiceIMP reclamationServiceIMP;

    public ReclamationController(ReclamationServiceIMP reclamationServiceIMP) {
        this.reclamationServiceIMP = reclamationServiceIMP;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        Reclamation createdReclamation = reclamationServiceIMP.createReclamation(reclamation);
        return new ResponseEntity<>(createdReclamation, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamation) {
        Reclamation updatedReclamation = reclamationServiceIMP.updateReclamation(id, reclamation);
        return new ResponseEntity<>(updatedReclamation, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteReclamation(@PathVariable Long id) {
        reclamationServiceIMP.deleteReclamation(id);
        return new ResponseEntity<>("Reclamation with ID " + id + " deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllReclamations")
    public ResponseEntity<List<Reclamation>> getAllReclamation() {
        List<Reclamation> allReclamations = reclamationServiceIMP.getAllReclamation();
        return new ResponseEntity<>(allReclamations, HttpStatus.OK);
    }

    @GetMapping("/getReclamationById/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id) {
        Reclamation reclamation = reclamationServiceIMP.getReclamationById(id);
        return reclamation != null
                ? new ResponseEntity<>(reclamation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
