package com.binary.aircraft.service;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.repository.AircraftRepository;
import com.binary.aircraft.request.EnqueueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
@Transactional
public class AircraftDataAccessorService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public void save(List<AircraftModel> aircraftModelList)
    {
        aircraftRepository.saveAll(aircraftModelList);

    }
    public List<AircraftModel> allAircrafts()
    {
        return aircraftRepository.findAll();
    }
}