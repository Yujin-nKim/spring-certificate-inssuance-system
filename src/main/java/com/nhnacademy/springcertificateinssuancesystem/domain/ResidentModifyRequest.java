package com.nhnacademy.springcertificateinssuancesystem.domain;

import lombok.Data;

@Data
public class ResidentModifyRequest {
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    private String registrationBaseAddress;
    private String deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
}
