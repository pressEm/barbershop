package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.ru.astanina.barbershop.entities.Master_App;
import vsu.ru.astanina.barbershop.repositories.MastAppRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MastAppService {
    MastAppRepo mastAppRepo;

    @Autowired
    public MastAppService(MastAppRepo mastAppRepo) {
        this.mastAppRepo = mastAppRepo;
    }


    public Master_App create(Master_App master_app){
        mastAppRepo.save(master_app);
        return master_app;
    }

    public List<Master_App> findAll(){
        List<Master_App> list = null;
        list = mastAppRepo.findAll();
        if (list != null){
        }
        return list;
    }

    public Master_App findById(int id){
        Optional<Master_App> master_app = mastAppRepo.findById(id);
        if (master_app.isPresent()){
            return master_app.get();
        }
        return null;
    }

    public Master_App update(Master_App master_app){
        mastAppRepo.save(master_app);
        return master_app;
    }


    public void deleteById(int id){
        mastAppRepo.deleteById(id);
    }
}
