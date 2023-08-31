package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.OwnerModelMapper;
import by.refor.mobilefarm.model.bo.Owner;
import by.refor.mobilefarm.model.entity.OwnerEntity;
import by.refor.mobilefarm.repo.OwnerRepository;
import by.refor.mobilefarm.storage.OwnerStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerStorageImpl implements OwnerStorage {
    private final OwnerRepository ownerRepository;
    private final OwnerModelMapper ownerModelMapper;

    @Autowired
    public OwnerStorageImpl(OwnerRepository ownerRepository,
                            OwnerModelMapper ownerModelMapper){
        this.ownerRepository = ownerRepository;
        this.ownerModelMapper = ownerModelMapper;
    }
    @Override
    public Owner createOwner(Owner owner) {
        return ownerModelMapper.map(ownerRepository.save(ownerModelMapper.map(owner, OwnerEntity.class)), Owner.class);
    }
}
