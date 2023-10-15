package com.example.dockerDemo.Controller;

import com.example.dockerDemo.Model.Car;
import com.example.dockerDemo.Model.Garage;
import com.example.dockerDemo.Repository.CarRepository;
import com.example.dockerDemo.Repository.GarageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/garage")
public class GarageController {

    private final GarageRepository garageRepository;
    private final CarRepository carRepository;

    @GetMapping()
    public List<Garage> getAll (){
        return  garageRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Garage getById (@PathVariable long id){
        return  garageRepository.findById(id).get();
    }

    @GetMapping(value = "/cars")
    public List<Car> getGarageCars(@PathVariable long garageId){
        Garage garage =garageRepository.findById(garageId).get();
        return garage.getCars();
    }

    @PostMapping()
    public long addGarage(@RequestBody Garage G){
        return garageRepository.save(G).getId_garage();
    }

    @PostMapping("/{id}/car/{idCar}")
    public long addCarToGarage(@PathVariable long id,@PathVariable long idCar){
        Garage garage = garageRepository.findById(id).get();
        Car C = carRepository.findById(idCar).get();
        C.setGarage(garage);
        return garageRepository.save(garage).getId_garage();
    }

    @DeleteMapping(value = "/{id}")
    public Garage deleteGarage(@PathVariable long id){
        Garage deletedG = garageRepository.findById(id).get();
        garageRepository.delete(deletedG);
        return deletedG;
    }
}
