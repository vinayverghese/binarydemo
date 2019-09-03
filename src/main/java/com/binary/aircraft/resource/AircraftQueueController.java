package com.binary.aircraft.resource;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.request.QueueRequest;
import com.binary.aircraft.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AircraftQueueController {

    @Autowired
    private AircraftService aircraftService;


    @RequestMapping(value = "/updatequeue", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAircraft(@RequestBody EnqueueRequest enqueueRequest) {
        return aircraftService.updateAircraft(enqueueRequest);
    }


    @RequestMapping(value = {"/dequeue", "/dequeue/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<List<AircraftModel>> dequeueAircraft(@PathVariable Optional<String> id) {
        return aircraftService.dequeueAircraft(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<AircraftModel>> listAircraftQueue(QueueRequest queueRequestList) {
        return aircraftService.listAircraftQueue(queueRequestList);
    }
}