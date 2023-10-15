package com.example.dockerDemo.Repository;

import com.example.dockerDemo.Model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GarageRepository extends JpaRepository<Garage,Long> {
}
