package com.binary.aircraft.service;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.request.QueueRequest;
import com.binary.aircraft.values.QueueSize;
import com.binary.aircraft.values.QueueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AircraftService {

    @Autowired
    private AircraftDataAccessorService aircraftDataAccessorService;

    public ResponseEntity<String> enqueueAircraft(List<EnqueueRequest> enqueueRequestList) {

        if (enqueueRequestList != null && !enqueueRequestList.isEmpty()) {

            Integer size = enqueueRequestList.size();

            boolean isValidSizeAndType = enqueueRequestList.stream().allMatch(e -> QueueSize.contains(e.getEnqueueSize())
                    && QueueType.contains(e.getEnqueueType()));

            System.out.println("isValidSizeAndType : " + isValidSizeAndType);

            if (isValidSizeAndType) {
                List<AircraftModel> aircraftModelList = new ArrayList<>();
                for (EnqueueRequest e : enqueueRequestList) {

                    AircraftModel aircraftModel = new AircraftModel();
                    aircraftModel.setAircraftType(QueueType.getNameByAbbr(e.getEnqueueType()));
                    aircraftModel.setAircraftSize(QueueSize.getNameByAbbr(e.getEnqueueSize()));
                    aircraftModel.setAircraftStatus("A");
                    aircraftModelList.add(aircraftModel);
                }
                aircraftDataAccessorService.save(aircraftModelList);
            } else {
                return new ResponseEntity<>("Wrong input", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(size + " ACs added to Queue", HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<AircraftModel>> listAircraftQueue(QueueRequest queueRequest) {
        if (queueRequest != null) {
            return new ResponseEntity<List<AircraftModel>>(aircraftDataAccessorService.findAircraftsByAircraftIdOrQueueTypeOrQueueSize(queueRequest), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<AircraftModel>>(aircraftDataAccessorService.findAllAircraftsInQueue(), HttpStatus.OK);

        }

    }

    public ResponseEntity<String> updateAircraft(EnqueueRequest enqueueRequest) {

        List<AircraftModel> updatedAircraftModelList = new ArrayList<>();
        if (enqueueRequest.getPosition() != null) {
            //If position exists, find existing aircraft in that position
            //Update it to new position (+1)
            //Add new aircraft to that position

            Integer position = enqueueRequest.getPosition();
            AircraftModel updateOldAircraftModel = aircraftDataAccessorService.findAircraftsByPosition(enqueueRequest);
            if (updateOldAircraftModel != null) {
                updateOldAircraftModel.setAircraftPosition(updateOldAircraftModel.getAircraftPosition()+1);

                AircraftModel addNewAircraftModel = new AircraftModel();
                addNewAircraftModel.setAircraftType(QueueType.getNameByAbbr(enqueueRequest.getEnqueueType()));
                addNewAircraftModel.setAircraftSize(QueueSize.getNameByAbbr(enqueueRequest.getEnqueueSize()));
                addNewAircraftModel.setAircraftPosition(position);
                addNewAircraftModel.setAircraftStatus("A");
                updatedAircraftModelList.add(updateOldAircraftModel);
                updatedAircraftModelList.add(addNewAircraftModel);
            }
            else
            {

                return new ResponseEntity<>("Position Invalid", HttpStatus.BAD_REQUEST);
            }

        } else {
            //When no position is given, find the max. position in the queue and add it after that
            AircraftModel newAircraftModel = new AircraftModel();
            Integer maxPosition = aircraftDataAccessorService.findMaxAircraftPosition();
            maxPosition++;

            newAircraftModel.setAircraftType(QueueType.getNameByAbbr(enqueueRequest.getEnqueueType()));
            newAircraftModel.setAircraftSize(QueueSize.getNameByAbbr(enqueueRequest.getEnqueueSize()));
            newAircraftModel.setAircraftPosition(maxPosition);
            newAircraftModel.setAircraftStatus("A");
            updatedAircraftModelList.add(newAircraftModel);
        }

        aircraftDataAccessorService.save(updatedAircraftModelList);
        return new ResponseEntity<>("Updated Aircraft Queue", HttpStatus.CREATED);


    }
}

