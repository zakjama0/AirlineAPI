package com.example.airline_api.service;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repository.FlightRepository;
import com.example.airline_api.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassengerService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengerss(){
        return passengerRepository.findAll();
    }

    public Passenger findPassenger (Long id){
        return passengerRepository.findById(id).get();
    }

    public Passenger savePassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());
        for(Long flightId: passengerDTO.getFlightId() ){
            Flight flight =flightRepository.findById(flightId).get();
            passenger.addFlights(flight);
        }
        return passengerRepository.save(passenger);
    }



}
