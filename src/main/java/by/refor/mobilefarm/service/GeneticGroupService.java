package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.GeneticGroup;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GeneticGroupService {
    GeneticGroup getGeneticGroupByParams(GeneticGroup geneticGroupService);
    List<GeneticGroup> getAllGeneticGroups();
    GeneticGroup createGeneticGroup(GeneticGroup geneticGroup);
    GeneticGroup updateGeneticGroupById(Long id,GeneticGroup geneticGroup);
    void deleteGeneticGroupById(Long geneticGroupId);
}
