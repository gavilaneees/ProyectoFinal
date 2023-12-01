package com.curso.service;

import com.curso.model.Batalla;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
public interface BatallasService {
    List<Batalla> obtenerTodasLasBatallas();
    Batalla obtenerBatallaPorId(Integer id);
    void crearBatalla(Batalla batalla);
}
