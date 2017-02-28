package com.example.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Car;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
CarRepository carrepo;
public void save(List<Car> car)
{
	carrepo.save(car);

}
public void saved(Car car)
{
	carrepo.save(car);
}
public Car get(int id){
	return carrepo.findOne(id);  
	
}
public Car getBycarnumber(int id){
	return carrepo.findBycarnumber(id);  
	
}
public void delete(Car c)
{
carrepo.delete(c);
}
public long count(){
	return carrepo.count(); 
	
}


}
