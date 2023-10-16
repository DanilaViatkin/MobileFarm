package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.RationModelMapper;
import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.RationEntity;
import by.refor.mobilefarm.repo.FeedGroupRepository;
import by.refor.mobilefarm.repo.RationFeedsRepository;
import by.refor.mobilefarm.repo.RationRepository;
import by.refor.mobilefarm.storage.FeedGroupStorage;
import by.refor.mobilefarm.storage.RationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RationStorageImpl implements RationStorage {

    private final RationRepository rationRepository;

    private final RationFeedsRepository rationFeedsRepository;

    private final RationModelMapper rationModelMapper;

    private final FeedGroupRepository feedGroupRepository;
    @Autowired
    public RationStorageImpl(RationRepository rationRepository,
                             RationFeedsRepository rationFeedsRepository,
                             RationModelMapper rationModelMapper,
                             FeedGroupRepository feedGroupRepository) {
        this.rationRepository = rationRepository;
        this.rationFeedsRepository = rationFeedsRepository;
        this.rationModelMapper = rationModelMapper;
        this.feedGroupRepository = feedGroupRepository;
    }

    @Override
    @Transactional
    public Ration createRation(Ration ration, Long feedGroupId){
        RationEntity re = rationModelMapper.map(ration, RationEntity.class);
        re.setFeedGroup(feedGroupRepository.findById(feedGroupId).get());
        rationRepository.save(re);
        re.getRationFeeds().stream()
                .map(rationFeeds -> rationFeeds.setRation(re))
                .forEach(rationFeedsRepository::save);
        Ration rat = rationModelMapper.map(re, Ration.class);
        return rat;
    }
    @Override
    @Transactional
    public void deleteRationById(Long rationId) {
        rationRepository.delete(rationRepository.findById(rationId).get());
    }

    @Override
    public List<Ration> findByOrganizationName(String organizationName){
        List<Ration> rations = rationRepository.findByOrganizationName(organizationName);

        return rationModelMapper.mapList(rations, Ration.class);

    }

    @Override
    public List<Ration> getAll() {
        return rationModelMapper.mapList(rationRepository.findAll(), Ration.class);
    }
}
