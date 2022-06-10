package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import vsu.ru.astanina.barbershop.entities.ApplicationEntity;
import vsu.ru.astanina.barbershop.entities.ClientEntity;
import vsu.ru.astanina.barbershop.repositories.ClientRepo;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    public ClientEntity create(ClientEntity client){
        clientRepo.save(client);
        return client;
    }

    public List<ClientEntity> findAll(){
        List<ClientEntity> apps = null;
        apps = clientRepo.findAll();
        if (apps != null){
        }
        return apps;
    }

    public ClientEntity findById(int id){
        Optional<ClientEntity> client = clientRepo.findById(id);
        if (client.isPresent()){
            return client.get();
        }
        return null;
    }

    public ClientEntity update(ClientEntity client){
        clientRepo.save(client);
        return client;
    }


    public void deleteById(int id){
        clientRepo.deleteById(id);
    }
}
