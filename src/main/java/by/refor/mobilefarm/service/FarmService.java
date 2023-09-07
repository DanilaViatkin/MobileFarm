package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Farm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FarmService {
    Farm getFarmByGLN(String gln);
    List<Farm> getFarmsByOrganizationId(Long organizationId);
    Farm createFarm(Farm farm, Long organizationId);

    Farm updateFarmById(Farm farm, String gln, Long organizationId, Long ownerId);

    void deleteFarmById(Long farmId);
}
