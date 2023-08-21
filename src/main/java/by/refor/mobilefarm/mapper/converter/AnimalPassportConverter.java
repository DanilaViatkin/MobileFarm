package by.refor.mobilefarm.mapper.converter;

import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class AnimalPassportConverter implements EntityConvertor<AnimalPassportEntity, AnimalPassport> {
    @Override
    public AnimalPassport fromEntityToDto(AnimalPassportEntity entity) {
        AnimalPassport animalPassport = new AnimalPassport();
        return animalPassport;
    }

    @Override
    public AnimalPassportEntity fromDtoToEntity(AnimalPassport dto) {

        return null;
    }

    @Override
    public AnimalPassportEntity fillEntityByDto(AnimalPassport dto, AnimalPassportEntity entity) {
        if (Objects.nonNull(dto.getExternalId())){
            entity.setExternalId(dto.getExternalId());
        }
        if (Objects.nonNull(dto.getNickname())){
            entity.setNickname(dto.getNickname());
        }
        if (Objects.nonNull(dto.getSex())){
            entity.setSex(dto.getSex());
        }
        if (Objects.nonNull(dto.getBreed())){
            entity.setBreed(dto.getBreed());
        }
        if (Objects.nonNull(dto.getDeathDate())){
            entity.setDeathDate(dto.getDeathDate());
        }
        if (Objects.nonNull(dto.getBreedingAnimal())){
            entity.setBreedingAnimal(dto.getBreedingAnimal());
        }
        if (Objects.nonNull(dto.getWeight())){
            entity.setWeight(BigDecimal.valueOf(dto.getWeight()));
        }
        if (Objects.nonNull(dto.getProductionType())){
            entity.setProductionType(dto.getProductionType());
        }
        if (Objects.nonNull(dto.getAverageProductivity())){
            entity.setAverageProductivity(BigDecimal.valueOf(dto.getAverageProductivity()));
        }
        if (Objects.nonNull(dto.getGeneticProductivity())){
            entity.setGeneticProductivity(BigDecimal.valueOf(dto.getGeneticProductivity()));
        }
        if (Objects.nonNull(dto.getTreatmentStartDate())){
            entity.setTreatmentStartDate(dto.getTreatmentStartDate());
        }
        if (Objects.nonNull(dto.getTreatmentEndDate())){
            entity.setTreatmentEndDate(dto.getTreatmentEndDate());
        }
        if (Objects.nonNull(dto.getInseminationDate())){
            entity.setInseminationDate(dto.getInseminationDate());
        }
        if (Objects.nonNull(dto.getLactationStartDate())){
            entity.setLactationStartDate(dto.getLactationStartDate());
        }
        if (Objects.nonNull(dto.getDryPeriodStartDate())){
            entity.setDryPeriodStartDate(dto.getDryPeriodStartDate());
        }
        if (Objects.nonNull(dto.getWeightGrowth())){
            entity.setWeightGrowth(BigDecimal.valueOf(dto.getWeightGrowth()));
        }
        if (Objects.nonNull(dto.getBirthDate())){
            entity.setBirthDate(dto.getBirthDate());
        }
        return entity;
    }
}
