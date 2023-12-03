package com.esprit.microservice.projet_microservice.ServiceImp;

import com.esprit.microservice.projet_microservice.Repository.ServiceRepository;
import com.esprit.microservice.projet_microservice.entite.ServiceE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.List;

@Service
public class ServiceServiceImp {
    @Autowired

    private ServiceRepository serviceRepository;
    public ServiceE addService(ServiceE S){
       return serviceRepository.save(S);
    }

    public ServiceE updateService(long idService, ServiceE newService) {

        if (serviceRepository.findById(idService).isPresent()) {
            ServiceE existingService = serviceRepository.findById(idService).get();
            if (newService.getTitle() != null){
                existingService.setTitle(newService.getTitle());
            }
            if (newService.getDescription() != null){
                existingService.setDescription(newService.getDescription());}
            if (newService.getTarif() != 0){
                existingService.setTarif(newService.getTarif());}
            if (newService.getDure()!= 0){
                existingService.setDure(newService.getDure());}
            if (newService.getImage() != null){
                existingService.setImage(newService.getImage());}
            return serviceRepository.save(existingService);
        } else
            return null;
    }
    public String deleteService(long idService) {
        if (serviceRepository.findById(idService).isPresent()) {
            serviceRepository.deleteById(idService);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
    public List<ServiceE> getAllServices(){
        return serviceRepository.findAll();
    }

    public ServiceE getServiceById(Long idService) {
        return serviceRepository.findById(idService).orElse(null);
    }

}
