package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.Master_App;
import vsu.ru.astanina.barbershop.services.MastAppService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mastapp")
public class MastAppController {
    MastAppService mastAppService;

    @Autowired
    public MastAppController(MastAppService mastAppService) {
        this.mastAppService = mastAppService;
    }

    @GetMapping()
    ResponseEntity<List<Master_App>> findAll() {
        final  List<Master_App> master_apps = new ArrayList<>();
        mastAppService.findAll().forEach(master_app -> {
            master_apps.add(master_app);
        });
        return new ResponseEntity<>(master_apps, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Master_App> add(@RequestBody Master_App masterApp) {
        return new ResponseEntity<>(mastAppService.create(masterApp),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Master_App> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Master_App masterApp = mastAppService.findById(id);
        return new ResponseEntity<>(masterApp, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        mastAppService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Master_App> update(@RequestBody Master_App masterApp){
        return new ResponseEntity<>(mastAppService.update(masterApp),HttpStatus.OK);
    }
}
