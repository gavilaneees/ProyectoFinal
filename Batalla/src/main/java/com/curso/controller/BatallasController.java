package com.curso.controller;

import com.curso.model.Batalla;
import com.curso.service.BatallasService;
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
public class BatallasController {
    @Autowired
    private BatallasService batallasService;

    // URL: http://localhost:8283/batallas
    @GetMapping(value="/batallas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Batalla> obtenerTodasLasBatallas() {
        return batallasService.obtenerTodasLasBatallas();
    }

    // URL: http://localhost:8283/batallas/1
    @GetMapping(value = "/batallas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Batalla obtenerBatallaPorId(@PathVariable Integer id) {
        return batallasService.obtenerBatallaPorId(id);
    }

    // URL: http://localhost:8283/batallas
    /* {
          "idEntrenador1": 1,
          "idEntrenador2": 2,
          "idPokemon1": 3,
          "idPokemon2": 4
        } */
    @PostMapping(value = "/batallas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void crearBatalla(@RequestBody Batalla batalla) {
        batallasService.crearBatalla(batalla);
    }
}
