package com.nhnacademy.springcertificateinssuancesystem.controller;

import com.nhnacademy.springcertificateinssuancesystem.domain.ResidentModifyRequest;
import com.nhnacademy.springcertificateinssuancesystem.domain.ResidentRegisterRequest;
import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import com.nhnacademy.springcertificateinssuancesystem.exception.ResidentNotFoundException;
import com.nhnacademy.springcertificateinssuancesystem.service.ResidentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }


    public Resident getResident(String serialNumber) {
        Resident resident = residentService.getResident(Integer.parseInt(serialNumber));

        if(Objects.isNull(resident)) {
            throw new ResidentNotFoundException();
        }

        return resident;
    }

    @PostMapping
    public void createResident(@RequestBody ResidentRegisterRequest residentRegisterRequest) {
        Resident resident = residentRegisterRequest.toEntity();
        residentService.createResident(resident);
    }

    @PutMapping("/{serialNumber}")
    public void modifyResident(@PathVariable("serialNumber") String serialNumber, @RequestBody ResidentModifyRequest residentModifyRequest) {

        Resident resident = getResident(serialNumber);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(residentModifyRequest.getDeathDate(), formatter);

        resident.setName(residentModifyRequest.getName());
        resident.setResidentRegistrationNumber(residentModifyRequest.getResidentRegistrationNumber());
        resident.setGenderCode(residentModifyRequest.getGenderCode());
        resident.setRegistrationBaseAddress(residentModifyRequest.getRegistrationBaseAddress());
        resident.setDeathDate(dateTime);
        resident.setDeathPlaceCode(residentModifyRequest.getDeathPlaceCode());
        resident.setDeathPlaceAddress(residentModifyRequest.getDeathPlaceAddress());

        residentService.modifyResident(resident);

    }
}
