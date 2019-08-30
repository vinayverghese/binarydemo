package com.binary.aircraft.service;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.repository.AircraftRepository;
import com.binary.aircraft.request.EnqueueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class AircraftDataAccessorService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public void save(List<AircraftModel> aircraftModelList)
    {
        aircraftRepository.save(aircraftModelList);
    }
}

