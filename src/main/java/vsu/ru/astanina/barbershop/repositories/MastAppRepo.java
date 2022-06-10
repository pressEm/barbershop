package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.ClientEntity;
import vsu.ru.astanina.barbershop.entities.Master_App;

import java.util.List;
import java.util.Optional;

@Repository
public interface MastAppRepo extends JpaRepository<Master_App, Integer> {
    Optional<Master_App> findById(int id);

    List<Master_App> findAll();
}