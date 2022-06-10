package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.ru.astanina.barbershop.entities.ServiceEntity;
import vsu.ru.astanina.barbershop.repositories.ServiceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    ServiceRepo serviceRepo;

    @Autowired
    public ServiceService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }


    public ServiceEntity create(ServiceEntity service){
        serviceRepo.save(service);
        return service;
    }

    public List<ServiceEntity> findAll(){
        List<ServiceEntity> services = null;
        services = serviceRepo.findAll();
        return services;
    }

    public ServiceEntity findById(int id){
        Optional<ServiceEntity> service = serviceRepo.findById(id);
        if (service.isPresent()){
            return service.get();
        }
        return null;
    }

    public ServiceEntity update(ServiceEntity service){
        serviceRepo.save(service);
        return service;
    }


    public void deleteById(int id){
        serviceRepo.deleteById(id);
    }

}

