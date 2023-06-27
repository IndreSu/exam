package com.example.exam.specialist;

import com.example.exam.autoservice.AutoserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("client/api/v1/specialist")
public class ClientSpecialistController {

    private final SpecialistService specialistService;
    private final AutoserviceRepository autoserviceRepository;

    @Autowired
    public ClientSpecialistController(SpecialistService specialistService, AutoserviceRepository autoserviceRepository) {

        this.specialistService = specialistService;
        this.autoserviceRepository = autoserviceRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpecialistDto>> getAllSpecialist() {
        List<SpecialistDto> specialistList = specialistService.getAllSpecialist();
        return new ResponseEntity<>(specialistList, HttpStatus.OK);
    }

    @PostMapping("/{specialistId}/rating")
    public ResponseEntity<String> rateSpecialist(@PathVariable Long specialistId, @RequestBody Integer rating) {
        if (rating < 1 || rating > 5) {
            return new ResponseEntity<>("Invalid rating value. Rating should be between 1 and 5.", HttpStatus.BAD_REQUEST);
        }

        boolean success = specialistService.rateSpecialist(specialistId, rating);
        if (success) {
            return new ResponseEntity<>("Specialist rated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to rate specialist.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
