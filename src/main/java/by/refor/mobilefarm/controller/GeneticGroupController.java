package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.GeneticGroup;
import by.refor.mobilefarm.service.GeneticGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/geneticgroup")
public class GeneticGroupController {
    private final GeneticGroupService geneticGroupService;

    @Autowired
    public GeneticGroupController(GeneticGroupService geneticGroupService){
        this.geneticGroupService = geneticGroupService;
    }

    @GetMapping(value = "/specificgroup")
    @ResponseStatus(HttpStatus.OK)
    public GeneticGroup getGeneticGroupByParams(@RequestBody GeneticGroup geneticGroup){
        return geneticGroupService.getGeneticGroupByParams(geneticGroup);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GeneticGroup> getAllGeneticGroups(){
        return geneticGroupService.getAllGeneticGroups();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneticGroup createGeneticGroup(@RequestBody GeneticGroup geneticGroup){
        return geneticGroupService.createGeneticGroup(geneticGroup);
    }

    @PatchMapping(value = "/{geneticGroupId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneticGroup updateGeneticGroupById(@RequestBody GeneticGroup geneticGroup,
                                               @PathVariable Long geneticGroupId){
        return geneticGroupService.updateGeneticGroupById(geneticGroupId, geneticGroup);
    }
}
