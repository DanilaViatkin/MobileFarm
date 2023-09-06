package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Location;
import by.refor.mobilefarm.model.bo.Owner;
import by.refor.mobilefarm.service.LocationService;
import by.refor.mobilefarm.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }

    @DeleteMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOwner(@PathVariable Long ownerId){
        ownerService.deleteOwner(ownerId);
    }
}
