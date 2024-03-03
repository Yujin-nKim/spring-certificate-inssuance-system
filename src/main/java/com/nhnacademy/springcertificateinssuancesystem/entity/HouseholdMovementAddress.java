package com.nhnacademy.springcertificateinssuancesystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private PrimaryKey primayKey;

    @Column(name="house_movement_address", nullable = false) // 전입주소
    private String houseMovementAddress;

    @Column(name="last_address_yn", nullable = false) // 최종주소여부
    private String lastAddressYn;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    @Getter
    public static class PrimaryKey implements Serializable {

        @ManyToOne
        @JoinColumn(name="household_serial_number", nullable = false)
        private Household householdSerialNumber; // 세대 일련번호

        @Column(name="house_movement_report_date", nullable = false)
        private LocalDate houseMovementReportDate; // 전입신고일자
    }
}
