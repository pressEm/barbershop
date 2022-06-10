package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.Serv_App;
import vsu.ru.astanina.barbershop.services.ServAppService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servapp")
public class ServAppController {
    ServAppService servAppService;

    @Autowired
    public ServAppController(ServAppService servAppService) {
        this.servAppService = servAppService;
    }

    @GetMapping()
    ResponseEntity<List<Serv_App>> findAll() {
        final  List<Serv_App> list = new ArrayList<>();
        servAppService.findAll().forEach(entity -> {
            list.add(entity);
        });
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Serv_App> add(@RequestBody Serv_App masterApp) {
        return new ResponseEntity<>(servAppService.create(masterApp),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Serv_App> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Serv_App entity = servAppService.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        servAppService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Serv_App> update(@RequestBody Serv_App entity){
        return new ResponseEntity<>(servAppService.update(entity),HttpStatus.OK);
    }
}
