package hu.webuni.airport.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import hu.webuni.airport.dto.FlightDto;
import hu.webuni.airport.mapper.FlightMapper;
import hu.webuni.airport.model.Flight;
import hu.webuni.airport.repository.FlightRepository;
import hu.webuni.airport.service.FlightService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flights")
public class FlightController {

	private final FlightService flightService;
	private final FlightRepository flightRepository;
	private final FlightMapper flightMapper;
	
	
	@PostMapping
	public FlightDto createFlight(@RequestBody @Valid FlightDto flightDto) {
		Flight flight = flightService.save(flightMapper.dtoToFlight(flightDto));
		return flightMapper.flightToDto(flight);
	}
	
	@PostMapping("/search")
	public List<FlightDto> searchFlights(@RequestBody FlightDto example){
		return flightMapper.flightsToDtos(flightService.findFlightsByExample(flightMapper.dtoToFlight(example)));
	}
	
	@GetMapping("/search")
	public List<FlightDto> searchFlights2(@QuerydslPredicate(root = Flight.class) Predicate predicate){
		return flightMapper.flightsToDtos(flightRepository.findAll(predicate));
	}
}
