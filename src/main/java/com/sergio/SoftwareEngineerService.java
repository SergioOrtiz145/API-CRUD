package com.sergio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getAllSoftwareEngineersbyId(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new RuntimeException("SoftwareEngineer id " + id + " not found."));
    }

    public void updateSoftwareEngineerbyId(Integer id, SoftwareEngineer softwareEngineer) {
        SoftwareEngineer updated = softwareEngineerRepository.findById(id).orElseThrow(() -> new RuntimeException("SoftwareEngineer id " + id + " not found."));
        updated.setName(softwareEngineer.getName());
        updated.setTechStack(softwareEngineer.getTechStack());
        softwareEngineerRepository.save(updated);
    }
}
