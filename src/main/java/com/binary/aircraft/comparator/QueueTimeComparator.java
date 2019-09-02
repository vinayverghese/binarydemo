package com.binary.aircraft.comparator;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.values.QueueSize;

import java.util.Comparator;

public class QueueTimeComparator implements Comparator<AircraftModel> {

    public int compare(AircraftModel a1, AircraftModel a2) {
        if (a1.getAircraftSize().compareTo(a2.getAircraftSize()) == 0) {
            if (a1.getCreationTime().isBefore(a2.getCreationTime())) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
