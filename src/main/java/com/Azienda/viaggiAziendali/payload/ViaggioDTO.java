package com.Azienda.viaggiAziendali.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioDTO {

    @NotNull(message = "il campo 'destinazione' non può essere vuoto!⚠️")
    @NotBlank(message = "il campo 'destinazione' non può essere rappresentato da soli spazi vuoti!⚠️")
    private  String destinazione;
    @NotNull(message = "il campo 'dataViaggio' non può essere vuoto!⚠️")
    private LocalDate dataViaggio;
    @NotNull(message = "il campo 'stato' non può essere vuoto!⚠️")
    @NotBlank(message = "il campo 'stato' non può essere rappresentato da soli spazi vuoti!⚠️")
    private String stato;
}
