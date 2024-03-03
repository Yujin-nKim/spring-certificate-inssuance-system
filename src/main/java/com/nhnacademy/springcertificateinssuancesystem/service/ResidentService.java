package com.nhnacademy.springcertificateinssuancesystem.service;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;

import java.util.Optional;

public interface ResidentService {
    Optional<Resident> getResident(int residentSerialNumber);

    void createResident(Resident resident);

    void modifyResident(Resident resident);
}
