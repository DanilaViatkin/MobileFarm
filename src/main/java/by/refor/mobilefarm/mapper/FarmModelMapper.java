package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.model.entity.FarmEntity;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

@Component
public class FarmModelMapper extends MobileFarmModelMapper{
    public FarmModelMapper(){
        super.createTypeMap(FarmEntity.class, Farm.class).addMappings(mapping -> {
            mapping.using(FarmEntityAnimalAmount()).map(src -> src, Farm::setAnimalAmount);
        });
    }

    public Converter<FarmEntity, Long> FarmEntityAnimalAmount(){
        return src -> Long.valueOf(src.getSource().getAnimalPassports().size());
    }
}
