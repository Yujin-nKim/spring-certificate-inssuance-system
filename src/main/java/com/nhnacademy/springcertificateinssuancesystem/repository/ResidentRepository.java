package com.nhnacademy.springcertificateinssuancesystem.repository;

import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
}
