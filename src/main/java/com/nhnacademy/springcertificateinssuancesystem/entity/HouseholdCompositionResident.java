package com.nhnacademy.springcertificateinssuancesystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="household_composition_resident")
public class HouseholdCompositionResident { // 세대구성주민
    @EmbeddedId
    private PrimaryKey primayKey;

    @Column(name="report_date")
    private LocalDate reportDate; // 신고일자

    @Column(name="household_relationship_code")
    private String householdRelationshipCode; // 세대주관계코드

    @Column(name="household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode; // 세대구성변동사유코드

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    @Getter
    public static class PrimaryKey implements Serializable {
        @ManyToOne
        @JoinColumn(name="household_serial_number")
        private Household householdSerialNumber; // 세대일련번호

        @OneToOne
        @JoinColumn(name="resident_serial_number")
        private Resident residentSerialNumber; // 주민일련번호
    }
}
