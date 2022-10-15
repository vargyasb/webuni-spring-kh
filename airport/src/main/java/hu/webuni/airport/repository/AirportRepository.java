package hu.webuni.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.webuni.airport.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{
	
	Long countByIata(String iata);
	
	Long countByIataAndIdNot(String iata, long id);
	
	//A Opcio
	//@Query("SELECT a FROM Airport a LEFT JOIN FETCH a.address")
	//List<Airport> findAllWithAddress();
	
	//B Opcio
	@EntityGraph(attributePaths = {"address", "departures"/*, "arrivals"*/}/*, type = EntityGraphType.LOAD*/)
	@Query("SELECT a from Airport a")
	List<Airport> findAllWithAddressAndDepartures();
	
	@EntityGraph(attributePaths = {"arrivals"})
	@Query("SELECT a FROM Airport a")
	List<Airport> findAllWithArrivals();
}
