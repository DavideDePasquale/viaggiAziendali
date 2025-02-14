package com.Azienda.viaggiAziendali.payload;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import com.Azienda.viaggiAziendali.entity.Viaggio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDTO {

    @NotNull(message = "il campo 'dataRichiesta' non può essere rappresentataa da soli spazi vuoti!⚠️")
    @NotBlank(message = "il campo 'dataRichiesta' non può essere vuoto!⚠️")
    private LocalDate dataRichiesta;
    @NotNull(message = "il campo 'dipendente' non può essere rappresentataa da soli spazi vuoti!⚠️")
    // @NotBlank vale solo sulle stringhe, quindi non posso metterlo per l'oggetto complesso di tipo Dipendente
    private Dipendente dipendente;
    @NotNull(message = "il campo 'viaggio' non può essere rappresentataa da soli spazi vuoti!⚠️")
    //stessa cosa scritta sopra.
    private Viaggio viaggio;

}
