package com.nhnacademy.springcertificateinssuancesystem.repository;

import com.nhnacademy.springcertificateinssuancesystem.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.PrimaryKey> {
}
