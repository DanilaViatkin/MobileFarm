package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.service.FeedService;
import by.refor.mobilefarm.storage.FeedStorage;
import by.refor.mobilefarm.storage.impl.FeedStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    private final FeedStorage feedStorage;

    @Autowired
    public FeedServiceImpl(FeedStorageImpl feedStorage){
        this.feedStorage = feedStorage;
    }

    @Override
    public List<Feed> getAll() {
        return feedStorage.getAll();
    }

    @Override
    public Feed createFeed(Feed feed) {
        return feedStorage.createFeed(feed);
    }

    @Override
    public void deleteFeedById(Long feedId) {
        feedStorage.deleteFeedById(feedId);
    }

    @Override
    public List<Feed> findByOrganizationName(String organizationName)
    {
        return feedStorage.findByOrganizationName(organizationName);
    };
}
