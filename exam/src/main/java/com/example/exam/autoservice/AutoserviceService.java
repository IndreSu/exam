package com.example.exam.autoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoserviceService {

        private final AutoserviceRepository autoserviceRepository;

        @Autowired
        public AutoserviceService(AutoserviceRepository autoserviceRepository) {

            this.autoserviceRepository = autoserviceRepository;
        }

    public List<AutoserviceDto> getAllAutoservice() {
        List<Autoservice> autoserviceList = autoserviceRepository.findAll();
        return autoserviceList.stream()
                .map(AutoserviceMapper::toAutoserviceDto)
                .collect(Collectors.toList());
    }

    public Optional<Autoservice> getById(Long autoserviceId) {

        return autoserviceRepository.findById(autoserviceId);
    }

    public AutoserviceDto addAutoservice(AutoserviceDto autoserviceDto) {
        Autoservice autoservice = AutoserviceMapper.toAutoservice(autoserviceDto);
        Autoservice savedAutoservice = autoserviceRepository.save(autoservice);
        return AutoserviceMapper.toAutoserviceDto(savedAutoservice);
    }

    public AutoserviceDto updateAutoservice(Long id, AutoserviceDto autoserviceDto) {
        Autoservice existingAutoservice = autoserviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Autoservice not found with id: " + id));

        existingAutoservice.setTitle(autoserviceDto.getTitle());
        existingAutoservice.setAddress(autoserviceDto.getAddress());
        existingAutoservice.setOwner(autoserviceDto.getOwner());

        Autoservice updatedAutoservice = autoserviceRepository.save(existingAutoservice);
        return AutoserviceMapper.toAutoserviceDto(updatedAutoservice);
    }

    public void deleteAutoservice(Long id) {
            autoserviceRepository.deleteById(id);
    }
}
