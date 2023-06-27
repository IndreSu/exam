package com.example.exam.specialist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistDto {

    private String name;

    private String surname;

    private String specialization;

    private String city;

    private Integer rating;

}
