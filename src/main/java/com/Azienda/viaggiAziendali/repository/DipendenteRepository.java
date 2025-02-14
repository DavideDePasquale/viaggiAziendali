package com.Azienda.viaggiAziendali.repository;

import com.Azienda.viaggiAziendali.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {

}
