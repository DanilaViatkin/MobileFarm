package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Organization;

public interface OrganizationStorage {
    Organization getOrganizationByGLN(String gln);
    Organization getOrganizationByUNP(String unp);
    Organization createOrganization(Organization organization);
    void deleteOrganizationById(Long organizationId);
}
