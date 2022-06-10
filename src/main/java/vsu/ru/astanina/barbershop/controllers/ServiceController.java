package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.ServiceEntity;
import vsu.ru.astanina.barbershop.services.ServiceService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    ServiceService service;

    @Autowired
    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping()
    ResponseEntity<List<ServiceEntity>> findAll() {
        final  List<ServiceEntity> serviceEntities = new ArrayList<>();
        service.findAll().forEach(service -> {
            serviceEntities.add(service);
        });
        return new ResponseEntity<>(serviceEntities, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<ServiceEntity> add(@RequestBody ServiceEntity service) {
        return new ResponseEntity<>(this.service.create(service),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<ServiceEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        ServiceEntity service = this.service.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping
    ResponseEntity<ServiceEntity> update(@RequestBody ServiceEntity service){
        return new ResponseEntity<>(this.service.update(service),HttpStatus.OK);
    }
}

