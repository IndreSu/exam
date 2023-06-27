package com.example.exam.autoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("api/v1/autoservice")
public class AutoserviceController {

    private final AutoserviceService autoserviceService;

    @Autowired
    public AutoserviceController(AutoserviceService autoserviceService) {
        this.autoserviceService = autoserviceService;
    }

    @GetMapping
    public ResponseEntity<List<AutoserviceDto>> getAllAutoservice() {
        List<AutoserviceDto> autoserviceList = autoserviceService.getAllAutoservice();
        return new ResponseEntity<>(autoserviceList, HttpStatus.OK);
    }

    @GetMapping("/{autoserviceId}")
    public Optional<Autoservice> getAutoservice(@PathVariable Long autoserviceId) {
        return autoserviceService.getById(autoserviceId);
    }

    @PostMapping
    public ResponseEntity<AutoserviceDto> addAutoservice(@RequestBody AutoserviceDto autoserviceDto) {
        AutoserviceDto createdAutoservice = autoserviceService.addAutoservice(autoserviceDto);
        return new ResponseEntity<>(createdAutoservice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoserviceDto> updateAutoservice(@PathVariable("id") Long id, @RequestBody AutoserviceDto autoserviceDto) {
        AutoserviceDto updatedAutoservice = autoserviceService.updateAutoservice(id, autoserviceDto);
        return new ResponseEntity<>(updatedAutoservice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutoservice(@PathVariable("id") Long id) {
        autoserviceService.deleteAutoservice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
