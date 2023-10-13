package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.RationModelMapper;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.repo.RationRepository;
import by.refor.mobilefarm.storage.RationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RationStorageImpl implements RationStorage {

    private final RationRepository rationRepository;
    private final RationModelMapper rationModelMapper;


    @Autowired
    public RationStorageImpl(RationRepository rationRepository, RationModelMapper rationModelMapper) {
        this.rationRepository = rationRepository;
        this.rationModelMapper = rationModelMapper;
    }
    @Override
    @Transactional
    public void deleteRationById(Long rationId) {
        rationRepository.delete(rationRepository.findById(rationId).get());
    }

    @Override
    public List<Integer> findByOrganizationName(String organizationName){

        List<Integer> rations = rationRepository.findByOrganizationName(organizationName);
        //mapList(FeedGroupRepository.findAll(), FeedGroup.class)
//        FeedGroupEntity frontGroup = feedGroupModelMapper.map(feedGroup, FeedGroupEntity.class);
//        feedGroupModelMapper.map(frontGroup, fge);
//        fge = FeedGroupRepository.save(fge)

        return rations;
    }

    @Override
    public List<Ration> getAll() {
        return rationModelMapper.mapList(rationRepository.findAll(), Ration.class);
    }
}
