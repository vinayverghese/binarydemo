package com.binary.aircraft.repository;

import com.binary.aircraft.model.AircraftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository extends CrudRepository<AircraftModel, Integer> {

    public AircraftModel findByAircraftPosition(@Param("aircraftPosition") Integer aircraftPosition);

    @Query("SELECT a FROM AircraftModel a WHERE (:aircraftId IS NULL OR a.aircraftId = :aircraftId) AND (:aircraftType IS NULL OR a.aircraftType = :aircraftType) AND (:aircraftSize IS NULL OR a.aircraftSize = :aircraftSize) ORDER BY aircraftPosition")
    public List<AircraftModel> findByAircraftIdOrQueueTypeOrQueueSize(
            @Param("aircraftId") Integer aircraftId,
            @Param("aircraftType") String aircraftType,
            @Param("aircraftSize") String aircraftSize);

    @Query("SELECT COALESCE(MAX(a.aircraftPosition), 0) FROM AircraftModel a")
    public Integer getMaxAircraftPosition();
}
