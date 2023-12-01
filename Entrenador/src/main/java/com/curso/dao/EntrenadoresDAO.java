package com.curso.dao;

import com.curso.model.Entrenador;
import com.curso.model.PokemonAuxiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
@Repository
public interface EntrenadoresDAO extends JpaRepository<Entrenador, Integer> {
}
