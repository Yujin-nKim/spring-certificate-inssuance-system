package com.nhnacademy.springcertificateinssuancesystem.service;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;

public interface ResidentService {
    Resident getResident(int residentSerialNumber);

    void createResident(Resident resident);

    void modifyResident(Resident resident);
}
