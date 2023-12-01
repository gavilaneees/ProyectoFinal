package com.curso.model;

import jakarta.persistence.*;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */

/**
 * Entidad que representa a una Batlla en el sistema
 * Esta entidad contiene datos que identifican a cada Batalla
 */
@Entity
@Table(name="batallas")
public class Batalla {
    /**
     * Identificador de Batalla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Identificador del Entrenador 1
     */
    private Integer idEntrenador1;
    /**
     * Identificador del Entrenador 2
     */
    private Integer idEntrenador2;
    /**
     * Identificador del Pokemon 1
     */
    private Integer idPokemon1;
    /**
     * Identificador del Pokemon 2
     */
    private Integer idPokemon2;
    /**
     * Identficador del ganador
     */
    private Integer ganador;

    /**
     * Constructor por defecto
     */
    public Batalla() {
        super();
    }

    /**
     * Constructor por parametros de Batalla
     * @param id: identificador de la batalla
     * @param idEntrenador1: identificador del Entrenador 1
     * @param idEntrenador2: identificador del Entrenador 2
     * @param idPokemon1: identificador del Pokemon 1
     * @param idPokemon2: identificador del Pokemon 2
     * @param ganador: identificador del ganador
     */
    public Batalla(Integer id, Integer idEntrenador1, Integer idEntrenador2, Integer idPokemon1, Integer idPokemon2, Integer ganador) {
        this.id = id;
        this.idEntrenador1 = idEntrenador1;
        this.idEntrenador2 = idEntrenador2;
        this.idPokemon1 = idPokemon1;
        this.idPokemon2 = idPokemon2;
        this.ganador = ganador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEntrenador1() {
        return idEntrenador1;
    }

    public void setIdEntrenador1(Integer idEntrenador1) {
        this.idEntrenador1 = idEntrenador1;
    }

    public Integer getIdEntrenador2() {
        return idEntrenador2;
    }

    public void setIdEntrenador2(Integer idEntrenador2) {
        this.idEntrenador2 = idEntrenador2;
    }

    public Integer getIdPokemon1() {
        return idPokemon1;
    }

    public void setIdPokemon1(Integer idPokemon1) {
        this.idPokemon1 = idPokemon1;
    }

    public Integer getIdPokemon2() {
        return idPokemon2;
    }

    public void setIdPokemon2(Integer idPokemon2) {
        this.idPokemon2 = idPokemon2;
    }

    public Integer getGanador() {
        return ganador;
    }

    public void setGanador(Integer ganador) {
        this.ganador = ganador;
    }
}
