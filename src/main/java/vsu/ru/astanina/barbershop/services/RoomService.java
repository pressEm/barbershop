package vsu.ru.astanina.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.ru.astanina.barbershop.entities.RoomEntity;
import vsu.ru.astanina.barbershop.repositories.RoomRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }


    public RoomEntity create(RoomEntity master){
        roomRepo.save(master);
        return master;
    }

    public List<RoomEntity> findAll(){
        List<RoomEntity> masters = null;
        masters = roomRepo.findAll();
//        if (masters != null){
//        }
        return masters;
    }

    public RoomEntity findById(int id){
        Optional<RoomEntity> master = roomRepo.findById(id);
        if (master.isPresent()){
            return master.get();
        }
        return null;
    }

    public RoomEntity update(RoomEntity client){
        roomRepo.save(client);
        return client;
    }


    public void deleteById(int id){
        roomRepo.deleteById(id);
    }

}
