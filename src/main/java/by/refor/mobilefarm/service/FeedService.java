package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Feed;

import java.util.List;

public interface FeedService {
    List<Feed> getAll();
    Feed createFeed(Feed feed);
    void deleteFeedById(Long feedId);

    List<Feed> findByOrganizationName(String organization);
}