package com.Azienda.viaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "prenotazioni")
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrenotazione;
    @Column(nullable = false)
    private LocalDate dataRichiesta;
    @Column(nullable = true)
    private String noteAggiuntive;
    @ManyToOne
    @JoinColumn(name = "dipendente_id",nullable = false)
    private Dipendente dipendente;
    @ManyToOne
    @JoinColumn(name = "viaggio_id", nullable = false)
    private Viaggio viaggio;

}
