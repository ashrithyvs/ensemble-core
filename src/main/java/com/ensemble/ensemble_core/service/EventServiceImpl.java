package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Event;
import com.ensemble.ensemble_core.model.Location;
import com.ensemble.ensemble_core.repository.EventRepository;
import com.ensemble.ensemble_core.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public String addEvent(Event event){
        try {
            if(null!= event.getVenue()){
                Location loc = locationRepository.findOneByAddress(event.getVenue().getAddress());
                if(null!=loc){
                    event.getVenue().setLocationId(loc.getLocationId());
                }else locationRepository.save(event.getVenue());
            }
            eventRepository.save(event);
            return "Event added successfully";
        }catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    public List<Event> getEventsByLocationName(String locationName){
        return eventRepository.findEventsByLocationName(locationName);
    }
}
