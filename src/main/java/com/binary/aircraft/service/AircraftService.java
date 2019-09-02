package com.binary.aircraft.service;

import com.binary.aircraft.comparator.QueueComparator;
import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.request.EnqueueRequest;
import com.binary.aircraft.request.QueueRequest;
import com.binary.aircraft.values.QueueSize;
import com.binary.aircraft.values.QueueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftService {

    @Autowired
    private AircraftDataAccessorService aircraftDataAccessorService;

    public ResponseEntity<String> enqueueAircraft(List<EnqueueRequest> enqueueRequestList) {

        if (enqueueRequestList != null && !enqueueRequestList.isEmpty()) {

            Integer size = enqueueRequestList.size();

            if (validateInputTypeAndSizeList(enqueueRequestList)) {
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

        if (validateInputTypeAndSize(enqueueRequest)) {
            List<AircraftModel> updatedAircraftModelList = new ArrayList<>();
            /**
             If position exists, find existing aircraft in that position
             Update it to new position (+1)
             Add new aircraft to that position
             **/
            if (enqueueRequest.getPosition() != null) {
                Integer position = enqueueRequest.getPosition();
                Integer maxPosition = aircraftDataAccessorService.findMaxAircraftPosition();

                if(position>maxPosition)
                {
                    position=maxPosition+1;
                }
                List<AircraftModel> updateOldAircraftList = aircraftDataAccessorService.findAllAircraftsInQueue();
                AircraftModel addNewAircraftToPosition = new AircraftModel();

                if (updateOldAircraftList != null) {

                    for (AircraftModel updateOldAircraftModel : updateOldAircraftList) {
                        if(updateOldAircraftModel.getAircraftPosition().equals(position)) {
                            addNewAircraftToPosition = copyAicraftModel(updateOldAircraftModel);
                    }
                    }
                    for (AircraftModel updateOldAircraftModel : updateOldAircraftList) {
                        if (updateOldAircraftModel.getAircraftPosition() >= position) {
                            updateOldAircraftModel.setAircraftPosition(updateOldAircraftModel.getAircraftPosition() + 1);
                        }
                    }
                    System.out.println("\nOld Entry :");

                    System.out.println("\nPosition: " + addNewAircraftToPosition.getAircraftPosition() + "  _____  Id )  " + addNewAircraftToPosition.getAircraftId() +  " ___"+
                            "Type: " + addNewAircraftToPosition.getAircraftType() + ", Size: " +
                            addNewAircraftToPosition.getAircraftSize());
                    System.out.println("\n_____\n");


                    /** Adding new entry into old position **/

                    addNewAircraftToPosition.setAircraftType(QueueType.getNameByAbbr(enqueueRequest.getEnqueueType()));
                    addNewAircraftToPosition.setAircraftSize(QueueSize.getNameByAbbr(enqueueRequest.getEnqueueSize()));
                    addNewAircraftToPosition.setAircraftPosition(position);
                    addNewAircraftToPosition.setAircraftId(null);

                    updateOldAircraftList.add(addNewAircraftToPosition);
                    for (AircraftModel aircraftModel : updateOldAircraftList) {
                        System.out.println("\n Position: " + aircraftModel.getAircraftPosition() + "  _____  Id )  " + aircraftModel.getAircraftId() +  " ___"+
                        "Type: " + aircraftModel.getAircraftType() + ", Size: " +
                        aircraftModel.getAircraftSize());
                    }
                    aircraftDataAccessorService.save(updateOldAircraftList);

                } else {

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

                aircraftDataAccessorService.save(updatedAircraftModelList);
            }

            //aircraftDataAccessorService.save(updatedAircraftModelList);
            return new ResponseEntity<>("Updated Aircraft Queue", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid Type/Size", HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<List<AircraftModel>> dequeueAircraft(Optional<String> id) {

        if (!id.isPresent()) {

            List<AircraftModel> aircraftModelList = aircraftDataAccessorService.findAllAircraftsInQueue();

            QueueComparator queueComparator = new QueueComparator();
            Collections.sort(aircraftModelList, queueComparator);

            for (AircraftModel aircraftModel : aircraftModelList)
                System.out.println("Type: " + aircraftModel.getAircraftType() + ", Size: " +
                        aircraftModel.getAircraftSize() + ", Creation Time: " + aircraftModel.getCreationTime() + ", Position: "
                        + aircraftModel.getAircraftPosition());

            return new ResponseEntity<List<AircraftModel>>(aircraftModelList, HttpStatus.OK);

        } else {
            System.out.println("Id passed :" + id);
            Integer numberToBeDequeued = Integer.valueOf(id.get());

            List<AircraftModel> aircraftModelList = aircraftDataAccessorService.findAllAircraftsInQueue();

            if (numberToBeDequeued > aircraftModelList.size()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            } else {


                QueueComparator queueComparator = new QueueComparator();

                Collections.sort(aircraftModelList, queueComparator);

                for (AircraftModel aircraftModel : aircraftModelList) {
                    System.out.println(aircraftModel.getAircraftType() + "     " +
                            aircraftModel.getAircraftSize() + "    " + aircraftModel.getCreationTime() + "    "
                            + aircraftModel.getAircraftPosition());
                }
                List<AircraftModel> deleteList = new ArrayList<>();

                for (int i = 0; i < numberToBeDequeued; i++) {
                    deleteList.add(aircraftModelList.get(i));
                    System.out.println("\nDeleting :  Type : " + deleteList.get(i).getAircraftType() + ", Size:  " + deleteList.get(i).getAircraftSize() + " , Id :  " + aircraftModelList.get(i).getAircraftId() + ", Position :  " +
                            +deleteList.get(i).getAircraftPosition());
                }

                aircraftDataAccessorService.delete(deleteList);

                //Updating queue position
                List<AircraftModel> updatePositionList = aircraftDataAccessorService.findAllAircraftsInQueue();

                Integer i = 1;
                for (AircraftModel updateModel : updatePositionList) {
                    updateModel.setAircraftPosition(i);
                    i++;
                }

                aircraftDataAccessorService.save(updatePositionList);

                return new ResponseEntity<List<AircraftModel>>(updatePositionList, HttpStatus.OK);
            }
        }
    }

    private Boolean validateInputTypeAndSizeList(List<EnqueueRequest> enqueueRequestList) {
        return enqueueRequestList.stream().allMatch(e -> QueueSize.contains(e.getEnqueueSize())
                && QueueType.contains(e.getEnqueueType()));
    }

    private Boolean validateInputTypeAndSize(EnqueueRequest enqueueRequest) {
        return QueueType.contains(enqueueRequest.getEnqueueType()) && QueueSize.contains(enqueueRequest.getEnqueueSize());

    }

    private AircraftModel copyAicraftModel (AircraftModel aircraftModel){
        AircraftModel a = new AircraftModel();

        a.setAircraftId(aircraftModel.getAircraftId());
        a.setAircraftPosition(aircraftModel.getAircraftPosition());
        a.setAircraftStatus(aircraftModel.getAircraftStatus());
        a.setAircraftType(aircraftModel.getAircraftType());
        a.setAircraftSize(aircraftModel.getAircraftSize());
        a.setCreationTime(aircraftModel.getCreationTime());
        a.setUpdateTime(aircraftModel.getUpdateTime());

        return a;
    }
}
