package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import org.modelmapper.Conditions;
import org.springframework.stereotype.Component;

@Component
public class NutrientsModelMapper  extends MobileFarmModelMapper{
    public NutrientsModelMapper(){
        super.createTypeMap(Nutrients.class, NutrientsEntity.class).addMappings(mapping -> {
           mapping.when(Conditions.isNotNull()).map(Nutrients::getNutrientsId, NutrientsEntity::setNutrientsId);
        });
    }
}
