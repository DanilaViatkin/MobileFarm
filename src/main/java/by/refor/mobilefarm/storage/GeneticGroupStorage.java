package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.GeneticGroup;

import java.util.List;

public interface GeneticGroupStorage {
    GeneticGroup getGeneticGroupByParams(GeneticGroup geneticGroup);
    List<GeneticGroup> getAllGeneticGroups();
    GeneticGroup createGeneticGroup(GeneticGroup geneticGroup);
    GeneticGroup updateGeneticGroupById(Long id,GeneticGroup geneticGroup);

    GeneticGroup getGeneticGroupById(Long geneticGroupId);
}
