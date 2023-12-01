package com.curso.controller;

import com.curso.model.Entrenador;
import com.curso.model.PokemonAuxiliar;
import com.curso.service.EntrenadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
@RestController
public class EntrenadoresController {
    @Autowired
    EntrenadoresService entrenadoresService;

    //URL: http://localhost:8282/entrenadores
    @GetMapping(value="/entrenadores", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Entrenador> obtenerListaEntrenadores() {
        return entrenadoresService.obtenerListaEntrenadores();
    }

    //URL: http://localhost:8282/entrenadores/1
    @GetMapping(value="/entrenadores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Entrenador obtenerEntrenador(@PathVariable int id) {
        return entrenadoresService.obtenerEntrenador(id);
    }

    // URL: http://localhost:8282/entrenadores
    // {
    //    "nombre": "Serena",
    //    "pokemon": 5
    // }
    @PostMapping(value="/entrenadores", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarEntrenador(@RequestBody Entrenador entrenador) {
        entrenadoresService.agregarEntrenador(entrenador);
    }

    // URL: http://localhost:8282/entrenadores/5
    @DeleteMapping(value="/entrenadores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Entrenador> eliminarEntrenador(@PathVariable int id) {
        return entrenadoresService.eliminarEntrenador(id);
    }

    // URL: http://localhost:8282/entrenadores/1/incrementar-ganadas
    @PutMapping(value="/entrenadores/{id}/incrementar-ganadas", produces = MediaType.APPLICATION_JSON_VALUE)
    public void incrementarBatallasGanadas(@PathVariable Integer id) {
        Entrenador entrenador = entrenadoresService.obtenerEntrenador(id);
        entrenador.setBatallasGanadas(entrenador.getBatallasGanadas() + 1);
        entrenadoresService.actualizarEntrenador(entrenador);
    }

    // URL: http://localhost:8282/entrenadores/1/incrementar-perdidas
    @PutMapping(value="/entrenadores/{id}/incrementar-perdidas", produces = MediaType.APPLICATION_JSON_VALUE)
    public void incrementarBatallasPerdidas(@PathVariable Integer id) {
        Entrenador entrenador = entrenadoresService.obtenerEntrenador(id);
        entrenador.setBatallasPerdidas(entrenador.getBatallasPerdidas() + 1);
        entrenadoresService.actualizarEntrenador(entrenador);
    }

    //URL: http://localhost:8282/entrenadores/1/pokemon
    @GetMapping(value="/entrenadores/{id}/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
    public PokemonAuxiliar obtenerPokemon(@PathVariable int id) {
        Entrenador entrenador = entrenadoresService.obtenerEntrenador(id);
        Integer pokemonId = entrenador.getPokemon();
        return entrenadoresService.obtenerPokemon(pokemonId);
    }
}
