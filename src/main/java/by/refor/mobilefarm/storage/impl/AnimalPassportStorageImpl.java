package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.exception.custom.NotFoundEntityException;
import by.refor.mobilefarm.mapper.AnimalPassportModelMapper;
import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import by.refor.mobilefarm.repo.AnimalPassportRepository;
import by.refor.mobilefarm.repo.FarmRepository;
import by.refor.mobilefarm.repo.FeedGroupRepository;
import by.refor.mobilefarm.storage.AnimalPassportStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Component
public class AnimalPassportStorageImpl implements AnimalPassportStorage {

    private final AnimalPassportRepository animalPassportRepository;
    private final AnimalPassportModelMapper animalPassportModelMapper;

    private final FeedGroupRepository feedGroupRepository;
    private final FarmRepository farmRepository;

    @Autowired
    public AnimalPassportStorageImpl(AnimalPassportRepository animalPassportRepository,
                                     AnimalPassportModelMapper animalPassportModelMapper,
                                     FeedGroupRepository feedGroupRepository,
                                     FarmRepository farmRepository){
        this.animalPassportRepository = animalPassportRepository;
        this.animalPassportModelMapper = animalPassportModelMapper;
        this.feedGroupRepository = feedGroupRepository;
        this.farmRepository = farmRepository;
    }
    @Override
    public AnimalPassport getAnimalPassportByExternalId(String id) {
        //TODO: не работает маппинг родителей
        AnimalPassportEntity ape = animalPassportRepository.findByExternalId(id).orElseThrow(() -> new NotFoundEntityException("animal.passport.not.found", id));
        AnimalPassport ap = animalPassportModelMapper.map(ape, AnimalPassport.class);
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
    @Transactional
    public AnimalPassport createAnimalPassport(AnimalPassport animalPassport, Long farmId, Long farmOriginalOwnerId,
                                               String fatherExternalId, String motherExternalId, Long geneticGroupId) {
        AnimalPassportEntity ape = animalPassportModelMapper.map(animalPassport, AnimalPassportEntity.class);
        animalPassportRepository.findByExternalId(animalPassport.getExternalId()).ifPresent(s -> {
            throw new NotFoundEntityException("animal.passport.already.exist", animalPassport.getExternalId());
        });
        if(Objects.nonNull(farmOriginalOwnerId)){
            ape.setOriginalOwnerFarm(farmRepository.findById(farmOriginalOwnerId).orElseThrow(() -> new NotFoundEntityException("farm.not.found", farmOriginalOwnerId)));
        }
        if(Objects.nonNull(fatherExternalId)){
            ape.setFather(animalPassportRepository.findByExternalId(fatherExternalId).orElseThrow(() -> new NotFoundEntityException("animal.passport.not.found", fatherExternalId)));
        }
        if(Objects.nonNull(motherExternalId)){
            ape.setMother(animalPassportRepository.findByExternalId(motherExternalId).orElseThrow(() -> new NotFoundEntityException("animal.passport.not.found", motherExternalId)));
        }
        if(Objects.nonNull(geneticGroupId)){
            ape.setFeedGroup(feedGroupRepository.findById(geneticGroupId).orElseThrow(() -> new NotFoundEntityException("genetic.group.not.found", geneticGroupId)));
        }
        ape.setFarm(farmRepository.findById(farmId).orElseThrow(() -> new NotFoundEntityException("farm.not.found", farmId)));
        ape.setCreatedDate(OffsetDateTime.now());

        AnimalPassportEntity createdApe = animalPassportRepository.save(ape);

        return animalPassportModelMapper.map(createdApe, AnimalPassport.class);
    }

    @Override
    @Transactional
    public AnimalPassport updateAnimalPassportByExternalId(AnimalPassport animalPassport, String externalId, Long farmId, Long farmOriginalOwnerId, Long geneticGroupId) {
        AnimalPassportEntity ape = animalPassportRepository.findByExternalId(externalId).orElseThrow(() -> new NotFoundEntityException("animal.passport.not.found", externalId));
        AnimalPassportEntity frontAP = animalPassportModelMapper.map(animalPassport, AnimalPassportEntity.class);
        animalPassportModelMapper.map(frontAP, ape);

        if (Objects.nonNull(farmId)){
            ape.setFarm(farmRepository.findById(farmId).orElseThrow(() -> new NotFoundEntityException("farm.not.found", farmId)));
        }
        if (Objects.nonNull(farmOriginalOwnerId)){
            ape.setOriginalOwnerFarm(farmRepository.findById(farmOriginalOwnerId).orElseThrow(() -> new NotFoundEntityException("farm.not.found", farmOriginalOwnerId)));
        }
        if (Objects.nonNull(geneticGroupId)){
            ape.setFeedGroup(feedGroupRepository.findById(geneticGroupId).orElseThrow(() -> new NotFoundEntityException("genetic.group.not.found", geneticGroupId)));
        }

        AnimalPassportEntity updatedApe = animalPassportRepository.save(ape);

        return animalPassportModelMapper.map(updatedApe, AnimalPassport.class);
    }

    @Override
    @Transactional
    public void deleteAnimalPassportById(Long animalPassportId) {
        AnimalPassportEntity ape = animalPassportRepository.findById(animalPassportId).orElseThrow(() -> new NotFoundEntityException("animal.passport.id.not.found", animalPassportId));
        animalPassportRepository.delete(ape);
    }
}
