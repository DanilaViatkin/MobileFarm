package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.mapper.FeedGroupModelMapper;
import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.service.FeedGroupService;
import by.refor.mobilefarm.storage.FeedGroupStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FeedGroupServiceImpl implements FeedGroupService {
    private final FeedGroupStorage FeedGroupStorage;

    @Autowired
    public FeedGroupServiceImpl(FeedGroupStorage FeedGroupStorage){
        this.FeedGroupStorage = FeedGroupStorage;
    }

    @Override
    public List<FeedGroup> getFeedGroupByParams(String type, Integer age, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight){
        return FeedGroupStorage.getFeedGroupByParams(type, age, productivity, weight, geneticWeight);
    }

    @Override
    public FeedGroup getFeedGroupById(Long feedGroupId) {
        return FeedGroupStorage.getFeedGroupById(feedGroupId);
    }

    @Override
    public List<FeedGroup> getAllFeedGroups() {
        return FeedGroupStorage.getAllFeedGroups();
    }

    @Override
    public FeedGroup createFeedGroup(FeedGroup feedGroup) {
        return FeedGroupStorage.createFeedGroup(feedGroup);
    }

    @Override
    public FeedGroup updateFeedGroupById(Long id, FeedGroup feedGroup) {
        return FeedGroupStorage.updateFeedGroupById(id, feedGroup);
    }

    @Override
    public void deleteFeedGroupById(Long FeedGroupId) {
        FeedGroupStorage.deleteFeedGroupById(FeedGroupId);
    }
    @Override
    public List<FeedGroup> getFeedGroupByOrganization(String organizationName)
    {
        return FeedGroupStorage.getFeedGroupByOrganization(organizationName);
    };
}
