package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FeedModelMapper extends MobileFarmModelMapper{

    @Autowired
    private NutrientsModelMapper nutrientsModelMapper;

    private Converter<Nutrients, NutrientsEntity> nutrientsNutrientsEntityConverter(){
        return context -> {
            System.out.println("context.getDestination(): " + context.getDestination());
            if (Objects.nonNull(context.getDestination())){
                nutrientsModelMapper.map(context.getSource(), context.getDestination());
                System.out.println("context.getDestination() after: " + context.getDestination());
                return context.getDestination();
            }
            return nutrientsModelMapper.map(context.getSource(), NutrientsEntity.class);
        };
    }
    public FeedModelMapper(){
        super.createTypeMap(Feed.class, FeedEntity.class).addMappings(mapping -> {
            mapping.when(Conditions.isNotNull()).map(Feed::getFeedId, FeedEntity::setFeedId);
            mapping.when(Conditions.isNotNull()).map(Feed::getType, FeedEntity::setType);
            mapping.when(Conditions.isNotNull()).map(Feed::getName, FeedEntity::setName);
            mapping.when(Conditions.isNotNull()).using(nutrientsNutrientsEntityConverter()).map(Feed::getNutrients, FeedEntity::setNutrients);

            mapping.skip(FeedEntity::setRationFeeds);
        });
    }
}
