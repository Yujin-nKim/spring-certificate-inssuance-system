package com.nhnacademy.springcertificateinssuancesystem.entity;

import com.nhnacademy.springcertificateinssuancesystem.domain.ResidentRegisterRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="resident")
@Builder
public class Resident { // 주민
    @Id
    @Column(name="resident_serial_number", nullable = false)
    private int residentSerialNumber; // 주민일련번호

    @Column(nullable = false)
    private String name; // 성명

    @Column(name="resident_registration_number", nullable = false)
    private String residentRegistrationNumber; // 주민등록번호

    @Column(name="gender_code", nullable = false)
    private String genderCode; // 성별 코드

    @Column(name="birth_date", nullable = false)
    private LocalDateTime birthDate; // 출생일시

    @Column(name="birth_place_code", nullable = false)
    private String birthPlaceCode; // 출생장소코드

    @Column(name="registration_base_address", nullable = false)
    private String registrationBaseAddress; // 등록기준지주소

    @Column(name="death_date")
    private LocalDateTime deathDate; // 사망일시

    @Column(name="death_place_code")
    private String deathPlaceCode; // 사망장소코드

    @Column(name="death_place_address")
    private String deathPlaceAddress; // 사망장소주소
}
