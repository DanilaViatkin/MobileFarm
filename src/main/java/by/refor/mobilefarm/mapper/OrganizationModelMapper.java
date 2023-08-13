package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.model.entity.LocationEntity;
import by.refor.mobilefarm.model.entity.OrganizationEntity;
import org.modelmapper.Converter;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class OrganizationModelMapper extends MobileFarmModelMapper{
    public OrganizationModelMapper() {
        super.createTypeMap(OrganizationEntity.class, Organization.class).addMappings(mapper -> {
            mapper.map(OrganizationEntity::getOrganizationId, Organization::setOrganizationId);
            mapper.map(OrganizationEntity::getGln, Organization::setGln);
            mapper.map(OrganizationEntity::getUnp, Organization::setUnp);
            mapper.map(OrganizationEntity::getRegistrationDate, Organization::setRegistrationDate);
            mapper.map(OrganizationEntity::getName, Organization::setName);
            mapper.map(OrganizationEntity::getShortName, Organization::setShortName);
            mapper.map(OrganizationEntity::getOkpo, Organization::setOkpo);
            mapper.map(OrganizationEntity::getEgr, Organization::setEgr);
            mapper.map(OrganizationEntity::getCreatedDate, Organization::setCreatedDate);
            mapper.map(OrganizationEntity::getPaymentAccount, Organization::setPaymentAccount);
        });
    }
}
