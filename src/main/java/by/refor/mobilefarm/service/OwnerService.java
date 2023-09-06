package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Owner;

public interface OwnerService {
    Owner createOwner(Owner owner);
    void deleteOwner(Long ownerId);
}
