package com.Azienda.viaggiAziendali.controller;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import com.Azienda.viaggiAziendali.entity.Viaggio;
import com.Azienda.viaggiAziendali.payload.PrenotazioneDTO;
import com.Azienda.viaggiAziendali.repository.DipendenteRepository;
import com.Azienda.viaggiAziendali.repository.PrenotazioneRepository;
import com.Azienda.viaggiAziendali.repository.ViaggioRepository;
import com.Azienda.viaggiAziendali.service.PrenotazioneService;
import com.Azienda.viaggiAziendali.service.ViaggioService;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    Cloudinary cloudinary;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    ViaggioRepository viaggioRepository;
    @Autowired
    DipendenteRepository dipendenteRepository;

    // mi creo una nuova prenotazione
    @PostMapping("/nuovaprenotazione")
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneDTO creaPrenotazione(@RequestBody @Validated PrenotazioneDTO prenotazioneDTO) {
        Dipendente dipendente = dipendenteRepository.findById(prenotazioneDTO.getDipendente().getIdDipendente()).orElseThrow(() -> new RuntimeException("ID Dipendente non trovato"));
        Viaggio viaggio = viaggioRepository.findById(prenotazioneDTO.getViaggio().getId()).orElseThrow(() -> new RuntimeException("ID Viaggio non trovato"));
        prenotazioneDTO.setViaggio(viaggio);
        prenotazioneDTO.setDipendente(dipendente);
        return prenotazioneService.createPrenotazioneDto(prenotazioneDTO);

    }

    // mi recupero tutte le prenotazioni presenti nel db
    @GetMapping("/tutteleprenotazioni")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PrenotazioneDTO> getAllPrenotazioni(){
        return prenotazioneService.getAllPrenotazioni();
    }
    // mi restituisce una prenotazione presente nel db
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PrenotazioneDTO getPrenotazioneById(@PathVariable Long id){
        return prenotazioneService.getPrenotazioneById(id);
    }
    //eliminazione di una prenotazione presente nel db
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePrenotazione(@PathVariable Long id){
        return prenotazioneService.deletePrenotazione(id);
    }
    // modifica di una prenotazione presente nel db
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PrenotazioneDTO modifyPrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO, @PathVariable Long id){
        return prenotazioneService.modifyPrenotazione(prenotazioneDTO,id);
    }
}
