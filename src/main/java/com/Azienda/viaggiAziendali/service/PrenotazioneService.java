package com.Azienda.viaggiAziendali.service;

import com.Azienda.viaggiAziendali.entity.Prenotazione;
import com.Azienda.viaggiAziendali.mapper.PrenotazioneMapperDTO;
import com.Azienda.viaggiAziendali.payload.PrenotazioneDTO;
import com.Azienda.viaggiAziendali.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Azienda.viaggiAziendali.mapper.PrenotazioneMapperDTO.toPrenotazioneDTO;

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

    // get all prenotazioni
    public List<PrenotazioneDTO> getAllPrenotazioni(){
        List<Prenotazione> prenotazioneList = prenotazioneRepository.findAll();
        List<PrenotazioneDTO> prenotazioneDTOList = new ArrayList<PrenotazioneDTO>();

        for (Prenotazione pren : prenotazioneList){
            prenotazioneDTOList.add(toPrenotazioneDTO(pren));
        }
        return prenotazioneDTOList;
    }

    //get singola prenotazione tramite id
    public PrenotazioneDTO getPrenotazioneById(Long id){
        Optional<Prenotazione> prenotazioneCercata = prenotazioneRepository.findById(id);
        if (prenotazioneCercata.isPresent()){
            return toPrenotazioneDTO(prenotazioneCercata.get());
        } else {
            throw new RuntimeException("Non esiste nessuna prenotazione con l'ID : " + id);
        }
    }
    //elimino una singola prenotazione
    public String deletePrenotazione(Long id){
        Optional<Prenotazione> prenotazioneDaEliminare = prenotazioneRepository.findById(id);
        if (prenotazioneDaEliminare.isPresent()){
            prenotazioneRepository.delete(prenotazioneDaEliminare.get());
            return "Prenotazione con ID " + id + " è stata eliminata con successo!👍";
        } else {
            throw new RuntimeException("Prenotazione con id :" + id + " non è stata trovat nel nostro db😒");
        }
    }
    // modifica di una prenotazione
    public PrenotazioneDTO modifyPrenotazione(PrenotazioneDTO prenotazioneDTO, Long id){
       Prenotazione prenotazione = prenotazioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Prenotazione con ID "+id+ " non trovata!❌"));

       if (prenotazioneDTO.getDataRichiesta() != null && !prenotazioneDTO.getDataRichiesta().isEqual(prenotazione.getDataRichiesta())){
           prenotazione.setDataRichiesta(prenotazioneDTO.getDataRichiesta());
       }
       if (prenotazioneDTO.getDipendente() != null && !prenotazioneDTO.getDipendente().equals(prenotazione.getDipendente())){
           prenotazione.setDipendente(prenotazioneDTO.getDipendente());
       }
       if(prenotazioneDTO.getViaggio() != null && !prenotazioneDTO.getViaggio().equals(prenotazione.getViaggio())){
           prenotazione.setViaggio(prenotazioneDTO.getViaggio());
       }
       prenotazione = prenotazioneRepository.save(prenotazione);
       return toPrenotazioneDTO(prenotazione);


    }
}
