package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import org.springframework.stereotype.Component;

@Component
public class AnimalPassportModelMapper extends MobileFarmModelMapper{
    public AnimalPassportModelMapper(){
        super.createTypeMap(AnimalPassportEntity.class, AnimalPassport.class).addMappings(mapping -> {
           mapping.map(AnimalPassportEntity::getCreatedDate, AnimalPassport::setCreatedDate);
           mapping.map(AnimalPassportEntity::getId, AnimalPassport::setId);
           mapping.map(AnimalPassportEntity::getType, AnimalPassport::setType);
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
        });
    }
}
