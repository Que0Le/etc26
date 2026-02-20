package de.etc.sb.etc_a3.service;

import de.etc.sb.etc_a3.exception.ResourceNotFoundException;
import de.etc.sb.etc_a3.model.Developer;
import de.etc.sb.etc_a3.repository.DeveloperRepository;
import de.etc.sb.etc_a3.util.DevLogger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {
    private final DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    public List<Developer> getAll() { return repository.findAll(); }

    public Developer add(Developer dev) {
        if (dev.getName() == null || dev.getName().isEmpty()) {
            throw new IllegalArgumentException("Developer name cannot be empty");
        }
        return repository.save(dev);
    }

    public Developer update(Long id, Developer details) {
        Optional<Developer> optionalDev = repository.findById(id);
        if (optionalDev.isEmpty()) {
            DevLogger.debug("Resource not found for dev id=" + id);
            throw new ResourceNotFoundException("Developer with ID " + id + " not found");
        }
        Developer dev = optionalDev.get();
        DevLogger.info("Updating developer: " + dev.getName() + " + id=" + id);
        dev.setName(details.getName());
        dev.setAge(details.getAge());
        dev.setSalary(details.getSalary());

        return repository.save(dev);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            DevLogger.debug("Developer not found for id=" + id);
            throw new ResourceNotFoundException("Cannot delete: Developer " + id + " does not exist");
        }
        repository.deleteById(id);
    }
}