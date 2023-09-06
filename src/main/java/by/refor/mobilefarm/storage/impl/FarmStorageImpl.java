package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FarmModelMapper;
import by.refor.mobilefarm.mapper.LocationModelMapper;
import by.refor.mobilefarm.mapper.OwnerModelMapper;
import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.model.entity.FarmEntity;
import by.refor.mobilefarm.model.entity.OrganizationEntity;
import by.refor.mobilefarm.repo.FarmRepository;
import by.refor.mobilefarm.repo.LocationRepository;
import by.refor.mobilefarm.repo.OrganizationRepository;
import by.refor.mobilefarm.repo.OwnerRepository;
import by.refor.mobilefarm.storage.FarmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FarmStorageImpl implements FarmStorage {

    private final FarmRepository farmRepository;
    private final OrganizationRepository organizationRepository;
    private final FarmModelMapper farmModelMapper;
    private final OwnerRepository ownerRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public FarmStorageImpl(FarmRepository farmRepository,
                           FarmModelMapper farmModelMapper,
                           OrganizationRepository organizationRepository,
                           OwnerRepository ownerRepository,
                           LocationRepository locationRepository) {
        this.farmRepository = farmRepository;
        this.farmModelMapper = farmModelMapper;
        this.organizationRepository = organizationRepository;
        this.ownerRepository = ownerRepository;
        this.locationRepository = locationRepository;
    }
    public Farm getFarmByGLN(String gln) {
        return farmModelMapper.map(farmRepository.findByGln(gln), Farm.class);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmModelMapper.map(farmRepository.findById(id), Farm.class);
    }

    @Override
    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
        return farmModelMapper.mapList(farmRepository.findByOrganization_OrganizationId(organizationId), Farm.class);
    }

    @Override
    public Farm createFarm(Farm farm, Long organizationId) {
        FarmEntity fe = farmModelMapper.map(farm, FarmEntity.class);
        fe.setLocation(locationRepository.save(fe.getLocation()));
        fe.setOwner(ownerRepository.save(fe.getOwner()));
        fe.setOrganization(organizationRepository.findById(organizationId).get());
        return farmModelMapper.map(farmRepository.save(fe), Farm.class);
    }

    @Override
    public void deleteFarmById(Long farmId) {
        FarmEntity fe = farmRepository.findById(farmId).get();
        farmRepository.delete(fe);
    }
}
