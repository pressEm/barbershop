package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.ru.astanina.barbershop.entities.MasterEntity;
import vsu.ru.astanina.barbershop.repositories.MasterRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MasterService {
    MasterRepo masterRepo;

    @Autowired
    public MasterService(MasterRepo masterRepo) {
        this.masterRepo = masterRepo;
    }


    public MasterEntity create(MasterEntity master){
        masterRepo.save(master);
        return master;
    }

    public List<MasterEntity> findAll(){
        List<MasterEntity> masters = null;
        masters = masterRepo.findAll();
//        if (masters != null){
//        }
        return masters;
    }

    public MasterEntity findById(int id){
        Optional<MasterEntity> master = masterRepo.findById(id);
        if (master.isPresent()){
            return master.get();
        }
        return null;
    }

    public MasterEntity update(MasterEntity client){
        masterRepo.save(client);
        return client;
    }


    public void deleteById(int id){
        masterRepo.deleteById(id);
    }

}
