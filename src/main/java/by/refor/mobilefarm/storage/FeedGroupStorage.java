package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.FeedGroup;

import java.math.BigDecimal;
import java.util.List;

public interface FeedGroupStorage {
    FeedGroup getFeedGroupByParams(String type, Integer age, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight);
    List<FeedGroup> getAllFeedGroups();
    FeedGroup createFeedGroup(FeedGroup feedGroup);
    FeedGroup updateFeedGroupById(Long id, FeedGroup feedGroup);
    FeedGroup getFeedGroupById(Long FeedGroupId);
    void deleteFeedGroupById(Long FeedGroupId);

}