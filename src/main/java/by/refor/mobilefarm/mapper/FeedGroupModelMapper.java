package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import by.refor.mobilefarm.model.entity.RationEntity;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedGroupModelMapper extends MobileFarmModelMapper{
    private Converter<List<RationEntity>, List<Ration>> rationEntityListToRationListConverter(){
        return context -> context.getSource()
                .stream()
                .map(rationEntity -> {
                    Ration ration = new Ration();
                    ration.setRationId(rationEntity.getRationId());
                    ration.setFeeds(rationEntity.getRationFeeds().stream()
                            .map(rationFeed -> {
                                FeedEntity feedEntity = rationFeed.getFeed();
                                return new Feed()
                                        .setFeedId(feedEntity.getFeedId())
                                        .setType(feedEntity.getType())
                                        .setName(feedEntity.getName())
                                        .setAmount(rationFeed.getAmount());
                            })
                            .toList());
                    ration.setFeedGroup(new FeedGroup()
                            .setFeedGroupId(rationEntity.getFeedGroup().getFeedGroupId())
                            .setGeneticWeight(rationEntity.getFeedGroup().getGeneticWeight())
                            .setProductivity(rationEntity.getFeedGroup().getProductivity())
                            .setAge(rationEntity.getFeedGroup().getAge())
                            .setType(rationEntity.getFeedGroup().getType())
                            .setWeight(rationEntity.getFeedGroup().getWeight()));
                    return ration;
                })
                .toList();
    }

    private Converter<NutrientsEntity, NutrientsEntity> nutrientsEntityNutrientsEntityConverter(){
        return context -> context.getDestination()
                .setEnergyExchange(context.getSource().getEnergyExchange())
                .setFeedUnit(context.getSource().getFeedUnit())
                .setDryProtein(context.getSource().getDryProtein())
                .setDryMatter(context.getSource().getDryMatter())
                .setDigestedProtein(context.getSource().getDigestedProtein())
                .setRawFat(context.getSource().getRawFat())
                .setRawFiber(context.getSource().getRawFiber())
                .setStarch(context.getSource().getStarch())
                .setSugar(context.getSource().getSugar())
                .setLysine(context.getSource().getLysine())
                .setMethionineAndCystitis(context.getSource().getMethionineAndCystitis())
                .setCalcium(context.getSource().getCalcium())
                .setPhosphorus(context.getSource().getPhosphorus())
                .setMagnesium(context.getSource().getMagnesium())
                .setPotassium(context.getSource().getPotassium())
                .setSulfur(context.getSource().getSulfur())
                .setFerrum(context.getSource().getFerrum())
                .setCopper(context.getSource().getCopper())
                .setZins(context.getSource().getZins())
                .setManganese(context.getSource().getManganese())
                .setCobalt(context.getSource().getCobalt())
                .setIodine(context.getSource().getIodine())
                .setCarotene(context.getSource().getCarotene())
                .setVitaminE(context.getSource().getVitaminD())
                .setSalt(context.getSource().getSalt());
    }
    public FeedGroupModelMapper() {
        super.createTypeMap(FeedGroupEntity.class, FeedGroup.class).addMappings(mapping -> {
            mapping.when(Conditions.isNotNull()).using(rationEntityListToRationListConverter()).map(FeedGroupEntity::getRations, FeedGroup::setRations);
        });
        super.createTypeMap(FeedGroup.class, FeedGroupEntity.class).addMappings(mapping -> {
            mapping.skip(FeedGroupEntity::setRations);
        });
        super.createTypeMap(FeedGroupEntity.class, FeedGroupEntity.class).addMappings(mapping -> {
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getType, FeedGroupEntity::setType);
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getProductivity, FeedGroupEntity::setProductivity);
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getWeight, FeedGroupEntity::setWeight);
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getGeneticWeight, FeedGroupEntity::setGeneticWeight);
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getAge, FeedGroupEntity::setAge);
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getFeedGroupId, FeedGroupEntity::setFeedGroupId);
            mapping.when(Conditions.isNotNull()).using(nutrientsEntityNutrientsEntityConverter()).map(FeedGroupEntity::getNutrients, FeedGroupEntity::setNutrients);
            mapping.when(Conditions.isNotNull()).map(FeedGroupEntity::getRations, FeedGroupEntity::setRations);

        });
    }
}
