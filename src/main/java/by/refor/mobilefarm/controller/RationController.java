package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.dto.CalculatedRation;
import by.refor.mobilefarm.service.RationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rations")
public class RationController {
    private final RationService rationService;
    @Autowired
    public RationController(RationService rationService){
        this.rationService = rationService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CalculatedRation> calculateRation(@RequestBody Ration ration,
                                                  @RequestParam("genetic_group_id") Long geneticGroupId){
        return rationService.calculateRation(ration, geneticGroupId);
    }

    @DeleteMapping("/{rationId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRationById(@PathVariable Long rationId){
        rationService.deleteRationById(rationId);
    }

    @GetMapping
    public List<Ration> getAll(){
        return rationService.getAll();
    }
}
