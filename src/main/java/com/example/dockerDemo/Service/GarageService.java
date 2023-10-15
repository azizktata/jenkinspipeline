package com.example.dockerDemo.Service;

import com.example.dockerDemo.Model.Car;
import com.example.dockerDemo.Repository.CarRepository;
import com.example.dockerDemo.Repository.GarageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GarageService {

    private GarageRepository garageRepository;
    private CarRepository carRepository;

}
