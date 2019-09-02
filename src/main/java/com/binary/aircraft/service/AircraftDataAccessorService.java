package com.binary.aircraft.service;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.repository.AircraftRepository;
import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.request.QueueRequest;
import com.binary.aircraft.values.QueueSize;
import com.binary.aircraft.values.QueueType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AircraftDataAccessorService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public void save(List<AircraftModel> aircraftModelList) {
        aircraftRepository.saveAll(aircraftModelList);
    }

    public List<AircraftModel> findAllAircraftsInQueue() {
        return (List<AircraftModel>) aircraftRepository.findAll();
    }

    public AircraftModel findAircraftsByPosition(EnqueueRequest enqueueRequest) {
        return (AircraftModel) aircraftRepository.findByAircraftPosition(enqueueRequest.getPosition());
    }


    public List<AircraftModel> findAircraftsByAircraftIdOrQueueTypeOrQueueSize(QueueRequest queueRequest) {

        System.out.println("Search based on : " +
                QueueType.getNameByAbbr(queueRequest.getQueueType())  +
                " and "  +  QueueSize.getNameByAbbr(queueRequest.getQueueSize()));

        return aircraftRepository.findByAircraftIdOrQueueTypeOrQueueSize(queueRequest.getAircraftId(),
                QueueType.getNameByAbbr(queueRequest.getQueueType()),
                QueueSize.getNameByAbbr(queueRequest.getQueueSize()));
    }
}