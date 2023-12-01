package com.curso.model;

import jakarta.persistence.*;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */

/**
 * Entidad que representa a un Entrenador en el sistema
 * Esta entidad contiene datos que identifican a cada Entrenador
 */
public class EntrenadorAuxiliar {
    /**
     * Identificador del Entrenador
     */
    private Integer id;
    /**
     * Nombre del entrenador
     */
    private String nombre;
    /**
     * Numero de batallas ganadas
     */
    private int batallasGanadas;
    /**
     * Numero de batallas perdidas
     */
    private int batallasPerdidas;
    /**
     * Pokemon del Entrenador
     */
    private Integer pokemon;

    /**
     * Constructor por defecto
     */
    public EntrenadorAuxiliar() {
        super();
        this.batallasGanadas = 0;
        this.batallasPerdidas = 0;
    }

    /**
     * Constructor por parametros de Entrenador
     * @param id: Identificador del Entrenador
     * @param nombre: Nombre del entrenador
     * @param batallasGanadas: numero de batallas ganadas
     * @param batallasPerdidas: numero de batallas perdidas
     * @param pokemon: id del Pokemon del Entrenador
     */
    public EntrenadorAuxiliar(Integer id, String nombre, Integer batallasGanadas, Integer batallasPerdidas, Integer pokemon) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.batallasGanadas = batallasGanadas;
        this.batallasPerdidas = batallasPerdidas;
        this.pokemon = pokemon;
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

    public int getBatallasGanadas() {
        return batallasGanadas;
    }

    public void setBatallasGanadas(int batallasGanadas) {
        this.batallasGanadas = batallasGanadas;
    }

    public int getBatallasPerdidas() {
        return batallasPerdidas;
    }

    public void setBatallasPerdidas(int batallasPerdidas) {
        this.batallasPerdidas = batallasPerdidas;
    }

    public Integer getPokemon() {
        return pokemon;
    }

    public void setPokemon_id(Integer pokemon) {
        this.pokemon = pokemon;
    }
}
