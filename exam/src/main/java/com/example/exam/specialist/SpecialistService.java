package com.example.exam.specialist;

import com.example.exam.autoservice.Autoservice;
import com.example.exam.autoservice.AutoserviceDto;
import com.example.exam.autoservice.AutoserviceMapper;
import com.example.exam.autoservice.AutoserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpecialistService {

    private final SpecialistRepository specialistRepository;
    private final AutoserviceRepository autoserviceRepository;

    @Autowired
    public SpecialistService(SpecialistRepository specialistRepository, AutoserviceRepository autoserviceRepository) {
        this.specialistRepository = specialistRepository;
        this.autoserviceRepository = autoserviceRepository;
    }

    public List<SpecialistDto> getAllSpecialist() {
        List<Specialist> specialistList = specialistRepository.findAll();
        return specialistList.stream()
                .map(specialist -> {
                    SpecialistDto specialistDto = SpecialistMapper.toSpecialistDto(specialist);
                    specialistDto.setRating(specialist.getRating()); // Set the rating in the DTO
                    return specialistDto;
                })
                .collect(Collectors.toList());
    }


    public Optional<Specialist> getById(Long specialistId) {

        return specialistRepository.findById(specialistId);
    }

    public SpecialistDto addSpecialist(Long autoserviceId, SpecialistDto specialistDto) {
        Autoservice autoservice = autoserviceRepository.findById(autoserviceId)
                .orElseThrow(() -> new IllegalArgumentException("Autoservice not found with id: " + autoserviceId));

        Specialist specialist = SpecialistMapper.toSpecialist(specialistDto);
        specialist.setAutoservice(autoservice);

        specialist = specialistRepository.save(specialist);

        return SpecialistMapper.toSpecialistDto(specialist);
    }

    public SpecialistDto updateSpecialist(Long id, SpecialistDto specialistDto) {
        Specialist existingSpecialist = specialistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Specialist not found with id: " + id));

        existingSpecialist.setName(specialistDto.getName());
        existingSpecialist.setSurname(specialistDto.getSurname());
        existingSpecialist.setSpecialization(specialistDto.getSpecialization());
        existingSpecialist.setCity(specialistDto.getCity());

        Specialist updatedSpecialist = specialistRepository.save(existingSpecialist);
        return SpecialistMapper.toSpecialistDto(updatedSpecialist);
    }

    public void deleteSpecialist(Long id) {
        specialistRepository.deleteById(id);
    }

    public boolean rateSpecialist(Long specialistId, Integer rating) {
        Optional<Specialist> specialistOptional = specialistRepository.findById(specialistId);
        if (specialistOptional.isEmpty()) {
            throw new IllegalArgumentException("Specialist not found with id: " + specialistId);
        }

        Specialist specialist = specialistOptional.get();
        specialist.setRating(rating);
        specialistRepository.save(specialist);
        return true;
    }

}
