package com.Azienda.viaggiAziendali.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class DipendenteDTO {

    @NotNull(message = "il campo 'username' non può essere vuoto⚠️")
    @NotBlank(message = "il campo 'username' non può essere rappresentato da soli spazi vuoti⚠️")
    private String username;
    @NotNull(message = "il campo 'nome' non può vuoto⚠️")
    @NotBlank(message = "il campo 'nome' non può essere rappresentato da soli spazi vuoti⚠️")
    private String nome;
    @NotNull(message = "il campo 'cognome' non può essere vuoto⚠️")
    @NotBlank(message = "il campo 'cognome' non può essere rappresentato da soli spazi vuoti⚠️")
    private String cognome;
    @Email(message = "campo 'email' non valido")
    @NotNull(message = "il campo 'email' non può essere vuoto⚠️")
    @NotBlank(message = "il campo 'email' non può essere rappresentato da soli spazi vuoti⚠️")
    private String email;
    private String immagineProfilo;


}
