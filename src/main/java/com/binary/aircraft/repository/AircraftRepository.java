package com.binary.aircraft.repository;

import com.binary.aircraft.model.AircraftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository extends CrudRepository<AircraftModel, Integer> {

    public List<AircraftModel> findByAircraftId(@Param("aircraft_id") Integer aircraftId);

    //SELECT c FROM Customer c WHERE (:name is null or c.name = :name)
    @Query("SELECT a FROM AircraftModel a WHERE (:aircraftId IS NULL OR a.aircraftId = :aircraftId) AND (:aircraftType IS NULL OR a.aircraftType = :aircraftType) AND (:aircraftSize IS NULL OR a.aircraftSize = :aircraftSize)")
    public List<AircraftModel> findByAircraftIdOrQueueTypeOrQueueSize(
            @Param("aircraftId") Integer aircraftId,
            @Param("aircraftType") String aircraftType,
            @Param("aircraftSize") String aircraftSize);
}
