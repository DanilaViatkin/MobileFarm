package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.AnimalPassport;

import java.util.List;

public interface AnimalPassportStorage {
    AnimalPassport getAnimalPassportByExternalId(String externalId);
    List<AnimalPassport> getAnimalPassportsByFarmId(Long farmId);
    List<AnimalPassport> getAnimalPassportsByOrganizationId(Long farmId);
    AnimalPassport createAnimalPassport(AnimalPassport animalPassport, Long farmId, Long farmOriginalOwnerId, String fatherExternalId, String motherExternalId, Long geneticGroupId);
    AnimalPassport updateAnimalPassportByExternalId(AnimalPassport animalPassport, String externalId,Long farmId, Long farmOriginalOwnerId, Long geneticGroupId);
    void deleteAnimalPassportById(Long animalPassportId);

}
