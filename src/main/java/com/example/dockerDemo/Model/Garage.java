package com.example.dockerDemo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_garage;
    private String name;
    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "garage-cars")
    private List<Car> cars;

    public Garage(String name) {
        this.name = name;
    }

    public void addCar(Car car){
        cars.add(car);
    }
    public void removeCar(Car car){
        this.cars.remove(car);
    }
}
