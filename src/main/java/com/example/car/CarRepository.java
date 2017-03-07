package com.example.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Car;
public interface CarRepository extends JpaRepository<Car, Integer> { 

	Car findBycarnumber(long carnumber);
	 @Query("select count(*) from Car") 
	 long count();
}
