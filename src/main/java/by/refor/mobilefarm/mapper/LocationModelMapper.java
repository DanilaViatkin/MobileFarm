package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.model.entity.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationModelMapper extends MobileFarmModelMapper{
    public LocationModelMapper(){
        super.createTypeMap(LocationEntity.class, Location.class).addMappings(mapping -> {
            mapping.map(LocationEntity::getLocationIndex, Location::setLocationIndex);
            mapping.map(LocationEntity::getRegion, Location::setRegion);
            mapping.map(LocationEntity::getDistrict, Location::setDistrict);
            mapping.map(LocationEntity::getLocationName, Location::setLocationName);
            mapping.map(LocationEntity::getCoordinates, Location::setCoordinates);
            mapping.map(LocationEntity::getStreetName, Location::setStreetName);
            mapping.map(LocationEntity::getHouseNumber, Location::setHouseNumber);
            mapping.map(LocationEntity::getCorpusNumber, Location::setCorpusNumber);
            mapping.map(LocationEntity::getPhoneNumber, Location::setPhoneNumber);
            mapping.map(LocationEntity::getFaxNumber, Location::setFaxNumber);
            mapping.map(LocationEntity::getEmail, Location::setEmail);
        });
    }
}
