package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.ApplicationEntity;
import vsu.ru.astanina.barbershop.entities.ClientEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepo extends JpaRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findById(int id);

    List<ClientEntity> findAll();
}
