package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/locations")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location createLocation(@RequestBody Location location){
        return locationService.createLocation(location);
    }

    @DeleteMapping("/{locationId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocationById(@PathVariable Long locationId){
        locationService.deleteLocationById(locationId);
    }
}
