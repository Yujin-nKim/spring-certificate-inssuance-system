package com.nhnacademy.springcertificateinssuancesystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="family_relationship")
public class FamilyRelationship { // 가족관계
    @EmbeddedId
    private PrimaryKey primayKey;

    @Column(name="family_relationship_code", nullable = false)
    private String familyRelationshipCode; // 가족관계코드

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    @Getter
    public static class PrimaryKey implements Serializable {

        @ManyToOne
        @JoinColumn(name="base_resident_serial_number", nullable = false)
        private Resident baseResidentSerialNumber; // 기준주민일련번호

        @ManyToOne
        @JoinColumn(name="family_resident_serial_number", nullable = false)
        private Resident familyResidentSerialNumber; // 가족주민일련번호

    }
}
