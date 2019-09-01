package com.binary.aircraft.repository;

import com.binary.aircraft.model.AircraftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository extends JpaRepository<AircraftModel, Integer> {

  /*  @Query("SELECT t FROM Todo t where t.title = :title AND t.description = :description")
    public Optional<List<AircraftModel>> findById(@Param("title") String title,
                                                             @Param("description") String description);

    public List<AircraftModel> findAll();*/
}
