package com.example.exam.autoservice;

import com.example.exam.specialist.Specialist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="AUTOSERVICE")
public class Autoservice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String address;
    
    private String owner;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "autoservice")
    @JsonIgnoreProperties("autoservice") // Exclude the specialist field during serialization
    private List<Specialist> specialists;

}
