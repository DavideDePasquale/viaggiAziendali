package com.Azienda.viaggiAziendali.service;

import com.Azienda.viaggiAziendali.entity.Prenotazione;
import com.Azienda.viaggiAziendali.mapper.PrenotazioneMapperDTO;
import com.Azienda.viaggiAziendali.payload.PrenotazioneDTO;
import com.Azienda.viaggiAziendali.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    PrenotazioneMapperDTO prenotazioneMapperDTO;


    public PrenotazioneDTO createPrenotazioneDto(PrenotazioneDTO prenotazioneDTO){
        Prenotazione prenotazione = prenotazioneMapperDTO.toPrenotazioneEntity(prenotazioneDTO);
        prenotazioneRepository.save(prenotazione);
        return prenotazioneDTO;
    }
}
