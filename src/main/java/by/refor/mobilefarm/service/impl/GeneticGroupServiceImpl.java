package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.GeneticGroup;
import by.refor.mobilefarm.service.GeneticGroupService;
import by.refor.mobilefarm.storage.GeneticGroupStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneticGroupServiceImpl implements GeneticGroupService {
    private final GeneticGroupStorage geneticGroupStorage;

    @Autowired
    public GeneticGroupServiceImpl(GeneticGroupStorage geneticGroupStorage){
        this.geneticGroupStorage = geneticGroupStorage;
    }
    @Override
    public GeneticGroup getGeneticGroupByParams(GeneticGroup geneticGroup) {
        return geneticGroupStorage.getGeneticGroupByParams(geneticGroup);
    }

    @Override
    public List<GeneticGroup> getAllGeneticGroups() {
        return geneticGroupStorage.getAllGeneticGroups();
    }

    @Override
    public GeneticGroup createGeneticGroup(GeneticGroup geneticGroup) {
        return geneticGroupStorage.createGeneticGroup(geneticGroup);
    }

    @Override
    public GeneticGroup updateGeneticGroupById(Long id, GeneticGroup geneticGroup) {
        return geneticGroupStorage.updateGeneticGroupById(id, geneticGroup);
    }

    @Override
    public void deleteGeneticGroupById(Long geneticGroupId) {
        geneticGroupStorage.deleteGeneticGroupById(geneticGroupId);
    }
}
