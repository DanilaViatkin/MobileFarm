package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FeedModelMapper;
import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.repo.FeedRepository;
import by.refor.mobilefarm.storage.FeedStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedStorageImpl implements FeedStorage {
    private final FeedRepository feedRepository;
    private final FeedModelMapper feedModelMapper;

    @Autowired
    public FeedStorageImpl(FeedRepository feedRepository,
                           FeedModelMapper feedModelMapper){
        this.feedRepository = feedRepository;
        this.feedModelMapper = feedModelMapper;
    }

    @Override
    public List<Feed> getAll() {
        return feedModelMapper.mapList(feedRepository.findAll(), Feed.class);
    }

    @Override
    public Feed getFeedById(Long id) {
        FeedEntity fe = feedRepository.findById(id).get();
        return feedModelMapper.map(fe, Feed.class);
    }
}
