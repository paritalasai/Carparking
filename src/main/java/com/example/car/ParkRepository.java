package com.example.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.ParkingDetails;

public interface ParkRepository extends JpaRepository<ParkingDetails, Long>
{ 
 List<ParkingDetails> findBycarowner(String carowner);
 
 @Query("select count(*) from ParkingDetails") 
 long count();
}
