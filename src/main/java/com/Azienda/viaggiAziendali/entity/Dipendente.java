package com.Azienda.viaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity(name = "dipendenti")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
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


    public Dipendente(Long idDipendente) {
        this.idDipendente = idDipendente;
    }
}
