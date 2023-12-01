package com.curso.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */

/**
 * Entidad que representa a un Entrenador en el sistema
 * Esta entidad contiene datos que identifican a cada Entrenador
 */
@Entity
@Table(name="entrenadores")
public class Entrenador {
    /**
     * Identificador del Entrenador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Nombre del entrenador
     */
    private String nombre;
    /**
     * Numero de batallas ganadas
     */
    @Column(name="batallas_ganadas")
    private Integer batallasGanadas;
    /**
     * Numero de batallas perdidas
     */
    @Column(name="batallas_perdidas")
    private Integer batallasPerdidas;
    /**
     * Pokemon del Entrenador
     */
    private Integer pokemon_id;

    /**
     * Constructor por defecto
     */
    public Entrenador() {
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
     * @param pokemon_id: id del Pokemon del Entrenador
     */
    public Entrenador(Integer id, String nombre, Integer batallasGanadas, Integer batallasPerdidas, Integer pokemon_id) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.batallasGanadas = batallasGanadas;
        this.batallasPerdidas = batallasPerdidas;
        this.pokemon_id = pokemon_id;
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
        return pokemon_id;
    }

    public void setPokemon(Integer pokemon_id) {
        this.pokemon_id = pokemon_id;
    }
}
