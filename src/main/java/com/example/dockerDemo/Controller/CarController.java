package com.example.dockerDemo.Controller;

import com.example.dockerDemo.Model.Car;
import com.example.dockerDemo.Repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(maxAge = 3600)

@RequestMapping(value = "api/v1/cars")
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("/brand/all")
    public List<Car> getAll (){
        return  carRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Car getById (@PathVariable long id){
        return  carRepository.findById(id).get();
    }

    @GetMapping(value = "/brand/{brand}")
    public List<Car> getBybrand (@PathVariable String brand){
        return  carRepository.findByBrand(brand);
    }

    @GetMapping(value = "/garage/{garage_id}")
    public List<Car> getByDeptId (@PathVariable int dept_id){
        return  carRepository.findByGarageId(dept_id);
    }

    @PostMapping()
    public long addCar(@RequestBody Car C){
        return carRepository.save(C).getId_car();
    }

    @PutMapping(value = "/{id}")
    public Car modifyCar(@PathVariable long id,@RequestBody Car C)
    {
        Car updatedC = carRepository.findById(id).get();
        updatedC.setBrand(C.getBrand());
        updatedC.setModel(C.getModel());
        updatedC.setYear(C.getYear());

        return carRepository.save(updatedC);
    }

    @DeleteMapping(value = "/{id}")
    public Car deleteCar(@PathVariable long id){
        Car deletedC = carRepository.findById(id).get();
        carRepository.delete(deletedC);
        return deletedC;
    }
}
