package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FarmModelMapper;
import by.refor.mobilefarm.mapper.LocationModelMapper;
import by.refor.mobilefarm.mapper.OrganizationModelMapper;
import by.refor.mobilefarm.mapper.OwnerModelMapper;
import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.model.bo.Owner;
import by.refor.mobilefarm.model.entity.OrganizationEntity;
import by.refor.mobilefarm.repo.OrganizationRepository;
import by.refor.mobilefarm.storage.OrganizationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationStorageImpl implements OrganizationStorage {
    private final OrganizationRepository organizationRepository;
    private final OrganizationModelMapper organizationModelMapper;
    private final LocationModelMapper locationModelMapper;
    private final OwnerModelMapper ownerModelMapper;
    private final FarmModelMapper farmModelMapper;
    @Autowired
    public OrganizationStorageImpl(OrganizationRepository organizationRepository,
                                   OrganizationModelMapper organizationModelMapper,
                                   LocationModelMapper locationModelMapper,
                                   OwnerModelMapper ownerModelMapper,
                                   FarmModelMapper farmModelMapper){
         this.organizationRepository = organizationRepository;
         this.organizationModelMapper = organizationModelMapper;
         this.locationModelMapper = locationModelMapper;
         this.ownerModelMapper = ownerModelMapper;
         this.farmModelMapper = farmModelMapper;
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

    private Organization mapOrganiztionEntityToOrganization(OrganizationEntity organizationEntity) {
        Organization org = organizationModelMapper.map(organizationEntity, Organization.class);
        org.setFarms(farmModelMapper.mapList(organizationEntity.getFarms(), Farm.class));
        return org;
    }
}
