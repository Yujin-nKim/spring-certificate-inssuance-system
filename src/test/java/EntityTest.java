
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springcertificateinssuancesystem.config.RootConfig;
import com.nhnacademy.springcertificateinssuancesystem.config.WebConfig;
import com.nhnacademy.springcertificateinssuancesystem.entity.BirthDeathReportResident;
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
}
