package com.Azienda.viaggiAziendali.mapper;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import com.Azienda.viaggiAziendali.payload.DipendenteDTO;
import org.springframework.stereotype.Component;

@Component
public class DipendenteMapperDTO {

    // ENTITY -> DTO
    public static DipendenteDTO toDipendenteDTO(Dipendente dipendente){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setCognome(dipendente.getCognome());
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setUsername(dipendente.getUsername());
        dipendenteDTO.setEmail(dipendente.getEmail());
        dipendenteDTO.setImmagineProfilo(dipendente.getImmagineProfilo());
        return dipendenteDTO;
    }

    // DTO -> ENTITY
    public static Dipendente toDipendenteEntity(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = new Dipendente();
        dipendente.setCognome(dipendenteDTO.getCognome());
        dipendente.setNome(dipendenteDTO.getNome());
        dipendente.setUsername(dipendenteDTO.getUsername());
        dipendente.setEmail(dipendenteDTO.getEmail());
        dipendente.setImmagineProfilo(dipendenteDTO.getImmagineProfilo());
        return dipendente;

    }
}
