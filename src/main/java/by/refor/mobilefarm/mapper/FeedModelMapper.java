package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.entity.FeedEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedModelMapper extends MobileFarmModelMapper{
    public FeedModelMapper(){
        super.createTypeMap(FeedEntity.class, Feed.class).addMappings(mapping -> {

        });
    }
}
