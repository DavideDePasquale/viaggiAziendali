package com.Azienda.viaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "viaggi")
@Data
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String destinazione;
    @Column(nullable = false)
    private LocalDate dataViaggio;
    private String stato;

}
