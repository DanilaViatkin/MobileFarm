package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FarmModelMapper;
import by.refor.mobilefarm.mapper.LocationModelMapper;
import by.refor.mobilefarm.mapper.OrganizationModelMapper;
import by.refor.mobilefarm.mapper.OwnerModelMapper;
import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.model.bo.Owner;
import by.refor.mobilefarm.model.entity.LocationEntity;
import by.refor.mobilefarm.model.entity.OrganizationEntity;
import by.refor.mobilefarm.model.entity.OwnerEntity;
import by.refor.mobilefarm.repo.LocationRepository;
import by.refor.mobilefarm.repo.OrganizationRepository;
import by.refor.mobilefarm.repo.OwnerRepository;
import by.refor.mobilefarm.storage.OrganizationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrganizationStorageImpl implements OrganizationStorage {
    private final OrganizationRepository organizationRepository;
    private final OrganizationModelMapper organizationModelMapper;
    private final LocationModelMapper locationModelMapper;
    private final OwnerModelMapper ownerModelMapper;
    private final FarmModelMapper farmModelMapper;

    private final OwnerRepository ownerRepository;
    private final LocationRepository locationRepository;
    @Autowired
    public OrganizationStorageImpl(OrganizationRepository organizationRepository,
                                   OrganizationModelMapper organizationModelMapper,
                                   LocationModelMapper locationModelMapper,
                                   OwnerModelMapper ownerModelMapper,
                                   FarmModelMapper farmModelMapper,
                                   OwnerRepository ownerRepository,
                                   LocationRepository locationRepository){
         this.organizationRepository = organizationRepository;
         this.organizationModelMapper = organizationModelMapper;
         this.locationModelMapper = locationModelMapper;
         this.ownerModelMapper = ownerModelMapper;
         this.farmModelMapper = farmModelMapper;
         this.ownerRepository = ownerRepository;
         this.locationRepository = locationRepository;
    }
    @Override
    public Organization getOrganizationByGLN(String gln) {
        OrganizationEntity organizationEntity = organizationRepository.findByGln(gln);
        return mapOrganiztionEntityToOrganization(organizationEntity);
    }

    @Override
    public Organization getOrganizationByUNP(String unp) {
        OrganizationEntity organizationEntity = organizationRepository.findByUnp(unp);
        return mapOrganiztionEntityToOrganization(organizationEntity);
    }

    @Override
    @Transactional
    public Organization createOrganization(Organization organization) {
        OrganizationEntity oe = organizationModelMapper.map(organization, OrganizationEntity.class);
        oe.setOwner(ownerRepository.save(oe.getOwner()));
        oe.setLocation(locationRepository.save(oe.getLocation()));
        return organizationModelMapper.map(organizationRepository.save(oe), Organization.class);
    }

    @Override
    @Transactional
    public void deleteOrganizationById(Long organizationId) {
        organizationRepository.delete(organizationRepository.findById(organizationId).get());
    }

    private Organization mapOrganiztionEntityToOrganization(OrganizationEntity organizationEntity) {
        Organization org = organizationModelMapper.map(organizationEntity, Organization.class);
        org.setFarms(farmModelMapper.mapList(organizationEntity.getFarms(), Farm.class));
        return org;
    }
}
