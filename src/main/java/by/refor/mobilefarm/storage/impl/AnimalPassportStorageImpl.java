package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.AnimalPassportModelMapper;
import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import by.refor.mobilefarm.model.entity.GeneticGroupEntity;
import by.refor.mobilefarm.repo.AnimalPassportRepository;
import by.refor.mobilefarm.repo.FarmRepository;
import by.refor.mobilefarm.repo.GeneticGroupRepository;
import by.refor.mobilefarm.storage.AnimalPassportStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Component
public class AnimalPassportStorageImpl implements AnimalPassportStorage {

    private final AnimalPassportRepository animalPassportRepository;
    private final AnimalPassportModelMapper animalPassportModelMapper;

    private final GeneticGroupRepository geneticGroupRepository;
    private final FarmRepository farmRepository;

    @Autowired
    public AnimalPassportStorageImpl(AnimalPassportRepository animalPassportRepository,
                                     AnimalPassportModelMapper animalPassportModelMapper,
                                     GeneticGroupRepository geneticGroupRepository,
                                     FarmRepository farmRepository){
        this.animalPassportRepository = animalPassportRepository;
        this.animalPassportModelMapper = animalPassportModelMapper;
        this.geneticGroupRepository = geneticGroupRepository;
        this.farmRepository = farmRepository;
    }
    @Override
    public AnimalPassport getAnimalPassportByExternalId(String id) {
        //TODO: не работает маппинг родителей
        AnimalPassportEntity ape = animalPassportRepository.findByExternalId(id);
        AnimalPassport ap = animalPassportModelMapper.map(ape, AnimalPassport.class);
        System.out.println("me");
        return ap;
    }

    @Override
    public List<AnimalPassport> getAnimalPassportsByFarmId(Long farmId) {
        return animalPassportModelMapper.mapList(animalPassportRepository.findByFarm_FarmId(farmId), AnimalPassport.class);
    }

    @Override
    public List<AnimalPassport> getAnimalPassportsByOrganizationId(Long organizationId) {
        return animalPassportModelMapper.mapList(animalPassportRepository.findByOrganizationId(organizationId), AnimalPassport.class);
    }

    @Override
    public AnimalPassport createAnimalPassport(AnimalPassport animalPassport, Long farmId, Long farmOriginalOwnerId, Long fatherId, Long motherId, Long geneticGroupId) {
        AnimalPassportEntity ape = animalPassportModelMapper.map(animalPassport, AnimalPassportEntity.class);
        //TODO: проверка существует ли ферма по данному ид если нет то выбросить ошибку
        // проверка паспорта по external_id
        if(Objects.nonNull(farmOriginalOwnerId)){
            ape.setOriginalOwnerFarm(farmRepository.findById(farmOriginalOwnerId).get());
        }
        if(Objects.nonNull(fatherId)){
            ape.setFather(animalPassportRepository.findById(fatherId).get());
        }
        if(Objects.nonNull(motherId)){
            ape.setMother(animalPassportRepository.findById(motherId).get());
        }
        if(Objects.nonNull(geneticGroupId)){
            ape.setGeneticGroup(geneticGroupRepository.findById(geneticGroupId).get());
        }
        ape.setFarm(farmRepository.findById(farmId).get());
        ape.setCreatedDate(OffsetDateTime.now());

        AnimalPassportEntity createdApe = animalPassportRepository.save(ape);

        return animalPassportModelMapper.map(createdApe, AnimalPassport.class);
    }

    @Override
    public AnimalPassport updateAnimalPassportByExternalId(AnimalPassport animalPassport, String externalId, Long farmId, Long farmOriginalOwnerId, Long geneticGroupId) {
        AnimalPassportEntity ape = animalPassportRepository.findByExternalId(externalId);
        AnimalPassportEntity frontAP = animalPassportModelMapper.map(animalPassport, AnimalPassportEntity.class);
        animalPassportModelMapper.map(frontAP, ape);
        if (Objects.nonNull(farmId)){
            ape.setFarm(farmRepository.findById(farmId).get());
        }
        if (Objects.nonNull(farmOriginalOwnerId)){
            ape.setOriginalOwnerFarm(farmRepository.findById(farmOriginalOwnerId).get());
        }
        if (Objects.nonNull(geneticGroupId)){
            ape.setGeneticGroup(geneticGroupRepository.findById(geneticGroupId).get());
        }

        AnimalPassportEntity updatedApe = animalPassportRepository.save(ape);

        return animalPassportModelMapper.map(updatedApe, AnimalPassport.class);
    }


}
