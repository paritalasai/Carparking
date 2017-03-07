package com.example.car;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Car;
import com.example.model.ParkingDetails;

import io.swagger.annotations.Api;

@RestController
@Api(value="CONTROLLER")
@RequestMapping("/car")
public class CarController {

	RestTemplate rs=new RestTemplate();
	Logger log=Logger.getLogger(CarController.class);
	
	@Autowired
	Service service;
	@Autowired
	Parkservice Parkservice;
	@RequestMapping(value="/save",method=RequestMethod.POST,headers="Accept=application/json")
	public void save(@RequestBody List<Car> car)
	{ 
		
		
		//System.out.println(car.get(1).getCarnumber()+"========");
		for(int i=0;i<car.size();i++){
			car.get(i).setCheckin(new Date()); 
			long id=car.get(i).getCarnumber();
			//System.out.println("NUMNBER OF CARS IN PARKING======="+service.count());
			Car car1=service.getBycarnumber((int) id); 
			if(car1!=null){
			
				System.out.println(car.get(i).getCarnumber()+"====Number Car is already Existed"); 
			}
			else if(service.count()>=15){
				System.out.println("There is no SPace for the PARKING"); 
				i=i+1;
			}
			else{
				service.saved(car.get(i));
			}
		}
		//service.save(car); 
		
	}
	@RequestMapping(value="/saved",method=RequestMethod.POST,headers="Accept=application/json") 
	public void saved(@RequestBody Car car)
	{
		car.setCheckin(new Date()); 
		long id=car.getCarnumber();
		Car car1=service.getBycarnumber((int) id);
		if(car1!=null){
		
			System.out.println("Car already Existed"); 
		}
		else if(service.count()>=15){
			System.out.println("There is no SPace for the PARKING"); ; 
		}
		else{
			service.saved(car);
		}
	}
	@RequestMapping(value="/retrieve/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public Car get(@PathVariable("id") int id)
	{ 
		Date time=null;
		Car car=null;
		try{
	    car=service.get(id);
		 
		if(car!=null){
			time=car.getCheckin();
		timeconversion(time,car); 
		ParkingDetails park=new ParkingDetails(); 
		park.setCarnumber(car.getCarnumber());
		park.setCarowner(car.getOwner()); 
		park.setCheckintime(car.getCheckin()); 
		park.setCheckouttime(new Date()); 
		park.setTimeofparking(car.getParkingtime());
		park.setPriceofparking(car.getPrice()); 
		Parkservice.save(park); 
		service.delete(car); 
		}
		else{ 
			System.out.println("CAR DOES not EXist"); 
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return timeconversion(time,car);
	}	
	
	private Car timeconversion(Date time,Car car){
		
	 car.setCheckout(new Date()); 
	Date d=car.getCheckout();
	System.out.println("Car check out date========="+d);
	Car hours=timedifference(d,time,car);
	return hours;
	
	}
	private Car timedifference(Date d,Date time,Car car){

		long diff = d.getTime() - time.getTime();// as given
		long hours = TimeUnit.MILLISECONDS.toHours(diff);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
		long day = hours/24;
		long hour = hours%24;
		
		if(day!=0&&hours!=0&&minutes!=0){
			String i=day+"::"+hour+"::"+minutes%hours+"::"+seconds%minutes;
			float f=(float) ((day*2400)+(hour*100)+(minutes%hours*1.66)+(seconds%minutes*0.02));
			car.setParkingtime(i);
			car.setPrice(f);
			return car; 
		}
		else if(day!=0&&hour==0&&minutes!=0)
		{
			String i=day+"::"+hour+"::"+minutes%hours+"::"+seconds%minutes;
			float f=(float) ((day*2400)+(hour*100)+(minutes%hours*1.66)+(seconds%minutes*0.02));
			car.setParkingtime(i);
			car.setPrice(f);
			return car; 
		}
		else if(day==0&&hour!=0&&minutes!=0)
		{
			String i=day+"::"+hour+"::"+minutes%hours+"::"+seconds%minutes;
			float f=(float) (hour*100+minutes%hours*1.66+seconds%minutes*0.02);
			car.setParkingtime(i);
			car.setPrice(f);
			return car; 
		}
		else if(hours==0&&minutes!=0)
		{
			
			String i=day+"::"+hour+"::"+minutes+"::"+seconds%minutes;
			float f=(float) (minutes*1.66+seconds%minutes*0.02);
			car.setParkingtime(i);
			car.setPrice(f);
			return car; 
		 
		}
		else{
			String i=day+"::"+hour+"::"+minutes+"::"+seconds;
			float f=(float) (minutes*1.66+seconds%minutes*0.02);
			car.setParkingtime(i);
			car.setPrice(f);
			return car; 
		}
			
	}
} 

