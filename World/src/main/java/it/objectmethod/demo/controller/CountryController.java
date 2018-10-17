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

import it.objectmethod.demo.entity.Country;
import it.objectmethod.demo.repository.CountryRepository;

@Controller
public class CountryController {

	@Autowired
	private CountryRepository countryRepo;
	
	@RequestMapping("/continents")
	public String getAllContinents(ModelMap map) {
		List<String> continentList = countryRepo.findAllContinents();
		map.addAttribute("listaContinenti", continentList);
		return "Continents";
	}

	@RequestMapping("/countries")
	public String countriesListByContinent (@RequestParam("continent") String continent, 
			ModelMap map,Model model, HttpServletRequest req) {
		List<Country> list = countryRepo.findCountryByContinent(continent);
		map.addAttribute("countries", list);
		HttpSession session = req.getSession();
		session.removeAttribute("country_code");
		session.setAttribute("continent", continent); 
		return "Countries";
	}
}
