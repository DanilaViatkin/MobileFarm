package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.FeedModelMapper;
import by.refor.mobilefarm.mapper.NutrientsModelMapper;
import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import by.refor.mobilefarm.repo.FeedRepository;
import by.refor.mobilefarm.repo.NutrientsRepository;
import by.refor.mobilefarm.storage.FeedStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FeedStorageImpl implements FeedStorage {
    private final FeedRepository feedRepository;
    private final FeedModelMapper feedModelMapper;
    private final NutrientsRepository nutrientsRepository;
    private final NutrientsModelMapper nutrientsModelMapper;

    @Autowired
    public FeedStorageImpl(FeedRepository feedRepository,
                           FeedModelMapper feedModelMapper,
                           NutrientsRepository nutrientsRepository,
                           NutrientsModelMapper nutrientsModelMapper){
        this.feedRepository = feedRepository;
        this.feedModelMapper = feedModelMapper;
        this.nutrientsRepository = nutrientsRepository;
        this.nutrientsModelMapper = nutrientsModelMapper;
    }

    @Override
    public List<Feed> getAll() {
        return feedModelMapper.mapList(feedRepository.findAll(), Feed.class);
    }

    @Override
    @Transactional
    public Feed createFeed(Feed feed) {
        NutrientsEntity ne = nutrientsModelMapper.map(feed.getNutrients(), NutrientsEntity.class);
        ne = nutrientsRepository.save(ne);
        FeedEntity fe = feedModelMapper.map(feed, FeedEntity.class);
        fe.setNutrients(ne);
        return feedModelMapper.map(feedRepository.save(fe), Feed.class);
    }

    @Override
    public Feed getFeedById(Long id) {
        FeedEntity fe = feedRepository.findById(id).get();
        return feedModelMapper.map(fe, Feed.class);
    }

    @Override
    @Transactional
    public void deleteFeedById(Long feedId) {
        feedRepository.delete(feedRepository.findById(feedId).get());
    }

    public List<Feed> findByOrganizationName(String organization) {

        List<FeedEntity> feeds = feedRepository.findByOrganizationName(organization);

        return feedModelMapper.mapList(feeds, Feed.class);
    }
}
