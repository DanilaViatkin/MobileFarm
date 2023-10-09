package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.entity.RationEntity;
import by.refor.mobilefarm.model.entity.RationFeeds;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RationModelMapper extends MobileFarmModelMapper{
    @Autowired
    private FeedModelMapper feedModelMapper;

    public Converter<List<RationFeeds>, List<Feed>> rationFeedsToFeedConverter(){
        return context->{
            List<Feed> feeds = new ArrayList<>();
            context.getSource()
                    .forEach(rationFeeds -> {
                        Feed feed = feedModelMapper.map(rationFeeds.getFeed(), Feed.class);
                        feed.setAmount(rationFeeds.getAmount());
                        feeds.add(feed);
                    });
            return feeds;
        };
    }
    public RationModelMapper(){
        super.createTypeMap(RationEntity.class, Ration.class).addMappings(mapping -> {
            mapping.using(rationFeedsToFeedConverter()).map(RationEntity::getRationFeeds, Ration::setFeeds);
        });
    }
}
