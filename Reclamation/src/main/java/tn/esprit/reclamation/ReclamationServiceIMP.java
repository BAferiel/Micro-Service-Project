package tn.esprit.reclamation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReclamationServiceIMP implements IReclamation{
    private ReclamationRepo reclamationRepo;
    @Override
    public Reclamation createReclamation(Reclamation reclamation) {
        return reclamationRepo.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(Long idr) {
        return reclamationRepo.findById(idr).orElse(null);
    }

    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepo.findAll();
    }

    @Override
    public Reclamation updateReclamation(Long idR, Reclamation reclamation) {
        Optional<Reclamation> optionalExistingReclamation = reclamationRepo.findById(idR);
        if (optionalExistingReclamation.isPresent()) {
            Reclamation existingReclamation = optionalExistingReclamation.get();

            // Update the fields if they are present in the reclamation parameter
            if (reclamation.getDescription() != null) {
                existingReclamation.setDescription(reclamation.getDescription());
            }
            if (reclamation.getDate() != null) {
                existingReclamation.setDate(reclamation.getDate());
            }
            if (reclamation.getSubject() != null) {
                existingReclamation.setSubject(reclamation.getSubject());
            }
            if (reclamation.getStatus() != null) {
                existingReclamation.setStatus(reclamation.getStatus());
            }

            try {
                return reclamationRepo.save(existingReclamation);
            } catch (Exception e) {
                // Handle the exception appropriately (e.g., log the error, throw a custom exception, etc.)
                throw new RuntimeException("Failed to update reclamation", e);
            }
        } else {
            // Return an appropriate response or throw a custom exception indicating that the ID doesn't exist
            return null;
        }
    }
    @Override
    public void deleteReclamation(Long idr) {
        reclamationRepo.deleteById(idr);

    }
}
