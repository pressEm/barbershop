package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.MasterEntity;
import vsu.ru.astanina.barbershop.services.MasterService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/masters")
public class MasterController {
    MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping()
    ResponseEntity<List<MasterEntity>> findAll() {
        final  List<MasterEntity> masterEntityList = new ArrayList<>();
        masterService.findAll().forEach(master -> {
            masterEntityList.add(master);
        });
        return new ResponseEntity<>(masterEntityList, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<MasterEntity> add(@RequestBody MasterEntity client) {
        return new ResponseEntity<>(masterService.create(client),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<MasterEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        MasterEntity client = masterService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        masterService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<MasterEntity> update(@RequestBody MasterEntity master){
        return new ResponseEntity<>(masterService.update(master),HttpStatus.OK);
    }
}
