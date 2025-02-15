package com.Azienda.viaggiAziendali.service;

import com.Azienda.viaggiAziendali.entity.Viaggio;
import com.Azienda.viaggiAziendali.mapper.ViaggioMapperDTO;
import com.Azienda.viaggiAziendali.payload.ViaggioDTO;
import com.Azienda.viaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Azienda.viaggiAziendali.mapper.ViaggioMapperDTO.toViaggioDTO;

@Service
public class ViaggioService {


    @Autowired
    ViaggioRepository viaggioRepository;
    @Autowired
    ViaggioMapperDTO viaggioMapperDTO;


    public ViaggioDTO createViaggioDto(ViaggioDTO viaggioDTO){
        Viaggio viaggio = viaggioMapperDTO.toViaggioEntity(viaggioDTO);
        viaggioRepository.save(viaggio);
        return viaggioDTO;
    }

    // get all viaggi
    public List<ViaggioDTO> getAllViaggi(){
        List<Viaggio> viaggioList = viaggioRepository.findAll();
        List<ViaggioDTO> viaggioDTOList = new ArrayList<ViaggioDTO>();
        for (Viaggio viaggio : viaggioList){
            viaggioDTOList.add(toViaggioDTO(viaggio));
        }
        return viaggioDTOList;
    }

    // get di un singolo viaggio
    public ViaggioDTO getViaggioById(Long id){
        Optional<Viaggio> viaggioCercato = viaggioRepository.findById(id);
        if (viaggioCercato.isPresent()){
            return toViaggioDTO(viaggioCercato.get());
        } else {
            throw new RuntimeException("Non esiste nessun viaggio con l'ID : "+ id);
        }
    }
    //elimino un singolo viaggio
    public String deleteViaggio(Long id){
        Optional<Viaggio> viaggioCercato = viaggioRepository.findById(id);
        if (viaggioCercato.isPresent()){
            viaggioRepository.delete(viaggioCercato.get());
           return "Viaggio con ID " + id + " è stato eliminato con successo!";
        } else {
            throw new RuntimeException("Viaggio con ID : "+ id + " non presente nel nostro db");
        }
    }
}
