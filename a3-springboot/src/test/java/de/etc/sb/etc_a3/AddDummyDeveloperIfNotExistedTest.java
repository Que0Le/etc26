package de.etc.sb.etc_a3;

import de.etc.sb.etc_a3.model.Developer;
import de.etc.sb.etc_a3.repository.DeveloperRepository;
import de.etc.sb.etc_a3.util.DevLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddDummyDeveloperIfNotExistedTest {

    @Autowired
    private DeveloperRepository repository;

    @Test
    void testAddDevelopers() {
        DevLogger.info("Test inserting devs:");
        for (int i=0; i < 10; i++) {
            String name = "DummyDeveloper_" + i;
            Developer dev = repository.findByName(name).orElse(null);

            if (dev == null) {
                dev = new Developer();
                dev.setName(name);
                dev.setAge(123 + i);
                dev.setSalary(90000 + i * 3000);
                Developer saved = repository.save(dev);
                assertThat(saved.getId()).isNotNull();
                DevLogger.info("Inserted: " + dev);
            }
        }
    }
}