package com.ensemble.ensemble_core.controller;


import com.ensemble.ensemble_core.model.Event;
import com.ensemble.ensemble_core.model.Location;
import com.ensemble.ensemble_core.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PostMapping
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping("/location")
    public List<Event> getEventByLocationName(@RequestBody Location location){
        return eventService.getEventsByLocationName(location.getLocationName());
    }
}
