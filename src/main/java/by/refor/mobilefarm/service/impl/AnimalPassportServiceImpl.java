package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.service.AnimalPassportService;
import by.refor.mobilefarm.storage.AnimalPassportStorage;
import by.refor.mobilefarm.storage.FarmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnimalPassportServiceImpl implements AnimalPassportService {

    private final AnimalPassportStorage animalPassportStorage;
    private final FarmStorage farmStorage;

    @Autowired
    public AnimalPassportServiceImpl(AnimalPassportStorage animalPassportStorage,
                                     FarmStorage farmStorage){
        this.animalPassportStorage = animalPassportStorage;
        this.farmStorage = farmStorage;
    }
    @Override
    public AnimalPassport getAnimalPassportByExternalId(String externalId) {
        return animalPassportStorage.getAnimalPassportByExternalId(externalId);
    }

    @Override
    public List<AnimalPassport> getAnimalPassportsByFarmId(Long farmId) {
        return animalPassportStorage.getAnimalPassportsByFarmId(farmId);
    }

    @Override
    public List<AnimalPassport> getAnimalPassportsByOrganizationId(Long farmId) {
        return animalPassportStorage.getAnimalPassportsByOrganizationId(farmId);
    }

    @Override
    public AnimalPassport createAnimalPassport(AnimalPassport animalPassport, Long farmId, Long farmOriginalOwnerId, String fatherExternalId, String motherExternalId, Long geneticGroupId) {
        return animalPassportStorage.createAnimalPassport(animalPassport, farmId, farmOriginalOwnerId, fatherExternalId, motherExternalId, geneticGroupId);
    }

    @Override
    public     AnimalPassport updateAnimalPassportByExternalId(AnimalPassport animalPassport, String externalId,Long farmId, Long farmOriginalOwnerId, Long geneticGroupId) {
        return animalPassportStorage.updateAnimalPassportByExternalId(animalPassport, externalId, farmId, farmOriginalOwnerId, geneticGroupId);
    }

    @Override
    public void deleteAnimalPassportById(Long animalPassportId) {
        animalPassportStorage.deleteAnimalPassportById(animalPassportId);
    }
}
