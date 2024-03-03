package com.nhnacademy.springcertificateinssuancesystem.domain;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ResidentRegisterRequest {
    private int residentSerialNumber;
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    private String birthDate;
    private String birthPlaceCode;
    private String registrationBaseAddress;

    public Resident toEntity() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(getBirthDate(), formatter);

        return Resident.builder()
                .residentSerialNumber(getResidentSerialNumber())
                .name(getName())
                .residentRegistrationNumber(getResidentRegistrationNumber())
                .genderCode(getGenderCode())
                .birthDate(dateTime)
                .birthPlaceCode(getBirthPlaceCode())
                .registrationBaseAddress(getRegistrationBaseAddress())
                .build();
    }
}
