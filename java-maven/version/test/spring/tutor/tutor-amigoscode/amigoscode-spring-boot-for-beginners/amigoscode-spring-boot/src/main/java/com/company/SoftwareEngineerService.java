package com.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository repository;

    public SoftwareEngineerService(SoftwareEngineerRepository repository) {
        this.repository = repository;
    }

    public List<SoftwareEngineer> findAll() {
        return repository.findAll();
    }

    public SoftwareEngineer findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void save(SoftwareEngineer softwareEngineer) {
        repository.save(softwareEngineer);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void updateById(Integer id, SoftwareEngineer updatedSoftwareEngineer) {
        SoftwareEngineer softwareEngineer = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"));
        softwareEngineer.setName(updatedSoftwareEngineer.getName());
        softwareEngineer.setTechStack(updatedSoftwareEngineer.getTechStack());
        repository.save(softwareEngineer);
    }
}
