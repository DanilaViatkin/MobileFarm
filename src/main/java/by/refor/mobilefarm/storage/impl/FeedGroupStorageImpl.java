package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FeedGroupModelMapper;
import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import by.refor.mobilefarm.repo.AnimalPassportRepository;
import by.refor.mobilefarm.repo.FeedGroupRepository;
import by.refor.mobilefarm.storage.FeedGroupStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FeedGroupStorageImpl implements FeedGroupStorage {
    private final FeedGroupRepository FeedGroupRepository;
    private final FeedGroupModelMapper feedGroupModelMapper;
    @Autowired
    public FeedGroupStorageImpl(FeedGroupRepository FeedGroupRepository,
                                FeedGroupModelMapper feedGroupModelMapper){
        this.FeedGroupRepository = FeedGroupRepository;
        this.feedGroupModelMapper = feedGroupModelMapper;
    }
    @Override
    public List<FeedGroup> getFeedGroupByParams(String type, Integer age, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight){
        FeedGroupEntity fge = new FeedGroupEntity()
                .setType(type)
                .setAge(age)
                .setProductivity(productivity)
                .setWeight(weight)
                .setGeneticWeight(geneticWeight);
        List<FeedGroupEntity> feedGroupEntities = FeedGroupRepository
                .findAll(Example.of(fge));

        return feedGroupModelMapper.mapList(feedGroupEntities, FeedGroup.class);
    }

    @Override
    public List<FeedGroup> getAllFeedGroups() {
        return feedGroupModelMapper.mapList(FeedGroupRepository.findAll(), FeedGroup.class);
    }

    @Override
    @Transactional
    public FeedGroup createFeedGroup(FeedGroup feedGroup) {
        FeedGroupEntity gge = feedGroupModelMapper.map(feedGroup, FeedGroupEntity.class);
        gge = FeedGroupRepository
                .save(gge);
        return feedGroupModelMapper.map(gge,
                FeedGroup.class);
    }

    @Override
    @Transactional
    public FeedGroup updateFeedGroupById(Long id, FeedGroup feedGroup) {
        FeedGroupEntity gge = FeedGroupRepository.findById(id).get();
        FeedGroupEntity frontGroup = feedGroupModelMapper.map(feedGroup, FeedGroupEntity.class);
        feedGroupModelMapper.map(frontGroup, gge);
        gge = FeedGroupRepository.save(gge);
        return feedGroupModelMapper.map(gge,
                FeedGroup.class);
    }

    @Override
    public FeedGroup getFeedGroupById(Long FeedGroupId) {
        return feedGroupModelMapper.map(FeedGroupRepository.findById(FeedGroupId).get(), FeedGroup.class);
    }

    @Override
    @Transactional
    public void deleteFeedGroupById(Long FeedGroupId) {
        FeedGroupRepository.delete(FeedGroupRepository.findById(FeedGroupId).get());
    }
    @Override
   public List<FeedGroup> getFeedGroupByOrganization(String organizationName){

        List<FeedGroupEntity> fge = FeedGroupRepository.findByOrganizationName(organizationName);
        //mapList(FeedGroupRepository.findAll(), FeedGroup.class)
//        FeedGroupEntity frontGroup = feedGroupModelMapper.map(feedGroup, FeedGroupEntity.class);
//        feedGroupModelMapper.map(frontGroup, fge);
//        fge = FeedGroupRepository.save(fge)

        return feedGroupModelMapper.mapList(fge, FeedGroup.class);
    }

}
