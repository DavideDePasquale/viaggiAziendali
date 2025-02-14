package com.Azienda.viaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "dipendenti")
@Data
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idDipendente;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(unique = true, nullable = false)
    private String email;
    private String immagineProfilo;




}
