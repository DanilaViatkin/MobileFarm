package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.mapper.GeneticGroupModelMapper;
import by.refor.mobilefarm.model.bo.GeneticGroup;
import by.refor.mobilefarm.model.entity.GeneticGroupEntity;
import by.refor.mobilefarm.repo.GeneticGroupRepository;
import by.refor.mobilefarm.storage.GeneticGroupStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneticGroupStorageImpl implements GeneticGroupStorage {
    private final GeneticGroupRepository geneticGroupRepository;
    private final GeneticGroupModelMapper geneticGroupModelMapper;
    @Autowired
    public GeneticGroupStorageImpl(GeneticGroupRepository geneticGroupRepository,
                                   GeneticGroupModelMapper geneticGroupModelMapper){
        this.geneticGroupRepository = geneticGroupRepository;
        this.geneticGroupModelMapper = geneticGroupModelMapper;
    }
    @Override
    public GeneticGroup getGeneticGroupByParams(GeneticGroup geneticGroup) {
        GeneticGroupEntity geneticGroupEntity = geneticGroupRepository
                .findByTypeAndProductivityAndWeightAndGeneticWeightAndAge(geneticGroup.getType(),
                        geneticGroup.getProductivity(),
                        geneticGroup.getWeight(),
                        geneticGroup.getGeneticWeight(),
                        geneticGroup.getAge());

        return geneticGroupModelMapper.map(geneticGroupEntity, GeneticGroup.class);
    }

    @Override
    public List<GeneticGroup> getAllGeneticGroups() {
        return geneticGroupModelMapper.mapList(geneticGroupRepository.findAll(), GeneticGroup.class);
    }

    @Override
    public GeneticGroup createGeneticGroup(GeneticGroup geneticGroup) {
        GeneticGroupEntity gge = geneticGroupModelMapper.map(geneticGroup, GeneticGroupEntity.class);
        gge = geneticGroupRepository
                .save(gge);
        return geneticGroupModelMapper.map(gge,
                GeneticGroup.class);
    }

    @Override
    public GeneticGroup updateGeneticGroupById(Long id, GeneticGroup geneticGroup) {
        GeneticGroupEntity gge = geneticGroupRepository.findById(id).get();
        GeneticGroupEntity frontGroup = geneticGroupModelMapper.map(geneticGroup, GeneticGroupEntity.class);
        geneticGroupModelMapper.map(frontGroup, gge);
        gge = geneticGroupRepository.save(gge);
        return geneticGroupModelMapper.map(gge,
                GeneticGroup.class);
    }
}
