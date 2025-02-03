package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Event;

import java.util.List;

public interface EventService {
     List<Event> getAllEvents();
     List<Event> getEventsByLocationName(String locationName);
     String addEvent(Event event);
}
