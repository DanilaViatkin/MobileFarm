package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Organization;
import by.refor.mobilefarm.service.OrganizationService;
import by.refor.mobilefarm.service.impl.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationServiceImpl organizationService){
        this.organizationService = organizationService;
    }

    @GetMapping("/gln/{gln}")
    @ResponseStatus(HttpStatus.OK)
    public Organization getOrganizationByGLN(@PathVariable String gln){
        Organization org = organizationService.getOrganizationByGLN(gln);
        return org;
    }

    @GetMapping("/unp/{unp}")
    @ResponseStatus(HttpStatus.OK)
    public Organization getOrganizationByUNP(@PathVariable String unp){
        Organization org = organizationService.getOrganizationByUNP(unp);
        return org;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization createOrganization(@RequestBody Organization organization){
        return organizationService.createOrganization(organization);
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrganizationById(@PathVariable Long organizationId){
        organizationService.deleteOrganizationById(organizationId);
    }
}
