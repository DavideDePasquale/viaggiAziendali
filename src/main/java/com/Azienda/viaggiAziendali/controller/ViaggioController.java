package com.Azienda.viaggiAziendali.controller;

import com.Azienda.viaggiAziendali.payload.ViaggioDTO;
import com.Azienda.viaggiAziendali.service.ViaggioService;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    Cloudinary cloudinary;
    @Autowired
    ViaggioService viaggioService;

    // aggiunta viaggio
    @PostMapping("/newviaggio")
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioDTO createNewViaggio(@RequestBody @Validated ViaggioDTO viaggioDTO){
        if(viaggioDTO.getDestinazione() == null){
            throw new RuntimeException("Non puoi creare un viaggio senza una data⚠️");
        }
        return viaggioService.createViaggioDto(viaggioDTO);
    }
    // get che ritorna tutti i viaggi nel db
    @GetMapping("/tuttiiviaggi")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ViaggioDTO> getAllViaggi(){
        return viaggioService.getAllViaggi();
    }
    // mi ritorna un singolo viaggio
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ViaggioDTO getViaggioById(@PathVariable Long id){
        return viaggioService.getViaggioById(id);
    }
    // eliminazione di un viaggio presente nel db
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteViaggio(@PathVariable Long id){
        return viaggioService.deleteViaggio(id);
    }
    // modifica di un viaggio presente già
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ViaggioDTO modifyViaggio(@RequestBody ViaggioDTO viaggioDTO, @PathVariable Long id){
        return viaggioService.modifyViaggio(viaggioDTO,id);
    }

}
