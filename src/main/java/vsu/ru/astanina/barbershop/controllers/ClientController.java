package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.ClientEntity;
import vsu.ru.astanina.barbershop.services.ClientService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    ResponseEntity<List<ClientEntity>> findAll() {
        final  List<ClientEntity> clients = new ArrayList<>();
        clientService.findAll().forEach(request -> {
            clients.add(request);
        });
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<ClientEntity> add(@RequestBody ClientEntity client) {
        return new ResponseEntity<>(clientService.create(client),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<ClientEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        ClientEntity client = clientService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        clientService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<ClientEntity> update(@RequestBody ClientEntity client){
        return new ResponseEntity<>(clientService.update(client),HttpStatus.OK);
    }
}
