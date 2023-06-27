package com.example.exam.specialist;

import com.example.exam.autoservice.Autoservice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SPECIALIST")
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String specialization;

    private String city;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "autoservice_id")
    @JsonIgnoreProperties("specialist")
    private Autoservice autoservice;

    private Integer rating;

}
