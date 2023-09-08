package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Location;

public interface LocationService {
    Location createLocation(Location location);
    void deleteLocationById(Long locationId);
}
