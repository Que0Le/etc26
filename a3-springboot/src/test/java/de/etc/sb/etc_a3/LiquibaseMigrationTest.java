package de.etc.sb.etc_a3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LiquibaseMigrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void verifyLiquibaseMigration() {
        // Query the postgres metadata to see if the table exists
        Integer count = jdbcTemplate.queryForObject(
                "SELECT count(*) FROM information_schema.tables WHERE table_name = 'developers'",
                Integer.class
        );

        assertThat(count).isEqualTo(1);
    }
}