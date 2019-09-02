package com.binary.aircraft.comparator;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.values.QueueSize;
import com.binary.aircraft.values.QueueType;

import java.util.Comparator;

public class QueueSizeComparator implements Comparator<AircraftModel> {

    public int compare(AircraftModel a1, AircraftModel a2) {

        if(a1.getAircraftType().equals(a2.getAircraftType())) {
            return QueueSize.getPriorityByName(a1.getAircraftSize()).compareTo(QueueSize.getPriorityByName(a2.getAircraftSize()));
        }
    return 1;
    }
}
