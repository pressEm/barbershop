package vsu.ru.astanina.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vsu.ru.astanina.barbershop.entities.ApplicationEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface ApplicationRepo extends JpaRepository<ApplicationEntity, Integer> {
    Optional<ApplicationEntity> findById(int id);

//    @Query(value = "SELECT c FROM application c")
    List<ApplicationEntity> findAll();
}
