package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Country;

import io.swagger.annotations.Api;



@RestController
@Api(value="CONTROLLER")
@RequestMapping("/micro")
public class CountryController {
@Autowired
	Repository quer;
	CountryService countryService = new CountryService();

	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);

	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);

	}	
@RequestMapping(value = "/savecountry", method = RequestMethod.POST, headers = "Accept=application/json") 
	public List<Country> save(@RequestBody List<Country> country)
	{
		return quer.save(country); 
	}
/*@RequestMapping(value = "/country", method = RequestMethod.GET, headers = "Accept=application/json") 
public List<Country> getCountry() 
{ 
	List<Country> l=new ArrayList<Country>();
	List<Country> listOfCountries = rep.findAll();
	for(int i=1;i<=listOfCountries.size();i++)
	{
	if(i%3==0)	
	{
       Country coun= rep.findOne(i);
       l.add(coun);
	}
	}
	return l;
	}
@GET
@Path("/")
public String html(){
	return "index.html"; 
	
}*/
/*@GET
@Path("/{countryName}")
@Produces(MediaType.APPLICATION_JSON)*/
@RequestMapping(value = "/countryname/{countryname}", method = RequestMethod.GET, headers = "Accept=application/json")
public Iterable<Country> countrybyName(@PathVariable(value="countryname") String countryName){
	return quer.findByCountryName(countryName);
}
@RequestMapping(value = "/countr/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
public List<Country> countr(@PathVariable(value="id") Integer id){ 
	return quer.findByid(id);
}
@RequestMapping(value = "/countrpop", method = RequestMethod.GET, headers = "Accept=application/json")
public List<Country> country(){ 
	return quer.findBypopulation();
}
@RequestMapping(value = "/countrpop/{i}", method = RequestMethod.GET, headers = "Accept=application/json")
public List<Country> countryNmeIgnor(@PathVariable(value="i")String contry){ 
	return quer.findByCountryNameLike('%'+contry+'%');
			}
}
