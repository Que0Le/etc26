package de.etc.sb.etc_a3.service;

import de.etc.sb.etc_a3.model.Developer;
import de.etc.sb.etc_a3.repository.DeveloperRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeveloperService {
    private final DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    public List<Developer> getAll() { return repository.findAll(); }

    public Developer add(Developer dev) { return repository.save(dev); }

    public Developer update(Long id, Developer details) {
        Developer dev = repository.findById(id).orElseThrow();
        dev.setName(details.getName());
        dev.setAge(details.getAge());
        dev.setSalary(details.getSalary());
        return repository.save(dev);
    }

    public void delete(Long id) { repository.deleteById(id); }
}