package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Location;

public interface LocationStorage {
    Location createLocation(Location location);
    void deleteLocationById(Long locationId);
}
