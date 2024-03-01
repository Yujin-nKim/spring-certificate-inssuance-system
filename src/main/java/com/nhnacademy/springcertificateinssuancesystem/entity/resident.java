package com.nhnacademy.springcertificateinssuancesystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Locale;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="resident")
public class resident {
    @Id
    @Column(name="resident_serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int residentSerialNumber; // 주민일련번호

    private String name; // 성명

    @Column(name="resident_registeration_number")
    private String residentRegisterationNumber; // 주민등록번호

    @Column(name="generation_code")
    private String generationCode; // 성별 코드

    @Column(name="birth_date")
    private LocalDateTime birthDate;

    @Column(name="birth_place_code")
    private String birthPlaceCode;

    @Column(name="registeration_base_address")
    private String registerationBaseAddress;

    @Column(name="death_date")
    private LocalDateTime deathDate;

    @Column(name="death_place_code")
    private String deathPlaceCode;

    @Column(name="death_place_address")
    private String deathPlaceAddress;


}
