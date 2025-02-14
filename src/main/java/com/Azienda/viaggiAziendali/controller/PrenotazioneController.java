package com.Azienda.viaggiAziendali.controller;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import com.Azienda.viaggiAziendali.entity.Viaggio;
import com.Azienda.viaggiAziendali.payload.PrenotazioneDTO;
import com.Azienda.viaggiAziendali.repository.DipendenteRepository;
import com.Azienda.viaggiAziendali.repository.ViaggioRepository;
import com.Azienda.viaggiAziendali.service.PrenotazioneService;
import com.Azienda.viaggiAziendali.service.ViaggioService;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    Cloudinary cloudinary;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    ViaggioRepository viaggioRepository;
    @Autowired
    DipendenteRepository dipendenteRepository;

    @PostMapping("/nuovaprenotazione")
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneDTO creaPrenotazione(@RequestBody @Validated PrenotazioneDTO prenotazioneDTO) {
        Dipendente dipendente = dipendenteRepository.findById(prenotazioneDTO.getDipendente().getIdDipendente()).orElseThrow(() -> new RuntimeException("ID Dipendente non trovato"));
        Viaggio viaggio = viaggioRepository.findById(prenotazioneDTO.getViaggio().getId()).orElseThrow(() -> new RuntimeException("ID Viaggio non trovato"));
        prenotazioneDTO.setViaggio(viaggio);
        prenotazioneDTO.setDipendente(dipendente);
        return prenotazioneService.createPrenotazioneDto(prenotazioneDTO);

    }
}
