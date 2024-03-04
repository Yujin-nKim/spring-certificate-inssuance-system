package com.nhnacademy.springcertificateinssuancesystem.controller;

import com.nhnacademy.springcertificateinssuancesystem.domain.RelationshipRegisterRequest;
import com.nhnacademy.springcertificateinssuancesystem.entity.FamilyRelationship;
import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import com.nhnacademy.springcertificateinssuancesystem.exception.ResidentNotFoundException;
import com.nhnacademy.springcertificateinssuancesystem.service.FamilyRelationshipService;
import com.nhnacademy.springcertificateinssuancesystem.service.ResidentService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {

    private final ResidentService residentService;
    private final FamilyRelationshipService familyRelationshipService;

    public FamilyRelationshipController(ResidentService residentService, FamilyRelationshipService familyRelationshipService) {
        this.residentService = residentService;
        this.familyRelationshipService = familyRelationshipService;
    }

    @ModelAttribute(value = "resident", binding = false)
    public Resident getResident(@PathVariable("serialNumber") String serialNumber) {
        Resident resident = residentService.getResident(Integer.parseInt(serialNumber));
        if (Objects.isNull(resident)) {
            throw new ResidentNotFoundException();
        }
        return resident;
    }

    @PostMapping
    public void createRelationship(@ModelAttribute("resident") Resident baseResident, @RequestBody RelationshipRegisterRequest request) {
        Resident familyResidentSerialNumber = residentService.getResident(request.getFamilySerialNumber());
        FamilyRelationship familyRelationship = request.toEntity(baseResident, familyResidentSerialNumber);
        familyRelationshipService.createRelationship(familyRelationship);
    }
}
