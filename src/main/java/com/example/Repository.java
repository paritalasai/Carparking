package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Country;



public interface Repository extends JpaRepository<Country, Integer>{

	//@RestResource
		List<Country> findByCountryName(String countryName);
		 @Query(value="SELECT c.countryName FROM Country c where c.countryName like '%a'")
		List<Country> findByCountryNames();
	   @Query(value="SELECT c.countryName,c.population FROM Country c where id%2=0")
	    List<Country> findByid();
	   @Query(value="SELECT c.countryName,c.population FROM Country c where population=max(population)")
	   List<Country> findBypopulation();
	List<Country> findByid(Integer id); 
	List<Country> findByCountryNameLike(String countryname);
}
