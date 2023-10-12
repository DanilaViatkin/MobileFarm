package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Feed;

import java.util.List;

public interface FeedStorage {
    List<Feed> getAll();
    Feed getFeedById(Long id);
    Feed createFeed(Feed feed);

    void deleteFeedById(Long feedId);

    List<Feed> findByOrganizationName(String organization);
}
