package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.service.OrganizationService;
import by.refor.mobilefarm.storage.OrganizationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationStorage organizationStorage;

    @Autowired
    public OrganizationServiceImpl(OrganizationStorage organizationStorage){
        this.organizationStorage = organizationStorage;
    }
    @Override
    public Organization getOrganizationByGLN(String gln) {
        return organizationStorage.getOrganizationByGLN(gln);
    }

    @Override
    public Organization getOrganizationByUNP(String unp) {
        return organizationStorage.getOrganizationByUNP(unp);
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationStorage.createOrganization(organization);
    }

    @Override
    public void deleteOrganizationById(Long organizationId) {
        organizationStorage.deleteOrganizationById(organizationId);
    }
}
