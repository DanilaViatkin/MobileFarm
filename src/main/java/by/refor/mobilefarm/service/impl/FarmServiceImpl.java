package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.service.FarmService;
import by.refor.mobilefarm.storage.FarmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmStorage farmStorage;

    @Autowired
    public FarmServiceImpl(FarmStorage farmStorage){
        this.farmStorage = farmStorage;
    }
    @Override
    public Farm getFarmByGLN(String gln) {
        return farmStorage.getFarmByGLN(gln);
    }

    @Override
    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
        return farmStorage.getFarmsByOrganizationId(organizationId);
    }

    @Override
    public Farm createFarm(Farm farm, Long organizationId) {
        return farmStorage.createFarm(farm, organizationId);
    }

    @Override
    public Farm updateFarmById(Farm farm, String gln, Long organizationId, Long ownerId) {
        return farmStorage.updateFarmById(farm, gln, organizationId, ownerId);
    }

    @Override
    public void deleteFarmById(Long farmId) {
        farmStorage.deleteFarmById(farmId);
    }
}
