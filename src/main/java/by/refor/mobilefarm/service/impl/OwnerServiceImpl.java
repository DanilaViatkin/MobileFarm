package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.Owner;
import by.refor.mobilefarm.service.OwnerService;
import by.refor.mobilefarm.storage.OwnerStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerStorage ownerStorage;

    @Autowired
    public OwnerServiceImpl(OwnerStorage ownerStorage){
        this.ownerStorage = ownerStorage;
    }
    @Override
    public Owner createOwner(Owner owner) {
        return ownerStorage.createOwner(owner);
    }

    @Override
    public void deleteOwner(Long ownerId) {
        ownerStorage.deleteOwner(ownerId);
    }
}
