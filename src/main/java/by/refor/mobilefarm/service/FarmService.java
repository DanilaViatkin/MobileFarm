package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Farm;

import java.util.List;

public interface FarmService {
    Farm getFarmByGLN(String gln);
    List<Farm> getFarmsByOrganizationId(Long organizationId);

}
