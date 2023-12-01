package com.curso.service;

import com.curso.model.Pokemon;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
public interface PokemonService {
    List<Pokemon> getAllPokemon();
    Pokemon getPokemonById(int id);
    void addPokemon(Pokemon pokemon);
    List<Pokemon> deletePokemonById(int id);
    void actualizarPokemon(Pokemon pokemon);
}
