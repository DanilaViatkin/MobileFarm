package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.exception.custom.NotFoundEntityException;
import by.refor.mobilefarm.mapper.FarmModelMapper;
import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.entity.FarmEntity;
import by.refor.mobilefarm.repo.FarmRepository;
import by.refor.mobilefarm.repo.LocationRepository;
import by.refor.mobilefarm.repo.OrganizationRepository;
import by.refor.mobilefarm.repo.OwnerRepository;
import by.refor.mobilefarm.storage.FarmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
        return farmModelMapper.map(farmRepository.findByGln(gln).orElseThrow(() -> new NotFoundEntityException("farm.gln.not.found", gln)), Farm.class);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmModelMapper.map(farmRepository.findById(id).orElseThrow(() -> new NotFoundEntityException("farm.not.found", id)), Farm.class);
    }

    @Override
    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
        return farmModelMapper.mapList(farmRepository.findByOrganization_OrganizationId(organizationId), Farm.class);
    }

    @Override
    @Transactional
    public Farm createFarm(Farm farm, Long organizationId) {
        FarmEntity fe = farmModelMapper.map(farm, FarmEntity.class);
        fe.setLocation(locationRepository.save(fe.getLocation()));
        fe.setOwner(ownerRepository.save(fe.getOwner()));
        fe.setOrganization(organizationRepository.findById(organizationId).orElseThrow(() -> new NotFoundEntityException("organization.not.found", organizationId)));
        return farmModelMapper.map(farmRepository.save(fe), Farm.class);
    }

    @Override
    @Transactional
    public Farm updateFarmById(Farm farm, String gln, Long organizationId, Long ownerId) {
        FarmEntity fe = farmRepository.findByGln(gln).orElseThrow(() -> new NotFoundEntityException("farm.gln.not.found", gln));
        farmModelMapper.map(farm, fe);
        if (Objects.nonNull(organizationId)){
            fe.setOrganization(organizationRepository.findById(organizationId).orElseThrow(() -> new NotFoundEntityException("organization.not.found", organizationId)));
        }
        if (Objects.nonNull(ownerId)){
            fe.setOwner(ownerRepository.findById(ownerId).get());
        }
        return farmModelMapper.map(farmRepository.save(fe), Farm.class);
    }

    @Override
    @Transactional
    public void deleteFarmById(Long farmId) {
        FarmEntity fe = farmRepository.findById(farmId).get();
        farmRepository.delete(fe);
    }
}
