package com.nhnacademy.springcertificateinssuancesystem.service;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import com.nhnacademy.springcertificateinssuancesystem.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService{

    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public Optional<Resident> getResident(int residentSerialNumber) {
        return Optional.of(residentRepository.findById(residentSerialNumber).get());
    }

    @Override
    public void createResident(Resident resident) {
        residentRepository.save(resident);
    }

    @Override
    public void modifyResident(Resident resident) {
        Resident updatedResident = residentRepository.findById(resident.getResidentSerialNumber())
                .orElseThrow(() -> new RuntimeException("Resident not found with id : " + resident.getResidentSerialNumber()));

        updatedResident.setName(resident.getName());
        updatedResident.setResidentRegistrationNumber(resident.getResidentRegistrationNumber());
        updatedResident.setGenderCode(resident.getGenderCode());
        updatedResident.setRegistrationBaseAddress(resident.getRegistrationBaseAddress());
        updatedResident.setDeathDate(resident.getDeathDate());
        updatedResident.setDeathPlaceCode(resident.getDeathPlaceCode());
        updatedResident.setDeathPlaceAddress(resident.getDeathPlaceAddress());
    }
}
