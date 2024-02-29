package com.example.airline_api.service;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();

    }

    public Flight findFlight (Long id){
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void deleteFlight(Long id) { flightRepository.deleteById(id);}

}
