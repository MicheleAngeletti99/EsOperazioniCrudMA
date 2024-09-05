package com.example.esoperazionicrud.controllers;

import com.example.esoperazionicrud.entities.Car;
import com.example.esoperazionicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    // metodo post
    @PostMapping("/new")
    public ResponseEntity<Car> insertCar(@RequestBody Car newCar) {
        return ResponseEntity.ok(carService.insertCar(newCar));
    }

    // metodo get all
    @GetMapping("/readAll")
    public ResponseEntity<List<Car>> selectAllCars() {
        return ResponseEntity.ok(carService.selectAllCars());
    }

    // metodo get one
    @GetMapping("/read/{id}")
    public ResponseEntity<Car> selectCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.selectCarById(id));
    }

    // metodo put car
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car newCar, @PathVariable Long id) {
        return ResponseEntity.ok(carService.updateCar(newCar, id));
    }

    // metodo put type
    @PutMapping("/updateType/{id}")
    public ResponseEntity<Car> updateType(@RequestParam String type, @PathVariable Long id) {
        return ResponseEntity.ok(carService.updateType(type, id));
    }

    // metodo delete one
    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        boolean deleteCheck = carService.deleteCarById(id);
        if (deleteCheck){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }

    // metodo delete all
    @DeleteMapping("/deleteAll")
    public void deleteAllCars() {
        carService.deleteAllCars();
    }
}
