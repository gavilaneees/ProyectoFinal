package com.curso.service;

import com.curso.dao.EntrenadoresDAO;
import com.curso.model.Entrenador;
import com.curso.model.PokemonAuxiliar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
@Service
public class EntrenadoresServiceImpl implements EntrenadoresService{

    @Autowired
    EntrenadoresDAO entrenadoresDAO;

    @Autowired
    private RestTemplate restTemplate;

    private static final String POKEMON_SERVICE_URL = "http://localhost:8080";

    /**
     * Funcion que devuelve la lista de entrenadores almacenados en la base de datos
     * @return Lista de entrenadores almacenados
     */
    @Override
    public List<Entrenador> obtenerListaEntrenadores() {
        return entrenadoresDAO.findAll();
    }

    /**
     * Funcion que devuelve el entrenador con el id especificado
     * @param id del entrenador
     * @return Entrenador con Id deseado
     */
    @Override
    public Entrenador obtenerEntrenador(int id) {
        return entrenadoresDAO.findById(id).orElse(null);
    }

    /**
     * Funcion que permite agregar un nuevo Entrenador
     * @param entrenador: Entrenador a agregar a la base de datos
     */
    @Override
    public void agregarEntrenador(Entrenador entrenador) {
        entrenadoresDAO.save(entrenador);
    }

    /**
     * Funcion que permite eliminar un entrenador por id
     * @param id del entrenador
     * @return Lista de entrenadores restantes
     */
    @Override
    public List<Entrenador> eliminarEntrenador(int id) {
        entrenadoresDAO.deleteById(id);
        return entrenadoresDAO.findAll();
    }

    /**
     * Funcion que permite actualizar un entrenador
     * @param entrenador: entrenador a actualizar
     */
    @Override
    public void actualizarEntrenador(Entrenador entrenador){
        entrenadoresDAO.save(entrenador);
    }

    /**
     * Funcion que permite obtener la informacion del Pokemon del Entrenador
     * @param id: id del Pokemon
     * @return Pokemon del Entrenador
     */
    @Override
    public PokemonAuxiliar obtenerPokemon(int id){
        return restTemplate.getForObject(POKEMON_SERVICE_URL + "/pokemon/{id}", PokemonAuxiliar.class, id);
    }
}
