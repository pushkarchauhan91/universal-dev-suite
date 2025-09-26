package com.company;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> findAll() {
        return softwareEngineerService.findAll();
    }

    @GetMapping("/{id}")
    public SoftwareEngineer findById(@PathVariable Integer id) {
        return softwareEngineerService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.save(softwareEngineer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        softwareEngineerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateSoftwareEngineer(@PathVariable Integer id,
                                       @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateById(id, softwareEngineer);
    }

    @GetMapping("/all")
    public List<SoftwareEngineer> getSoftwareEngineers() {
        List<SoftwareEngineer> softwareEngineers = new ArrayList<>();
        SoftwareEngineer john = new SoftwareEngineer();
        john.setId(1);
        john.setName("John");
        john.setTechStack("js, node, java");
        SoftwareEngineer mary = new SoftwareEngineer();
        mary.setId(1);
        mary.setName("Mary");
        mary.setTechStack("tailwindcss, angular, react");
        softwareEngineers.add(john);
        softwareEngineers.add(mary);
        return softwareEngineers;
    }
}
