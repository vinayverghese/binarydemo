package com.binary.aircraft.comparator;

import com.binary.aircraft.model.AircraftModel;
import com.binary.aircraft.values.QueueSize;
import com.binary.aircraft.values.QueueType;

import java.util.Comparator;

public class QueueComparator implements Comparator<AircraftModel> {

    public int compare(AircraftModel a1, AircraftModel a2) {
        if (!a1.getAircraftType().equals(a2.getAircraftType())) {
            return QueueType.getPriorityByName(a1.getAircraftType()).compareTo(QueueType.getPriorityByName(a2.getAircraftType()));
        } else if (a1.getAircraftType().equals(a2.getAircraftType()) && !a1.getAircraftSize().equals(a2.getAircraftSize())) {

            return QueueSize.getPriorityByName(a1.getAircraftSize()).compareTo(QueueSize.getPriorityByName(a2.getAircraftSize()));
        }
        System.out.println("CompareTo a1,a2 : " + a1.getCreationTime().compareTo(a2.getCreationTime()));
        System.out.println("\nCompareTo a2,a1 : " + a2.getCreationTime().compareTo(a1.getCreationTime()));

        System.out.println("\nCheck a1 before a2 : " + a1.getCreationTime().isBefore(a2.getCreationTime()));
        System.out.println("\nCheck a2 before a1 : " + a2.getCreationTime().isBefore(a1.getCreationTime()));
        return a1.getCreationTime().compareTo(a2.getCreationTime());
    }
}