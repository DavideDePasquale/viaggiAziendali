package com.Azienda.viaggiAziendali.service;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import com.Azienda.viaggiAziendali.mapper.DipendenteMapperDTO;
import com.Azienda.viaggiAziendali.payload.DipendenteDTO;
import com.Azienda.viaggiAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.Azienda.viaggiAziendali.mapper.DipendenteMapperDTO.toDipendenteEntity;

@Service
public class DipendenteService {

    @Autowired
    DipendenteRepository dipendenteRepository;
    @Autowired
    DipendenteMapperDTO dipendenteMapperDTO;


    public DipendenteDTO createDipendenteDto(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = toDipendenteEntity(dipendenteDTO);
        dipendenteRepository.save(dipendente);
        return dipendenteDTO;

    }
    public Long idDipendente(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = toDipendenteEntity(dipendenteDTO);
        return dipendenteRepository.save(dipendente).getIdDipendente();
    }

    public DipendenteDTO modifyDipendente(DipendenteDTO dipendenteDTO, Long id){
        Dipendente dipendente = dipendenteRepository.findById(id).orElseThrow(()-> new RuntimeException("Dipendente non trovato"));
       if(dipendenteDTO.getNome() != null && !dipendenteDTO.getNome().equals(dipendente.getNome())){
           dipendente.setNome(dipendenteDTO.getNome());
       }
       if (dipendenteDTO.getCognome() != null && !dipendenteDTO.getCognome().equals(dipendente.getCognome())){
           dipendente.setCognome(dipendenteDTO.getCognome());
       }
       if(dipendenteDTO.getUsername() != null && !dipendenteDTO.getUsername().equals(dipendente.getUsername())){
           dipendente.setUsername(dipendenteDTO.getUsername());
       }
       if(dipendenteDTO.getEmail() != null && !dipendenteDTO.getEmail().equals(dipendente.getEmail())){
           dipendente.setEmail(dipendenteDTO.getEmail());
       }
       if(!dipendenteDTO.getImmagineProfilo().equals(dipendente.getImmagineProfilo())){
           dipendente.setImmagineProfilo(dipendenteDTO.getImmagineProfilo());
       }
       //salvo le eventuali modifiche nel db
       dipendente = dipendenteRepository.save(dipendente);
       return dipendenteMapperDTO.toDipendenteDTO(dipendente);
    }

}
