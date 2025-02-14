package com.Azienda.viaggiAziendali.controller;

import com.Azienda.viaggiAziendali.payload.ViaggioDTO;
import com.Azienda.viaggiAziendali.service.ViaggioService;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    Cloudinary cloudinary;
    @Autowired
    ViaggioService viaggioService;

    @PostMapping("/newviaggio")
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioDTO createNewViaggio(@RequestBody @Validated ViaggioDTO viaggioDTO){
        if(viaggioDTO.getDestinazione() == null){
            throw new RuntimeException("Non puoi creare un viaggio senza una data⚠️");
        }
        return viaggioService.createViaggioDto(viaggioDTO);
    }
}
