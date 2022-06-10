package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.RoomEntity;
import vsu.ru.astanina.barbershop.entities.ServiceEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepo extends JpaRepository<ServiceEntity, Integer> {
    Optional<ServiceEntity> findById(int id);

    List<ServiceEntity> findAll();
}