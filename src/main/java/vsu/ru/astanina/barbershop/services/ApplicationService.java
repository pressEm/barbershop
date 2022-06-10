package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.ru.astanina.barbershop.entities.ApplicationEntity;
import vsu.ru.astanina.barbershop.repositories.ApplicationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    ApplicationRepo applicationRepo;

@Autowired
    public ApplicationService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }


    public ApplicationEntity create(ApplicationEntity app){
        applicationRepo.save(app);
        return app;
    }

    public List<ApplicationEntity> findAll(){
        List<ApplicationEntity> apps = null;
        apps = applicationRepo.findAll();
        if (apps != null){
        }
        return apps;
    }

    public ApplicationEntity findById(int id){
        Optional<ApplicationEntity> app = applicationRepo.findById(id);
        if (app.isPresent()){
            return app.get();
        }
        return null;
    }

    public ApplicationEntity update(ApplicationEntity app){
        applicationRepo.save(app);
        return app;
    }


    public void deleteById(int id){
        applicationRepo.deleteById(id);
    }
}
