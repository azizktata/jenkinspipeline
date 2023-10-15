package com.example.dockerDemo.Repository;

import com.example.dockerDemo.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Map;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car,Long> {
    @RestResource(path = "/getCarsByG")
    @Query("SELECT e FROM Car e where e.garage.id_garage = :x")
    List<Car> findByGarageId(@Param("x") int x);

    @Query("SELECT c FROM Car c where c.brand = :x")
    List<Car> findByBrand(@Param("x") String x);
}
