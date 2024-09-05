package com.example.esoperazionicrud.services;

import com.example.esoperazionicrud.entities.Car;
import com.example.esoperazionicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    // metodo insert
    public Car insertCar(Car newCar) {
        return carRepository.saveAndFlush(newCar);
    }

    // metodo select all
    public List<Car> selectAllCars() {
        return carRepository.findAll();
    }

    // metodo select by id
    public Car selectCarById(Long id) {
        boolean checkCar = carRepository.existsById(id);
        if (checkCar) {
            return carRepository.findById(id).get();
            // per prendere il valore di un optional si usa il metodo get()
        } else {
            return new Car();
        }
    }

    // metodo update car
    public Car updateCar(Car car, Long id) {
        boolean checkCar = carRepository.existsById(id);
        if (checkCar) {
            Car existingCar = carRepository.findById(id).get();
            existingCar.setModelName(car.getModelName());
            existingCar.setType(car.getType());
            return carRepository.save(existingCar);
        } else {
            return new Car();
        }
    }

    // metodo update type
    public Car updateType(String type, Long id) {
        boolean checkCar = carRepository.existsById(id);
        if (checkCar) {
            Car existingCar = carRepository.findById(id).get();
            existingCar.setType(type);
            return carRepository.save(existingCar);
        } else {
            return new Car();
        }
    }

    // metodo delete one
    public boolean deleteCarById(Long id) {
        boolean checkCar = carRepository.existsById(id);
        if (checkCar) {
            carRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // metodo delete all
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

}
