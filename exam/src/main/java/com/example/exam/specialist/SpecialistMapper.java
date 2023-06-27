package com.example.exam.specialist;

public class SpecialistMapper {

    public static Specialist toSpecialist(SpecialistDto specialistDto) {

        Specialist specialist = new Specialist();
        specialist.setName(specialistDto.getName());
        specialist.setSurname(specialistDto.getSurname());
        specialist.setSpecialization(specialistDto.getSpecialization());
        specialist.setCity(specialistDto.getCity());
        specialist.setRating(specialistDto.getRating());

        return specialist;
    }

    public static SpecialistDto toSpecialistDto(Specialist specialist){

       SpecialistDto specialistDto = new SpecialistDto();
       specialistDto.setName(specialist.getName());
       specialistDto.setSurname(specialist.getSurname());
       specialistDto.setSpecialization(specialist.getSpecialization());
       specialistDto.setCity(specialist.getCity());
       specialistDto.setRating(specialist.getRating());

       return specialistDto;
    }
}
