package com.Azienda.viaggiAziendali.repository;

import com.Azienda.viaggiAziendali.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

}
