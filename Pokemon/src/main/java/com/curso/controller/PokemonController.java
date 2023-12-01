package com.curso.controller;

import com.curso.model.Pokemon;
import com.curso.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    // URL: http://localhost:8080/pokemon
    @GetMapping(value="/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    // URL: http://localhost:8080/pokemon/1
    @GetMapping(value = "/pokemon/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pokemon getPokemonById(@PathVariable int id) {
        return pokemonService.getPokemonById(id);
    }

    // URL: http://localhost:8080/pokemon
    // {
    //    "nombre": "Glaglie",
    //    "nivel": 69,
    //    "tipo1": "HIELO",
    //    "tipo2": null
    // }
    @PostMapping(value = "/pokemon", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addPokemon(pokemon);
    }

    // URL: http://localhost:8080/pokemon/1/incrementar-nivel
    @PutMapping(value="/pokemon/{id}/incrementar-nivel", produces = MediaType.APPLICATION_JSON_VALUE)
    public void incrementarNivel(@PathVariable Integer id) {
        Pokemon pokemon = pokemonService.getPokemonById(id);
        pokemon.setNivel(pokemon.getNivel() + 1);
        pokemonService.actualizarPokemon(pokemon);
    }

    // URL: http://localhost:8080/pokemon/6
    @DeleteMapping(value = "/pokemon/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pokemon> deletePokemonById(@PathVariable int id) {
        return pokemonService.deletePokemonById(id);
    }
}
