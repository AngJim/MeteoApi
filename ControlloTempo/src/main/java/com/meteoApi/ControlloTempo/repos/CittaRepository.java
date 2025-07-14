package com.meteoApi.ControlloTempo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meteoApi.ControlloTempo.model.Citta;

public interface CittaRepository extends JpaRepository<Citta, Integer> {
    // This interface will automatically provide CRUD operations for Citta entities
    // Additional custom query methods can be defined here if needed
    
}
