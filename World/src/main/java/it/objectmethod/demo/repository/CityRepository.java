package it.objectmethod.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.demo.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	//Voglio un conflitto
	public List<City> findByNameStartingWithOrderByNameAsc(String name);
	public List<City> findCityByCodeOrderByNameAsc(String code);
	public List<City> findCityByCode(String code);
}
