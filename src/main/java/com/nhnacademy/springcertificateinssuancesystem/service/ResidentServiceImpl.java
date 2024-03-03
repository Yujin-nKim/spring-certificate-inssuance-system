package com.nhnacademy.springcertificateinssuancesystem.service;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import com.nhnacademy.springcertificateinssuancesystem.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService{

    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public Resident getResident(int residentSerialNumber) {
        return residentRepository.findById(residentSerialNumber).orElse(null);
    }

    @Override
    public void createResident(Resident resident) {
        residentRepository.save(resident);
    }

    @Override
    public void modifyResident(Resident resident) {
        residentRepository.save(resident);
    }
}
