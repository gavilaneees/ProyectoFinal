package com.curso.service;

import com.curso.model.Entrenador;
import com.curso.model.PokemonAuxiliar;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
public interface EntrenadoresService {
    List<Entrenador> obtenerListaEntrenadores();
    Entrenador obtenerEntrenador(int id);
    void agregarEntrenador(Entrenador entrenador);
    List<Entrenador> eliminarEntrenador(int id);
    void actualizarEntrenador(Entrenador entrenador);
    PokemonAuxiliar obtenerPokemon(int id);
}