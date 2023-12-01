package com.curso.dao;

import com.curso.model.Batalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
@Repository
public interface BatallasDAO extends JpaRepository<Batalla, Integer> {
}
