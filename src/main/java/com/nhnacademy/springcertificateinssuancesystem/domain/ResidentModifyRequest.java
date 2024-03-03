package com.nhnacademy.springcertificateinssuancesystem.domain;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ResidentModifyRequest {
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    private String registrationBaseAddress;
    private String deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;

    public Resident toEntity() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(getDeathDate(), formatter);

        return Resident.builder()
                .name(getName())
                .residentRegistrationNumber(getResidentRegistrationNumber())
                .genderCode(getGenderCode())
                .registrationBaseAddress(getRegistrationBaseAddress())
                .deathDate(dateTime)
                .deathPlaceCode(getDeathPlaceCode())
                .deathPlaceAddress(getDeathPlaceAddress())
                .build();
    }
}
