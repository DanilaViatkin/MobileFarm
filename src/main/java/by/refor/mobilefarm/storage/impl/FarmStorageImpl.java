package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FarmModelMapper;
import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.repo.FarmRepository;
import by.refor.mobilefarm.storage.FarmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FarmStorageImpl implements FarmStorage {

    private final FarmRepository farmRepository;
    private final FarmModelMapper farmModelMapper;

    @Autowired
    public FarmStorageImpl(FarmRepository farmRepository,
                           FarmModelMapper farmModelMapper) {
        this.farmRepository = farmRepository;
        this.farmModelMapper = farmModelMapper;
    }
    public Farm getFarmByGLN(String gln) {
        return farmModelMapper.map(farmRepository.findByGln(gln), Farm.class);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmModelMapper.map(farmRepository.findById(id), Farm.class);
    }

    @Override
    public List<Farm> getFarmsByOrganizationId(Long organizationId) {
        return farmModelMapper.mapList(farmRepository.findByOrganization_OrganizationId(organizationId), Farm.class);
    }
}
