package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.service.AnimalPassportService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal_passports")
public class AnimalPassportController {
    private final AnimalPassportService animalPassportService;

    @Autowired
    public AnimalPassportController(AnimalPassportService animalPassportService){
        this.animalPassportService = animalPassportService;
    }

    @GetMapping("/external_id/{externalId}")
    public AnimalPassport getAnimalPassportByExternalId(@PathVariable String externalId){
        return animalPassportService.getAnimalPassportByExternalId(externalId);
    }

    @GetMapping("/farm_id/{farmId}")
    public List<AnimalPassport> getAnimalPassportsByFarmId(@PathVariable Long farmId){
        return animalPassportService.getAnimalPassportsByFarmId(farmId);
    }


    @GetMapping("/organization_id/{organizationId}")
    public List<AnimalPassport> getAnimalPassportsByOrganizationId(@PathVariable Long organizationId){
        return animalPassportService.getAnimalPassportsByOrganizationId(organizationId);
    }

    @PostMapping
    public AnimalPassport createAnimalPassport(@RequestBody AnimalPassport animalPassport,
                                               @RequestParam("farm_id") Long farmId,
                                               @RequestParam("farm_original_owner_id") @Nullable Long farmOriginalOwnerId,
                                               @RequestParam("father_id") @Nullable Long fatherId,
                                               @RequestParam("mother_id") @Nullable Long motherId,
                                               @RequestParam("genetic_group_id") @Nullable Long geneticGroupId){
        return animalPassportService.createAnimalPassport(animalPassport, farmId, farmOriginalOwnerId, fatherId, motherId, geneticGroupId);
    }

    @PatchMapping("/{externalId}")
    public AnimalPassport updateAnimalPassportByExternalId(@RequestBody AnimalPassport animalPassport,
                                                           @PathVariable String externalId,
                                                           @RequestParam("farm_id") @Nullable Long farmId,
                                                           @RequestParam("farm_original_owner_id") @Nullable Long farmOriginalOwnerId,
                                                           @RequestParam("genetic_group_id") @Nullable Long geneticGroupId){
        return animalPassportService.updateAnimalPassportByExternalId(animalPassport, externalId, farmId, farmOriginalOwnerId, geneticGroupId);
    }
}
