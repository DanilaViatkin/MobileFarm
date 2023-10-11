package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.FeedGroup;
import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;

import java.math.BigDecimal;
import java.util.List;

public interface FeedGroupService {
    List<FeedGroup> getFeedGroupByParams(String type, Integer age, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight);
    FeedGroup getFeedGroupById(Long feedGroupId);
    List<FeedGroup> getAllFeedGroups();
    FeedGroup createFeedGroup(FeedGroup feedGroup);
    FeedGroup updateFeedGroupById(Long id, FeedGroup feedGroup);
    void deleteFeedGroupById(Long FeedGroupId);

    List<FeedGroup> getFeedGroupByOrganization(String organizationName);
}
