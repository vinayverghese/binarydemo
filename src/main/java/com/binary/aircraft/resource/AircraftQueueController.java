package com.binary.aircraft.resource;

import java.util.List;
import java.util.Optional;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.request.QueueRequest;
import org.springframework.web.bind.annotation.*;


import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.PathParam;

@RestController
public class AircraftQueueController {

    @Autowired
    private AircraftService aircraftService;

    @RequestMapping(value = "/enqueue", method = RequestMethod.POST)
    public ResponseEntity<String> enqueueAircraft(@RequestBody List<EnqueueRequest> enqueueRequest) {
        return aircraftService.enqueueAircraft(enqueueRequest);
    }

    @RequestMapping(value = "/updatequeue", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAircraft(@RequestBody EnqueueRequest enqueueRequest) {
        return aircraftService.updateAircraft(enqueueRequest);
    }


    @RequestMapping(value = {"/dequeue", "/dequeue/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<List<AircraftModel>> dequeueAircraft(@PathVariable Optional<String> id) {
        return aircraftService.deqeueAircraft(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<AircraftModel>> listAircraftQueue(QueueRequest queueRequestList) {
        return aircraftService.listAircraftQueue(queueRequestList);
    }
}