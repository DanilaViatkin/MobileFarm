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
            mapping.using(organizationEntityNameStringConverter()).map(FarmEntity::getOrganization, Farm::setOrganizationName);
        });
    }

    public Converter<List<AnimalPassportEntity>, Long> FarmEntityAnimalAmount() {
        return context -> Objects.nonNull(context.getSource()) ? context.getSource().size() : 0L;
    }

    private Converter<OrganizationEntity, String> organizationEntityNameStringConverter(){
        return context -> context.getSource().getName();
    }
}
