package de.etc.sb.etc_a3.control;

import de.etc.sb.etc_a3.model.Developer;
import de.etc.sb.etc_a3.service.DeveloperService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/developers")  // no v1
public class DeveloperController {
    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @GetMapping
    public List<Developer> getAll() { return service.getAll(); }

    // POST with JSON payload
    @PostMapping(consumes = "application/json")
    public Developer createFromBody(@RequestBody Developer dev) {
        return service.add(dev);
    }

    // POST with URL params
    @PostMapping
    public Developer createFromParams(@RequestParam String name, @RequestParam Integer age, @RequestParam Integer salary) {
        Developer dev = new Developer();
        dev.setName(name);
        dev.setAge(age);
        dev.setSalary(salary);
        return service.add(dev);
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable Long id, @RequestBody Developer dev) {
        return service.update(id, dev);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}