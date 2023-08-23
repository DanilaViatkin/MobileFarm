package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Farm;
import by.refor.mobilefarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
