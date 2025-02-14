package com.Azienda.viaggiAziendali.mapper;

import com.Azienda.viaggiAziendali.entity.Prenotazione;
import com.Azienda.viaggiAziendali.payload.DipendenteDTO;
import com.Azienda.viaggiAziendali.payload.PrenotazioneDTO;
import org.springframework.stereotype.Component;

@Component
public class PrenotazioneMapperDTO {

    //MI CREO IL MAPPER, DOVE METTERE I METODI PER CONVERTIRE UN OGGETTO DI TIPO DTO A ENTITY E VICEVERSA

    //ENTITY -> DTO
    public static PrenotazioneDTO toPrenotazioneDTO(Prenotazione prenotazione){
        PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
        prenotazioneDTO.setDataRichiesta(prenotazione.getDataRichiesta());
        prenotazioneDTO.setDipendente(prenotazione.getDipendente());
        prenotazioneDTO.setViaggio(prenotazione.getViaggio());

        return prenotazioneDTO;
    }
    // DTO -> ENTITY
    public static Prenotazione toPrenotazioneEntity(PrenotazioneDTO prenotazioneDTO){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataRichiesta(prenotazioneDTO.getDataRichiesta());
        prenotazione.setDipendente(prenotazioneDTO.getDipendente());
        prenotazione.setViaggio(prenotazioneDTO.getViaggio());

        return prenotazione;
    }
}
