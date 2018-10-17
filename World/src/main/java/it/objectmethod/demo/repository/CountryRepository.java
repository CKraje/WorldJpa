package it.objectmethod.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.demo.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{

	@Query(value="SELECT  DISTINCT continent FROM Country")
	public List<String> findAllContinents();

	public List<Country> findCountryByContinent(String continent);

}
