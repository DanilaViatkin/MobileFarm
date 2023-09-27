package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.LocationModelMapper;
import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.model.entity.LocationEntity;
import by.refor.mobilefarm.repo.LocationRepository;
import by.refor.mobilefarm.storage.LocationStorage;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LocationStorageImpl implements LocationStorage {

    private final LocationRepository locationRepository;
    private final LocationModelMapper locationModelMapper;

    @Autowired
    public LocationStorageImpl(LocationRepository locationRepository,
                               LocationModelMapper locationModelMapper){
        this.locationRepository = locationRepository;
        this.locationModelMapper = locationModelMapper;
    }
    @Override
    @Transactional
    public Location createLocation(Location location) {
        return locationModelMapper.map(locationRepository.save(locationModelMapper.map(location, LocationEntity.class)), Location.class);
    }

    @Override
    @Transactional
    public void deleteLocationById(Long locationId) {
        locationRepository.delete(locationRepository.findById(locationId).get());
    }
}
