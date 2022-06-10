package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.ClientEntity;
import vsu.ru.astanina.barbershop.entities.MasterEntity;
import vsu.ru.astanina.barbershop.entities.RoomEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo  extends JpaRepository<RoomEntity, Integer> {
    Optional<RoomEntity> findById(int id);

    List<RoomEntity> findAll();
}
