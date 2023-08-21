package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.AnimalPassport;

import java.util.List;

public interface AnimalPassportStorage {
    AnimalPassport getAnimalPassportByExternalId(String externalId);
    List<AnimalPassport> getAnimalPassportsByFarmId(Long farmId);
    AnimalPassport createAnimalPassport(AnimalPassport animalPassport, Long farmId, Long farmOriginalOwnerId, Long fatherId, Long motherId, Long geneticGroupId);
    AnimalPassport updateAnimalPassportByExternalId(AnimalPassport animalPassport, String externalId,Long farmId, Long farmOriginalOwnerId, Long geneticGroupId);
}
