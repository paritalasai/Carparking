package com.example.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.ParkingDetails;

@Service
public class Parkservice {
	@Autowired
ParkRepository parkrepo;
public void save(ParkingDetails park){
	parkrepo.save(park);
}

public List<ParkingDetails> get(String owner)
{
	//return parkrepo.findOne((long) owner);
	return  parkrepo.findBycarowner(owner);
}
public long count(){
	return parkrepo.count(); 
	
}
}
