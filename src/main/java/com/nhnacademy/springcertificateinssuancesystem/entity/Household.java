package com.nhnacademy.springcertificateinssuancesystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="household")
public class Household { // 세대

    @Id
    @Column(name="household_serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int householdSerialNumber; // 세대일련번호

    @OneToOne
    @JoinColumn(name="household_resident_serial_number")
    Resident householdResidentSerialNumber; // 세대주민일련번호

    @Column(name="household_composition_date")
    private LocalDate householdCompositionDate; // 세대구성일자

    @Column(name="household_composition_reason_code")
    private String householdCompositionReasonCode; // 세대구성사유코드

    @Column(name="current_house_movement_address")
    private String currentHouseMovementAddress; // 현재전입주소

}
