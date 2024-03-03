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
@Table(name="certificate_issue")
public class CertificateIssue { // 증명서발급
    @Id
    @Column(name="certificate_confirmation_number", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificateConfirmationNumber; // 증명서확인번호

    @ManyToOne
    @JoinColumn(name="resident_serial_number", nullable = false)
    private Resident residentSerialNumber; // 주민일련번호

    @Column(name="certificate_type_code", nullable = false)
    private String certificateTypeCode; // 증명서유형코드

    @Column(name="certificate_issue_date", nullable = false)
    private LocalDate certificateIssueDate; // 증명서발급일자

}
