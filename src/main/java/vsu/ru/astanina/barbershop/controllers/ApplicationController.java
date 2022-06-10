package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.ApplicationEntity;
import vsu.ru.astanina.barbershop.services.ApplicationService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/apps")
public class ApplicationController {
    ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping()
    ResponseEntity<List<ApplicationEntity>> findAll() {
        final  List<ApplicationEntity> cars = new ArrayList<>();
        applicationService.findAll().forEach(request -> {
            cars.add(request);
        });
        System.out.println(cars.size());
        System.out.println(cars.get(0).toString());
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<ApplicationEntity> add(@RequestBody ApplicationEntity app) {
        return new ResponseEntity<>(applicationService.create(app),HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<ApplicationEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        ApplicationEntity app = applicationService.findById(id);
        System.out.println(app);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        applicationService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<ApplicationEntity> update(@RequestBody ApplicationEntity app){
        return new ResponseEntity<>(applicationService.update(app),HttpStatus.OK);
    }

}
