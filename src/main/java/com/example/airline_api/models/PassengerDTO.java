package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

public class PassengerDTO {

    private String name;

    private String email;

    private List<Long> flightId;


    public PassengerDTO(String name, String email, List<Long> flightId){
        this.name = name;
        this.email = email;
        this.flightId= flightId;
    }

    public PassengerDTO(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getFlightId() {
        return flightId;
    }

    public void setFlightId(List<Long> flightId) {
        this.flightId = flightId;
    }
}
