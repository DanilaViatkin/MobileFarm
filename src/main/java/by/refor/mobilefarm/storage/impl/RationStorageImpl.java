package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FeedGroupModelMapper;
import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import by.refor.mobilefarm.model.entity.RationEntity;
import by.refor.mobilefarm.repo.FeedGroupRepository;
import by.refor.mobilefarm.repo.RationRepository;
import by.refor.mobilefarm.storage.RationStorage;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RationStorageImpl implements RationStorage {

    private final RationRepository rationRepository;
//    private final RationModelMapper rationModelMapper;


    @Autowired
    public RationStorageImpl(RationRepository rationRepository) {
        this.rationRepository = rationRepository;
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
}
