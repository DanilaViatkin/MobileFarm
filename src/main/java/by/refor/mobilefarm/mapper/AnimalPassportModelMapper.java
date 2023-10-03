package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import by.refor.mobilefarm.model.entity.FarmEntity;
import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AnimalPassportModelMapper extends MobileFarmModelMapper{
    @Autowired
    private FeedGroupModelMapper feedGroupModelMapper;
    @Autowired
    private FarmModelMapper farmModelMapper;

    private Converter<FeedGroupEntity, FeedGroup> FeedGroupEntityFeedGroupConverter(){
        return context -> {
            FeedGroup gg = feedGroupModelMapper.map(context.getSource(), FeedGroup.class);
            return gg;
        };
    }

    private Converter<FarmEntity, Farm> farmEntityFarmConverter(){
        return context -> farmModelMapper.map(context.getSource(), Farm.class);
    }

    private Converter<AnimalPassportEntity, String> motherExternalIdConverter(){
        return context -> Objects.nonNull(context.getSource().getMother()) ? context.getSource().getMother().getExternalId() : null;
    }
    private Converter<AnimalPassportEntity, String> motherNicknameConverter(){
        return context -> Objects.nonNull(context.getSource().getMother()) ? context.getSource().getMother().getNickname() : null;
    }
    private Converter<AnimalPassportEntity, String> fatherExternalIdConverter(){
        return context -> Objects.nonNull(context.getSource().getFather()) ? context.getSource().getFather().getExternalId() : null;
    }
    private Converter<AnimalPassportEntity, String> fatherNicknameConverter(){
        return context -> Objects.nonNull(context.getSource().getFather()) ? context.getSource().getFather().getNickname() : null;
    }


    public AnimalPassportModelMapper(){
        super.createTypeMap(AnimalPassportEntity.class, AnimalPassport.class).addMappings(mapping -> {
           mapping.map(AnimalPassportEntity::getCreatedDate, AnimalPassport::setCreatedDate);
           mapping.map(AnimalPassportEntity::getExternalId, AnimalPassport::setExternalId);
           mapping.map(AnimalPassportEntity::getNickname, AnimalPassport::setNickname);
           mapping.map(AnimalPassportEntity::getSex, AnimalPassport::setSex);
           mapping.map(AnimalPassportEntity::getBreed, AnimalPassport::setBreed);
           mapping.map(AnimalPassportEntity::getDeathDate, AnimalPassport::setDeathDate);
           mapping.map(AnimalPassportEntity::getBreedingAnimal, AnimalPassport::setBreedingAnimal);
           mapping.map(AnimalPassportEntity::getWeight, AnimalPassport::setWeight);
           mapping.map(AnimalPassportEntity::getProductionType, AnimalPassport::setProductionType);
           mapping.map(AnimalPassportEntity::getAverageProductivity, AnimalPassport::setAverageProductivity);
           mapping.map(AnimalPassportEntity::getGeneticProductivity, AnimalPassport::setGeneticProductivity);
           mapping.map(AnimalPassportEntity::getTreatmentStartDate, AnimalPassport::setTreatmentStartDate);
           mapping.map(AnimalPassportEntity::getTreatmentEndDate, AnimalPassport::setTreatmentEndDate);
           mapping.map(AnimalPassportEntity::getInseminationDate, AnimalPassport::setInseminationDate);
           mapping.map(AnimalPassportEntity::getLactationStartDate, AnimalPassport::setLactationStartDate);
           mapping.map(AnimalPassportEntity::getDryPeriodStartDate, AnimalPassport::setLactationStartDate);
           mapping.map(AnimalPassportEntity::getWeightGrowth, AnimalPassport::setWeightGrowth);
           mapping.map(AnimalPassportEntity::getBirthDate, AnimalPassport::setBirthDate);
            mapping.map(AnimalPassportEntity::getOriginCountry, AnimalPassport::setOriginCountry);
            mapping.map(AnimalPassportEntity::getExternalIdInOriginCountry, AnimalPassport::setExternalIdInOriginCountry);
            mapping.map(AnimalPassportEntity::getFormed, AnimalPassport::setFormed);
            mapping.map(AnimalPassportEntity::getFormingDate, AnimalPassport::setFormingDate);
            mapping.map(AnimalPassportEntity::getFormerName, AnimalPassport::setFormerName);
           mapping.when(Conditions.isNotNull()).using(motherExternalIdConverter()).map(AnimalPassportEntity::getMother, AnimalPassport::setMotherExternalId);
           mapping.when(Conditions.isNotNull()).using(fatherExternalIdConverter()).map(AnimalPassportEntity::getFather, AnimalPassport::setFatherExternalId);
           mapping.when(Conditions.isNotNull()).using(motherNicknameConverter()).map(AnimalPassportEntity::getMother, AnimalPassport::setMotherNickname);
           mapping.when(Conditions.isNotNull()).using(fatherNicknameConverter()).map(AnimalPassportEntity::getFather, AnimalPassport::setFatherNickname);
           mapping.when(Conditions.isNotNull()).using(farmEntityFarmConverter()).map(AnimalPassportEntity::getFarm, AnimalPassport::setFarm);
           mapping.when(Conditions.isNotNull()).using(FeedGroupEntityFeedGroupConverter()).map(AnimalPassportEntity::getFeedGroup, AnimalPassport::setFeedGroup);
        });

        super.createTypeMap(AnimalPassportEntity.class, AnimalPassportEntity.class).addMappings(mapping -> {
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getCreatedDate, AnimalPassportEntity::setCreatedDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getExternalId, AnimalPassportEntity::setExternalId);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getNickname, AnimalPassportEntity::setNickname);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getSex, AnimalPassportEntity::setSex);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getBreed, AnimalPassportEntity::setBreed);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getDeathDate, AnimalPassportEntity::setDeathDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getBreedingAnimal, AnimalPassportEntity::setBreedingAnimal);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getWeight, AnimalPassportEntity::setWeight);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getProductionType, AnimalPassportEntity::setProductionType);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getAverageProductivity, AnimalPassportEntity::setAverageProductivity);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getGeneticProductivity, AnimalPassportEntity::setGeneticProductivity);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getTreatmentStartDate, AnimalPassportEntity::setTreatmentStartDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getTreatmentEndDate, AnimalPassportEntity::setTreatmentEndDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getInseminationDate, AnimalPassportEntity::setInseminationDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getLactationStartDate, AnimalPassportEntity::setLactationStartDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getDryPeriodStartDate, AnimalPassportEntity::setLactationStartDate);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getWeightGrowth, AnimalPassportEntity::setWeightGrowth);
           mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getBirthDate, AnimalPassportEntity::setBirthDate);

            mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getOriginCountry, AnimalPassportEntity::setOriginCountry);
            mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getExternalIdInOriginCountry, AnimalPassportEntity::setExternalIdInOriginCountry);
            mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getFormed, AnimalPassportEntity::setFormed);
            mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getFormingDate, AnimalPassportEntity::setFormingDate);
            mapping.when(Conditions.isNotNull()).map(AnimalPassportEntity::getFormerName, AnimalPassportEntity::setFormerName);


            mapping.skip(AnimalPassportEntity::setMother);
           mapping.skip(AnimalPassportEntity::setFather);
           mapping.skip(AnimalPassportEntity::setFarm);
           mapping.skip(AnimalPassportEntity::setOriginalOwnerFarm);
           mapping.skip(AnimalPassportEntity::setFeedGroup);
           mapping.skip(AnimalPassportEntity::setAnimalPassportId);
        });
    }
}
