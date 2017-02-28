package com.example.car;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ParkingDetails;

import io.swagger.annotations.Api;

@RestController
@Api(value="CONTROLLER")
@RequestMapping("/park")
public class ParkingController {
	@Autowired
	Parkservice park;
	
	@RequestMapping(value="/get/{owner}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<ParkingDetails> get(@PathVariable("owner") String owner){
		System.out.println("dshcdcx");
		List<ParkingDetails> p= park.get(owner); 
		System.out.println(p.get(0).getCarowner()+"===="+p.get(0).getCheckintime()); 
		return p;
	}  
	
}
