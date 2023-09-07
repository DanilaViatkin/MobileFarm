package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/farms")
public class FarmController {
    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService){
        this.farmService = farmService;
    }

    @GetMapping("/gln/{gln}")
    public Farm getFarmByGLN(@PathVariable String gln){
        return farmService.getFarmByGLN(gln);
    }

    @GetMapping
    public List<Farm> getFarmsByOrganizationId(@RequestParam("organization_id") Long organizationId){
        return farmService.getFarmsByOrganizationId(organizationId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Farm createFarm(@RequestBody Farm farm,
                           @RequestParam("organization_id") Long organizationId){
        return farmService.createFarm(farm, organizationId);
    }

    @PatchMapping("/{gln}")
    @ResponseStatus(HttpStatus.OK)
    public Farm updateFarmById(@RequestBody Farm farm,
                               @PathVariable String gln,
                               @RequestParam("organization_id") Long organizationId,
                               @RequestParam("owner_id") Long ownerId){
        return farmService.updateFarmById(farm, gln, organizationId, ownerId);
    }

    @DeleteMapping("/{farmId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFarmById(@PathVariable Long farmId){
        farmService.deleteFarmById(farmId);
    }
}
