package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.GeneticGroup;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.GeneticGroupEntity;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import by.refor.mobilefarm.model.entity.RationEntity;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneticGroupModelMapper extends MobileFarmModelMapper{
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
                    ration.setGeneticGroup(new GeneticGroup()
                            .setGeneticGroupId(rationEntity.getGeneticGroup().getGeneticGroupId())
                            .setGeneticWeight(rationEntity.getGeneticGroup().getGeneticWeight())
                            .setProductivity(rationEntity.getGeneticGroup().getProductivity())
                            .setAge(rationEntity.getGeneticGroup().getAge())
                            .setType(rationEntity.getGeneticGroup().getType())
                            .setWeight(rationEntity.getGeneticGroup().getWeight()));
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
    public GeneticGroupModelMapper() {
        super.createTypeMap(GeneticGroupEntity.class, GeneticGroup.class).addMappings(mapping -> {
            mapping.when(Conditions.isNotNull()).using(rationEntityListToRationListConverter()).map(GeneticGroupEntity::getRations, GeneticGroup::setRations);
        });
        super.createTypeMap(GeneticGroup.class, GeneticGroupEntity.class).addMappings(mapping -> {
            mapping.skip(GeneticGroupEntity::setRations);
        });
        super.createTypeMap(GeneticGroupEntity.class, GeneticGroupEntity.class).addMappings(mapping -> {
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getType, GeneticGroupEntity::setType);
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getProductivity, GeneticGroupEntity::setProductivity);
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getWeight, GeneticGroupEntity::setWeight);
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getGeneticWeight, GeneticGroupEntity::setGeneticWeight);
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getAge, GeneticGroupEntity::setAge);
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getGeneticGroupId, GeneticGroupEntity::setGeneticGroupId);
            mapping.when(Conditions.isNotNull()).using(nutrientsEntityNutrientsEntityConverter()).map(GeneticGroupEntity::getNutrients, GeneticGroupEntity::setNutrients);
            mapping.when(Conditions.isNotNull()).map(GeneticGroupEntity::getRations, GeneticGroupEntity::setRations);

        });
    }
}
