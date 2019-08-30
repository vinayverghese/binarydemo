package com.binary.aircraft.repository;

import com.binary.aircraft.model.AircraftModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AircraftRepository extends CrudRepository<AircraftModel, Integer> {

    public List<AircraftRepository> findAircrafts();
    public void save(List<AircraftModel> aircraftModels);

}