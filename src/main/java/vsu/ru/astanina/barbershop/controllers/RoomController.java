package vsu.ru.astanina.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.ru.astanina.barbershop.entities.RoomEntity;
import vsu.ru.astanina.barbershop.services.RoomService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    ResponseEntity<List<RoomEntity>> findAll() {
        final  List<RoomEntity> roomEntityList = new ArrayList<>();
        roomService.findAll().forEach(room -> {
            roomEntityList.add(room);
        });
        return new ResponseEntity<>(roomEntityList, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<RoomEntity> add(@RequestBody RoomEntity room) {
        return new ResponseEntity<>(roomService.create(room),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<RoomEntity> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        RoomEntity room = roomService.findById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        roomService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<RoomEntity> update(@RequestBody RoomEntity room){
        return new ResponseEntity<>(roomService.update(room),HttpStatus.OK);
    }
}

