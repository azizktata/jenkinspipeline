package com.example.dockerDemo.Service;

import com.example.dockerDemo.Model.Car;
import com.example.dockerDemo.Repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;


}
