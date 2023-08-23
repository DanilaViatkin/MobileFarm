package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Farm;

import java.util.List;

public interface FarmStorage {
    Farm getFarmByGLN(String gln);
    Farm getFarmById(Long id);

    List<Farm> getFarmsByOrganizationId(Long organizationId);

}
