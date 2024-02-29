package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repository.FlightRepository;
import com.example.airline_api.repository.PassengerRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight BritishAirways707 = new Flight("Hargeisa", 300,"0724","1600");
        flightRepository.save(BritishAirways707);
        Flight Emirates998 = new Flight("Dubai", 400,"0724","1600");
        flightRepository.save(Emirates998);
        Flight EasyJet67 = new Flight("Malaga", 100,"0724","1600");
        flightRepository.save(EasyJet67);

        Passenger zakaria = new Passenger("Zakaria Jama", "zakjama@gmail.com");
        zakaria.addFlights(BritishAirways707);
        passengerRepository.save(zakaria);

        Passenger bihi = new Passenger("Bihi Mohamed", "bihimohamed@gmail.com");
        bihi.addFlights(BritishAirways707);
        passengerRepository.save(bihi);

        Passenger ahmed = new Passenger("Ahmed Mohamed", "amoha@gmail.com");
        ahmed.addFlights(BritishAirways707);
        passengerRepository.save(ahmed);

        Passenger abdallah = new Passenger("Abdallah Ali", "abdallahali@gmail.com");
        abdallah.addFlights(Emirates998);
        passengerRepository.save(abdallah);
;    }

}
