package com.nhnacademy.springcertificateinssuancesystem.controller;

import com.nhnacademy.springcertificateinssuancesystem.domain.ResidentRegisterRequest;
import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import com.nhnacademy.springcertificateinssuancesystem.service.ResidentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public void createResident(@RequestBody ResidentRegisterRequest residentRegisterRequest) {
        Resident resident = Resident.toEntity(residentRegisterRequest);
        residentService.createResident(resident);
    }

    @PutMapping
    public void modifyResident() {

    }
}
