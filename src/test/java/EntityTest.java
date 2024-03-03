
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springcertificateinssuancesystem.config.RootConfig;
import com.nhnacademy.springcertificateinssuancesystem.config.WebConfig;
import com.nhnacademy.springcertificateinssuancesystem.entity.BirthDeathReportResident;
import com.nhnacademy.springcertificateinssuancesystem.entity.FamilyRelationship;
import com.nhnacademy.springcertificateinssuancesystem.entity.Household;
import com.nhnacademy.springcertificateinssuancesystem.entity.Resident;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class EntityTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("Resident Entity test")
    void testResidentEntity() {
        Resident resident = entityManager.find(Resident.class, 1);

        assertThat(resident.getName()).isEqualTo("남길동");
        assertThat(resident.getResidentRegistrationNumber()).isEqualTo("130914-1234561");
        assertThat(resident.getGenderCode()).isEqualTo("남");
        assertThat(resident.getBirthDate().getYear()).isEqualTo(1913);
        assertThat(resident.getBirthPlaceCode()).isEqualTo("자택");
        assertThat(resident.getRegistrationBaseAddress()).isEqualTo("경기도 성남시 분당구 대왕판교로645번길");
        assertThat(resident.getDeathDate().getYear()).isEqualTo(2021);
        assertThat(resident.getDeathPlaceCode()).isEqualTo("주택");
        assertThat(resident.getDeathPlaceAddress()).isEqualTo("강원도 고성군 금강산로 290번길");
    }

    @Test
    @DisplayName("BirthDeathReportResident Entity test")
    void testBirthDeathReportResidentEntity() {
        Resident resident = entityManager.find(Resident.class, 4);
        BirthDeathReportResident birthDeathReportResident = entityManager.find(BirthDeathReportResident.class, new BirthDeathReportResident.PrimaryKey("출생", resident));

        assertThat(birthDeathReportResident.getPrimayKey().getReportResidentSerialNumber().getName()).isEqualTo("남기준");
        assertThat(birthDeathReportResident.getPrimayKey().getBirthDeathTypeCode()).isEqualTo("출생");
        assertThat(birthDeathReportResident.getResident().getName()).isEqualTo("남기석");
        assertThat(birthDeathReportResident.getBirthDeathReportDate().getYear()).isEqualTo(2012);
    }

    @Test
    @DisplayName("FamilyRelationship Entity test")
    void testFamilyRelationshipEntity() {
        Resident resident1 = entityManager.find(Resident.class, 1);
        Resident resident2 = entityManager.find(Resident.class, 2);

        FamilyRelationship familyRelationship = entityManager.find(FamilyRelationship.class, new FamilyRelationship.PrimaryKey(resident1, resident2));

        assertThat(familyRelationship.getPrimayKey().getBaseResidentSerialNumber().getName()).isEqualTo("남길동");
        assertThat(familyRelationship.getPrimayKey().getFamilyResidentSerialNumber().getName()).isEqualTo("남석환");
        assertThat(familyRelationship.getFamilyRelationshipCode()).isEqualTo("자녀");
    }

    @Test
    @DisplayName("Household Entity test")
    void testHouseholdEntity() {
        Resident resident = entityManager.find(Resident.class, 4);

        Household household = entityManager.find(Household.class, 1);

        assertThat(household.getHouseholdResidentSerialNumber().getName()).isEqualTo(resident.getName());
    }
}
