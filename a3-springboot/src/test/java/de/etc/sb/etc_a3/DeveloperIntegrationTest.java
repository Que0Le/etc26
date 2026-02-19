package de.etc.sb.etc_a3;

import de.etc.sb.etc_a3.model.Developer;
import de.etc.sb.etc_a3.repository.DeveloperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DeveloperIntegrationTest {

    @Autowired
    private DeveloperRepository repository;

    @Test
    void testCrudOperations() {
        // Create
        Developer dev = new Developer();
        dev.setName("Jane Doe");
        dev.setAge(282);
        dev.setSalary(90000);
        Developer saved = repository.save(dev);
        assertThat(saved.getId()).isNotNull();

        // Read
        Developer found = repository.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Jane Doe");

        // Update
        found.setSalary(95000);
        repository.save(found);
        assertThat(repository.findById(saved.getId()).get().getSalary()).isEqualTo(95000);

        // Delete
//        repository.deleteById(saved.getId());
//        assertThat(repository.findById(saved.getId())).isEmpty();
    }
}