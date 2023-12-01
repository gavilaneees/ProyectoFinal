package com.curso.model;

import jakarta.persistence.*;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */

/**
 * Entidad que representa a un Pokemon en el sistema
 * Esta entidad contiene datos que identifican a cada Pokemon
 */
public class PokemonAuxiliar {
    /**
     * Identificador de Pokemon
     */
    private Integer id;
    /**
     * Nombre del Pokemon
     */
    private String nombre;
    /**
     * Nivel del Pokemon
     */
    private Integer nivel;
    /**
     * Tipo 1 del Pokemon
     */
    @Enumerated(EnumType.STRING)
    private Tipo tipo1;
    /**
     * Tipo 1 del Pokemon
     */
    @Enumerated(EnumType.STRING)
    private Tipo tipo2;

    /**
     * Constructor sin parametros
     */
    public PokemonAuxiliar() {
        super();
    }

    /**
     * Constructor con los parametros de Pokemon
     * @param id: identificador del Pokemon
     * @param nombre: nombre del Pokemon
     * @param nivel: nivel del Pokemon
     * @param tipo1: tipo1 del Pokemon
     * @param tipo2: tipo2 del Pokemon
     */
    public PokemonAuxiliar(Integer id, String nombre, Integer nivel, Tipo tipo1, Tipo tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }
}
