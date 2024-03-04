package com.nhnacademy.springcertificateinssuancesystem.domain;

import com.nhnacademy.springcertificateinssuancesystem.entity.FamilyRelationship;
import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import lombok.Data;

@Data
public class RelationshipRegisterRequest {
    private int familySerialNumber;
    private String relationShip;

    public FamilyRelationship toEntity(Resident baseResident, Resident familyResidentSerialNumber) {
        return FamilyRelationship.builder()
                .primayKey(new FamilyRelationship.PrimaryKey(baseResident, familyResidentSerialNumber))
                .familyRelationshipCode(getRelationShip())
                .build();
    }
}
