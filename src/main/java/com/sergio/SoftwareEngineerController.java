package com.sergio;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }
    @GetMapping("{id}")
    public SoftwareEngineer getEngineerbyId(@PathVariable Integer id) {
        return softwareEngineerService.getAllSoftwareEngineersbyId(id);

    }
    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }
    @PutMapping("{id}")
    public void updateSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer, @PathVariable Integer id) {
        softwareEngineerService.updateSoftwareEngineerbyId(id, softwareEngineer);
    }
}
