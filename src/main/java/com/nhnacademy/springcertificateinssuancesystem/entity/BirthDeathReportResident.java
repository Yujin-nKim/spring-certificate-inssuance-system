package com.nhnacademy.springcertificateinssuancesystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="birth_death_report_resident")
public class BirthDeathReportResident { // 출생사망신고주민
    @EmbeddedId
    private PrimaryKey primayKey;

    @ManyToOne
    @JoinColumn(name="resident_serial_number", nullable = false)
    private Resident resident; // 주민일련번호

    @Column(name="birth_death_report_date", nullable = false)
    private LocalDate birthDeathReportDate; // 출생사망신고일자

    @Column(name="birth_report_qualifications_code")
    private String birthReportQualificationsCode; // 출생신고자격코드

    @Column(name="death_report_qualifications_code")
    private String deathReportQualificationsCode; // 사망신고자격코드

    @Column(name="email_address")
    private String emailAddress; // 이메일 주소

    @Column(name="phone_number", nullable = false)
    private String phoneNumber; // 전화번호

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    @Getter
    public static class PrimaryKey implements Serializable {

        @Column(name="birth_death_type_code", nullable = false)
        private String birthDeathTypeCode; // 출생사망유형코드

        @ManyToOne
        @JoinColumn(name="report_resident_serial_number", nullable = false)
        private Resident reportResidentSerialNumber; // 신고주민일련번호

    }
}
