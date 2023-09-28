package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import by.refor.mobilefarm.model.entity.FarmEntity;
import by.refor.mobilefarm.model.entity.OrganizationEntity;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class FarmModelMapper extends MobileFarmModelMapper{
    public FarmModelMapper(){
        super.createTypeMap(FarmEntity.class, Farm.class).addMappings(mapping -> {
            mapping.using(FarmEntityAnimalAmount()).map(FarmEntity::getAnimalPassports, Farm::setAnimalAmount);
            mapping.using(animalPassportBullAmountConverter()).map(FarmEntity::getAnimalPassports, Farm::setBullAmount);
            mapping.using(animalPassportCowAmountConverter()).map(FarmEntity::getAnimalPassports, Farm::setCowAmount);
            mapping.using(animalPassportHeiferAmountConverter()).map(FarmEntity::getAnimalPassports, Farm::setHeiferAmount);
            mapping.using(animalPassportNetelAmountConverter()).map(FarmEntity::getAnimalPassports, Farm::setNetelAmount);
            mapping.using(organizationEntityNameStringConverter()).map(FarmEntity::getOrganization, Farm::setOrganizationName);
        });
    }

    public Converter<List<AnimalPassportEntity>, Long> FarmEntityAnimalAmount() {
        return context -> Objects.nonNull(context.getSource()) ? context.getSource().size() : 0L;
    }

    private Converter<OrganizationEntity, String> organizationEntityNameStringConverter(){
        return context -> context.getSource().getName();
    }

    public Converter<List<AnimalPassportEntity>, Long> animalPassportBullAmountConverter() {
        return context -> Objects.nonNull(context.getSource()) ? context.getSource().stream().filter(animalPassport -> animalPassport.getType().equals("Бычок")).count() : 0;
    }
    public Converter<List<AnimalPassportEntity>, Long> animalPassportCowAmountConverter() {
        return context -> Objects.nonNull(context.getSource()) ? context.getSource().stream().filter(animalPassport -> animalPassport.getType().equals("Корова")).count() : 0;
    }
    public Converter<List<AnimalPassportEntity>, Long> animalPassportHeiferAmountConverter() {
        return context -> Objects.nonNull(context.getSource()) ? context.getSource().stream().filter(animalPassport -> animalPassport.getType().equals("Телочка")).count() : 0;
    }
    public Converter<List<AnimalPassportEntity>, Long> animalPassportNetelAmountConverter() {
        return context -> Objects.nonNull(context.getSource()) ? context.getSource().stream().filter(animalPassport -> animalPassport.getType().equals("Нетель")).count() : 0;
    }

}
