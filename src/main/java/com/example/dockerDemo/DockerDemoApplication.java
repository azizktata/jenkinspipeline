package com.example.dockerDemo;

import com.example.dockerDemo.Model.Car;
import com.example.dockerDemo.Repository.CarRepository;
import com.example.dockerDemo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DockerDemoApplication implements CommandLineRunner {
	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Car car1 = new Car("Mercedes","C", 2020);
		Car car2 = new Car("Mazda","S100", 2021);
		Car car3 = new Car("Kia","S45", 2017);
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
	}
}
