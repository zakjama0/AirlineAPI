package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passengers")
public class PassengerController {


        @Autowired
    PassengerService passengerService;
    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.getAllPassengerss(), HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(Long id){
        return new ResponseEntity<>(passengerService.findPassenger(id), HttpStatus.OK);
    }

    // Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody PassengerDTO newPassenger) {
        Passenger passenger = passengerService.savePassenger(newPassenger);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }


}
