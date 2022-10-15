package hu.webuni.airport.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import hu.webuni.airport.dto.AirportDto;
import hu.webuni.airport.dto.FlightDto;
import hu.webuni.airport.model.Airport;
import hu.webuni.airport.model.Flight;

@Mapper(componentModel = "spring")
public interface AirportMapper {

	List<AirportDto> airportsToDtos(List<Airport> airports);

	AirportDto airportToDto(Airport airport);

	Airport dtoToAirport(AirportDto airportDto);
	
	@Named("summary")
	@Mapping(target = "address", ignore = true)
	@Mapping(target = "departures", ignore = true)
	AirportDto airportSummaryToDto(Airport airport);
	
	@IterableMapping(qualifiedByName = "summary")
	List<AirportDto> airportSummariesToDtos(List<Airport> airports);
	
	@Mapping(target = "takeoff", ignore = true)
	@Mapping(target = "landing", ignore = true)
	FlightDto flightToDto(Flight flight);
}
