package com.curso.service;

import com.curso.dao.PokemonDAO;
import com.curso.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonDAO pokemonDAO;

    /**
     * Funcion que devuelve todos los Pokemon que hay en la base de datos
     * @return Lista de todos los Pokemon que hay guardados
     */
    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonDAO.findAll();
    }

    /**
     * Funcion que devuelve el Pokemon con el id deseado
     * @param id: identificador del Pokemon
     * @return Pokemon con el id
     */
    @Override
    public Pokemon getPokemonById(int id) {
        return pokemonDAO.findById(id).orElse(null);
    }

    /**
     * Funcion para agregar un nuevo Pokemon
     * @param pokemon: Pokemon a agregar
     */
    @Override
    public void addPokemon(Pokemon pokemon){
        pokemonDAO.save(pokemon);
    }

    /**
     * Funcion que elimina un Pokemon con el id deseado
     * @param id: Identificador del Pokemon a eliminar
     * @return Lista de Pokemon restantes
     */
    @Override
    public List<Pokemon> deletePokemonById(int id) {
        pokemonDAO.deleteById(id);
        return pokemonDAO.findAll();
    }

    /**
     * Funcion que actualiza un Pokemon
     * @param pokemon: Pokemon a actualizar
     */
    @Override
    public void actualizarPokemon(Pokemon pokemon){
        pokemonDAO.save(pokemon);
    }
}
