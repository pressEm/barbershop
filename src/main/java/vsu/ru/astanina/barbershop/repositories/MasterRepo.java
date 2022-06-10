package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.ClientEntity;
import vsu.ru.astanina.barbershop.entities.MasterEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepo  extends JpaRepository<MasterEntity, Integer> {
    Optional<MasterEntity> findById(int id);

    List<MasterEntity> findAll();
}
