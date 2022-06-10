package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.ru.astanina.barbershop.entities.Serv_App;
import vsu.ru.astanina.barbershop.repositories.ServAppRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ServAppService {
    ServAppRepo repo;

    @Autowired
    public ServAppService(ServAppRepo repo) {
        this.repo = repo;
    }


    public Serv_App create(Serv_App master_app){
        repo.save(master_app);
        return master_app;
    }

    public List<Serv_App> findAll(){
        List<Serv_App> list = null;
        list = repo.findAll();
        if (list != null){
        }
        return list;
    }

    public Serv_App findById(int id){
        Optional<Serv_App> master_app = repo.findById(id);
        if (master_app.isPresent()){
            return master_app.get();
        }
        return null;
    }

    public Serv_App update(Serv_App serv_app){
        repo.save(serv_app);
        return serv_app;
    }


    public void deleteById(int id){
        repo.deleteById(id);
    }
}
