package by.refor.mobilefarm.mapper;

import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.model.bo.Owner;
import by.refor.mobilefarm.model.entity.OwnerEntity;
import org.springframework.stereotype.Component;

@Component
public class OwnerModelMapper extends MobileFarmModelMapper{
    public OwnerModelMapper(){
        super.createTypeMap(OwnerEntity.class, Owner.class).addMappings(mapping -> {
           mapping.map(OwnerEntity::getFirstName, Owner::setFirstName);
           mapping.map(OwnerEntity::getLastName, Owner::setLastName);
           mapping.map(OwnerEntity::getMiddleName, Owner::setMiddleName);
        });
    }
}
