package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.Master_App;
import vsu.ru.astanina.barbershop.entities.Serv_App;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServAppRepo extends JpaRepository<Serv_App, Integer> {
    Optional<Serv_App> findById(int id);

    List<Serv_App> findAll();
}