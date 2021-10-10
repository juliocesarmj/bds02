package com.devsuperior.bds02.repositories.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.bds02.entities.City;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {

}
