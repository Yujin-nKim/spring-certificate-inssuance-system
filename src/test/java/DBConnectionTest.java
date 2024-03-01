import com.nhnacademy.springcertificateinssuancesystem.config.RootConfig;
import com.nhnacademy.springcertificateinssuancesystem.config.WebConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.sql.DataSource;
import java.sql.*;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class DBConnectionTest {
    @Autowired
    private DataSource dataSource;

    @Test
    @Order(1)
    @DisplayName("데이터베이스 연결 테스트")
    void testDatabaseSetup() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            String[] tableNames = {"resident", "household", "family_relationship", "certificate_issue", "household_composition_resident", "household_movement_address", "birth_death_report_resident"};

            for(String tableName : tableNames) {
                ResultSet resultSet = metaData.getTables(null, null, tableName, new String[]{"TABLE"});
                assertTrue(resultSet.next(), "Table " + tableName + " does not exist in the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while checking database setup: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
