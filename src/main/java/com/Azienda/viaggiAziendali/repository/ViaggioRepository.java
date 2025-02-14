package com.Azienda.viaggiAziendali.repository;

import com.Azienda.viaggiAziendali.entity.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio,Long> {

}
