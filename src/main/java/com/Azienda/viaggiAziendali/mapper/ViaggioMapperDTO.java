package com.Azienda.viaggiAziendali.mapper;

import com.Azienda.viaggiAziendali.entity.Viaggio;
import com.Azienda.viaggiAziendali.payload.ViaggioDTO;
import org.springframework.stereotype.Component;

@Component
public class ViaggioMapperDTO {

    // ENTITY -> DTO
    public static ViaggioDTO toViaggioDTO (Viaggio viaggio){
        ViaggioDTO viaggioDTO = new ViaggioDTO();
        viaggioDTO.setDataViaggio(viaggio.getDataViaggio());
        viaggioDTO.setStato(viaggio.getStato());
        viaggioDTO.setDestinazione(viaggio.getDestinazione());
        return viaggioDTO;
    }

    // DTO -> ENTITY
    public static Viaggio toViaggioEntity(ViaggioDTO viaggioDTO){
        Viaggio viaggio = new Viaggio();
        viaggio.setDataViaggio(viaggioDTO.getDataViaggio());
        viaggio.setStato(viaggioDTO.getStato());
        viaggio.setDestinazione(viaggioDTO.getDestinazione());
        return viaggio;
    }
}
