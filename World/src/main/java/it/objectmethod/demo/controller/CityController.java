package it.objectmethod.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.demo.entity.City;
import it.objectmethod.demo.entity.Country;
import it.objectmethod.demo.repository.CityRepository;
import it.objectmethod.demo.repository.CountryRepository;

@Controller
public class CityController {

	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@RequestMapping("/cities/list")
	public String citiesList(@RequestParam("country_code") String countryCode, ModelMap map,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<City> list =cityRepo.findCityByCode(countryCode);
		if(countryCode == null) {
			countryCode = (String) session.getAttribute("country_code");
		} else {
			session.setAttribute("country_code", countryCode); 
		}
		map.addAttribute("lista_cities", list);
		map.addAttribute("countryCode", countryCode);
		return "city-list";
	}

	@RequestMapping("cities/delete") 
	public String deleteCity(@RequestParam("idCity") long idCity,
			@RequestParam("countryCode") String code, ModelMap map) {
		City city =cityRepo.findById(idCity);
		String resultMsg = "Errore nell'eliminare la city.";
		try {
			cityRepo.delete(city);
			resultMsg = "City eliminata con successo!";
		}catch(Exception e) {}
		map.addAttribute("delete_message", resultMsg);
		return "forward:/cities/list?country_code="+code;
	}

	@RequestMapping("cities/create-modify") 
	public String createOrModifyCity(@RequestParam("idCity") long idCity,
			@RequestParam("countryCode") String code, ModelMap map,Model model,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Country> listCountries = countryRepo.findAll();
		Country country = countryRepo.findCountryByCode(code);
		City city = null;
		if(idCity!=0) {
			city= cityRepo.findById(idCity);
			session.setAttribute("city", city);
		}
		else {
			city = new City();
			city.setId((long) 0);
		}
		map.addAttribute("city", city);
		map.addAttribute("paese", country.getCode());
		map.addAttribute("lista_Countriees", listCountries);
		return "create-modify-city";
	}

	@RequestMapping("/cities/insert_modify")
	public String insertOrUpdateCity (@RequestParam("city_name") String name,
			@RequestParam("district_name") String district,
			@RequestParam("population") int population,
			@RequestParam("theCountries") String countryCode, @RequestParam("city_id")
	long idCity,ModelMap map) {
		City city = new City();
		city.setName(name);
		city.setCode(countryCode);
		city.setPopulation(population);
		city.setDistrict(district);
		city.setId(idCity);
		if(city.getId() ==0	) {										
			map.addAttribute("message", "Creazione avvenuta con successo!");
		}
		else if(city.getId()!=0){
			map.addAttribute("message", "Modifica avvenuta con successo!");
		}
		cityRepo.save(city);
		return "create-modify-city";
	}

	@RequestMapping("/cities/search")
	public String searchCity(@RequestParam("city_Name") String name, ModelMap map,
			HttpServletRequest req) {
		List<City> list = cityRepo.findByNameStartingWith(name);
		map.addAttribute("lista_cities", list);
		HttpSession session = req.getSession();
		session.removeAttribute("continent");
		return "city-list";
	}
}
