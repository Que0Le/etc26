package de.etc.sb.etc_a3;

import de.etc.sb.etc_a3.repository.DeveloperRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DeveloperCleanTableTest {

    @Autowired
    private DeveloperRepository repository;

    @BeforeEach
    void setUp() {
        long count = repository.count();
        System.out.println("================================");
        System.out.println("BEFORE TEST: To be deleted: " + count);
        System.out.println("================================");
        // This deletes all rows in the 'developers' table
        repository.deleteAll();
    }

    @Test
    void testTableIsEmpty() {
        long count = repository.count();
        assertThat(count).isEqualTo(0);
    }
}