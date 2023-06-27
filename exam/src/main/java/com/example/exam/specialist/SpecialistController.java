package com.example.exam.specialist;

import com.example.exam.autoservice.AutoserviceDto;
import com.example.exam.autoservice.AutoserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Validated
@RequestMapping("api/v1/specialist")
public class SpecialistController {

    private final SpecialistService specialistService;
    private final AutoserviceRepository autoserviceRepository;

    @Autowired
    public SpecialistController(SpecialistService specialistService, AutoserviceRepository autoserviceRepository) {

        this.specialistService = specialistService;
        this.autoserviceRepository = autoserviceRepository;
    }

    @GetMapping
    public ResponseEntity<List<SpecialistDto>> getAllSpecialist() {
        List<SpecialistDto> specialistList = specialistService.getAllSpecialist();
        return new ResponseEntity<>(specialistList, HttpStatus.OK);
    }

    @GetMapping("/{specialistId}")
    public Optional<Specialist> getSpecialist(@PathVariable Long specialistId) {

        return specialistService.getById(specialistId);
    }

    @PostMapping("/{autoserviceId}")
    public ResponseEntity<SpecialistDto> addSpecialist(@PathVariable Long autoserviceId, @RequestBody SpecialistDto specialistDto) {
        SpecialistDto createdSpecialist = specialistService.addSpecialist(autoserviceId, specialistDto);
        return new ResponseEntity<>(createdSpecialist, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialistDto> updateSpecialist(@PathVariable Long autoserviceId, @RequestBody SpecialistDto specialistDto) {
        SpecialistDto updatedSpecialist = specialistService.updateSpecialist(autoserviceId, specialistDto);
        return new ResponseEntity<>(updatedSpecialist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialist(@PathVariable("id") Long id) {
        specialistService.deleteSpecialist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}