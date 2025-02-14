package com.Azienda.viaggiAziendali.service;

import com.Azienda.viaggiAziendali.entity.Viaggio;
import com.Azienda.viaggiAziendali.mapper.ViaggioMapperDTO;
import com.Azienda.viaggiAziendali.payload.ViaggioDTO;
import com.Azienda.viaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
