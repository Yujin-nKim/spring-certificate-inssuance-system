package com.nhnacademy.springcertificateinssuancesystem.service;

import com.nhnacademy.springcertificateinssuancesystem.entity.FamilyRelationship;
import com.nhnacademy.springcertificateinssuancesystem.repository.FamilyRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("familyRelationshipService")
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService{

    @Autowired
    private FamilyRelationshipRepository familyRelationshipRepository;

    @Override
    public void createRelationship(FamilyRelationship relationship) {
        familyRelationshipRepository.save(relationship);
    }
}
