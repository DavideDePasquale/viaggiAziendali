package com.Azienda.viaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity(name = "viaggi")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String destinazione;
    @Column(nullable = false)
    private LocalDate dataViaggio;
    private String stato;

    public Viaggio(Long id) {
        this.id = id;
    }
}
