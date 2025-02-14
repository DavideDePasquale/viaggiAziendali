package com.Azienda.viaggiAziendali.controller;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import com.Azienda.viaggiAziendali.payload.DipendenteDTO;
import com.Azienda.viaggiAziendali.service.DipendenteService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    Cloudinary cloudinary;
    @Autowired
    DipendenteService dipendenteService;


    @PostMapping("/nuovodipendente")
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDTO creaDipendente(@RequestPart("immagine_profilo") MultipartFile immagine_profilo, @RequestPart @Validated DipendenteDTO dipendenteDTO, BindingResult validation) {

        if (immagine_profilo.isEmpty()) {


            if (validation.hasErrors()) {
                String message = "Utente non creato";
                for (ObjectError error : validation.getAllErrors()) {
                    message += error.getDefaultMessage();
                }
                try {
                    Map mappa = cloudinary.uploader().upload(immagine_profilo.getBytes(), ObjectUtils.emptyMap());
                    String urlImage = (String) mappa.get("secure_url");
                    dipendenteDTO.setImmagineProfilo(urlImage);
                    Long idGenerato = dipendenteService.idDipendente(dipendenteDTO);
                    return dipendenteDTO;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        } else {
            if (dipendenteDTO.getUsername() == null) {
                throw new RuntimeException("Non puo esistere un dipendente senza username!⚠️");
            }
            return dipendenteService.createDipendenteDto(dipendenteDTO);

        }
        return dipendenteDTO;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DipendenteDTO modificaDipendente(@RequestBody DipendenteDTO dipendenteDTO, @PathVariable Long id){
      return dipendenteService.modifyDipendente(dipendenteDTO,id);
    }
}
