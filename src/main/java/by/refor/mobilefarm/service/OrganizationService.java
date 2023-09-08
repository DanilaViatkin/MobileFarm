package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Organization;

public interface OrganizationService {
    Organization getOrganizationByGLN(String gln);
    Organization getOrganizationByUNP(String unp);

    Organization createOrganization(Organization organization);
    void deleteOrganizationById(Long organizationId);
}
