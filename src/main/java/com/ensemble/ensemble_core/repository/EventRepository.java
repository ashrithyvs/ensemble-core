package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("From Events e where e.venue.locationName=:locationName")
    List<Event> findEventsByLocationName(String locationName);
}
