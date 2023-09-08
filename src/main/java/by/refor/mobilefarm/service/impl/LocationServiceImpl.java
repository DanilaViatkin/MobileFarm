package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.service.LocationService;
import by.refor.mobilefarm.storage.LocationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationStorage locationStorage;

    @Autowired
    public LocationServiceImpl(LocationStorage locationStorage){
        this.locationStorage = locationStorage;
    }
    @Override
    public Location createLocation(Location location) {
        return locationStorage.createLocation(location);
    }

    @Override
    public void deleteLocationById(Long locationId) {
        locationStorage.deleteLocationById(locationId);
    }
}
