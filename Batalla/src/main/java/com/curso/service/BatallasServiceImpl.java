package com.curso.service;

import com.curso.dao.BatallasDAO;
import com.curso.model.Batalla;
import com.curso.model.EntrenadorAuxiliar;
import com.curso.model.PokemonAuxiliar;
import com.curso.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @autor David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 */
@Service
public class BatallasServiceImpl implements BatallasService{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BatallasDAO batallasDAO;

    private static final String POKEMON_SERVICE_URL = "http://localhost:8080";
    private static final String ENTRENADOR_SERVICE_URL = "http://localhost:8282";

    private static final Map<Tipo, Tipo[]> TABLA_RELACIONES = new HashMap<>();
    static {
        TABLA_RELACIONES.put(Tipo.AGUA, new Tipo[]{Tipo.FUEGO, Tipo.TIERRA, Tipo.ROCA});
        TABLA_RELACIONES.put(Tipo.FUEGO, new Tipo[]{Tipo.ACERO, Tipo.PLANTA, Tipo.HIELO, Tipo.BICHO});
        TABLA_RELACIONES.put(Tipo.PLANTA, new Tipo[]{Tipo.ROCA, Tipo.TIERRA, Tipo.AGUA});
        TABLA_RELACIONES.put(Tipo.ELÉCTRICO, new Tipo[]{Tipo.AGUA, Tipo.VOLADOR});
        TABLA_RELACIONES.put(Tipo.VENENO, new Tipo[]{Tipo.PLANTA});
        TABLA_RELACIONES.put(Tipo.VOLADOR, new Tipo[]{Tipo.BICHO, Tipo.LUCHA, Tipo.PLANTA});
        TABLA_RELACIONES.put(Tipo.NORMAL, new Tipo[]{});
        TABLA_RELACIONES.put(Tipo.FANTASMA, new Tipo[]{Tipo.FANTASMA, Tipo.PSÍQUICO});
        TABLA_RELACIONES.put(Tipo.SINIESTRO, new Tipo[]{Tipo.FANTASMA, Tipo.PSÍQUICO});
        TABLA_RELACIONES.put(Tipo.PSÍQUICO, new Tipo[]{Tipo.LUCHA, Tipo.VENENO});
        TABLA_RELACIONES.put(Tipo.BICHO, new Tipo[]{Tipo.PLANTA, Tipo.PSÍQUICO, Tipo.SINIESTRO});
        TABLA_RELACIONES.put(Tipo.LUCHA, new Tipo[]{Tipo.NORMAL, Tipo.HIELO, Tipo.ACERO, Tipo.SINIESTRO, Tipo.ROCA});
        TABLA_RELACIONES.put(Tipo.HADA, new Tipo[]{Tipo.DRAGÓN, Tipo.LUCHA, Tipo.SINIESTRO});
        TABLA_RELACIONES.put(Tipo.HIELO, new Tipo[]{Tipo.VOLADOR, Tipo.TIERRA, Tipo.PLANTA, Tipo.DRAGÓN});
        TABLA_RELACIONES.put(Tipo.DRAGÓN, new Tipo[]{Tipo.DRAGÓN});
        TABLA_RELACIONES.put(Tipo.ACERO, new Tipo[]{Tipo.HIELO, Tipo.ROCA});
        TABLA_RELACIONES.put(Tipo.ROCA, new Tipo[]{Tipo.BICHO, Tipo.FUEGO, Tipo.HIELO, Tipo.VOLADOR});
        TABLA_RELACIONES.put(Tipo.TIERRA, new Tipo[]{Tipo.FUEGO, Tipo.ACERO, Tipo.ELÉCTRICO, Tipo.ROCA, Tipo.VENENO});
    }

    public List<Batalla> obtenerTodasLasBatallas() {
        return batallasDAO.findAll();
    }

    public Batalla obtenerBatallaPorId(Integer id) {
        return batallasDAO.findById(id).orElse(null);
    }

    public void crearBatalla(Batalla batalla) {
        PokemonAuxiliar pokemon1 = restTemplate.getForObject(POKEMON_SERVICE_URL + "/pokemon/{id}", PokemonAuxiliar.class, batalla.getIdPokemon1());
        PokemonAuxiliar pokemon2 = restTemplate.getForObject(POKEMON_SERVICE_URL + "/pokemon/{id}", PokemonAuxiliar.class, batalla.getIdPokemon2());

        EntrenadorAuxiliar entrenador1 = restTemplate.getForObject(ENTRENADOR_SERVICE_URL + "/entrenadores/{id}", EntrenadorAuxiliar.class, batalla.getIdEntrenador1());
        EntrenadorAuxiliar entrenador2 = restTemplate.getForObject(ENTRENADOR_SERVICE_URL + "/entrenadores/{id}", EntrenadorAuxiliar.class, batalla.getIdEntrenador2());

        if (!pokemonPerteneceAEntrenador(pokemon1, entrenador1)) {
            System.out.println("El Pokémon 1 no pertenece al Entrenador 1");
            return;
        }

        if (!pokemonPerteneceAEntrenador(pokemon2, entrenador2)) {
            System.out.println("El Pokémon 2 no pertenece al Entrenador 2");
            return;
        }

        int probabilidadGanarEntrenador1 = calcularProbabilidadGanar(entrenador1, pokemon1, pokemon2);
        int probabilidadGanarEntrenador2 = calcularProbabilidadGanar(entrenador2, pokemon2, pokemon1);

        System.out.println(probabilidadGanarEntrenador1);
        System.out.println(probabilidadGanarEntrenador2);
        Random random = new Random();
        int limite = probabilidadGanarEntrenador1 + probabilidadGanarEntrenador2;

        if (limite <= 0) {
            limite = 1;
        }
        System.out.println(limite);
        int resultadoAleatorio = random.nextInt(limite);
        System.out.println(resultadoAleatorio);
        Integer idGanador, idPerdedor;
        if (resultadoAleatorio < probabilidadGanarEntrenador1) {
            idGanador = entrenador1.getId();
            idPerdedor = entrenador2.getId();
            actualizarNivelPokemonGanador(pokemon1);
        } else {
            idGanador = entrenador2.getId();
            idPerdedor = entrenador1.getId();
            actualizarNivelPokemonGanador(pokemon2);
        }

        incrementarContadores(idGanador, idPerdedor);

        batalla.setGanador(idGanador);
        batallasDAO.save(batalla);
    }

    /**
     * Función para verificar si un Pokémon pertenece a un entrenador
     * @param pokemon: Pokémon a verificar
     * @param entrenador: Entrenador al que se debe verificar la pertenencia
     * @return true si el Pokémon pertenece al entrenador, false en caso contrario
     */
    private boolean pokemonPerteneceAEntrenador(PokemonAuxiliar pokemon, EntrenadorAuxiliar entrenador) {
        if (pokemon != null && entrenador != null) {
            System.out.println(entrenador.getPokemon());
            System.out.println(pokemon.getId());
            if (entrenador.getPokemon() != null && entrenador.getPokemon().equals(pokemon.getId())) {
                return true;
            } else {
                System.out.println("Los Pokémon usados deben ser de los entrenadores.");
                return false;
            }
        } else {
            System.out.println("Los Pokémon usados deben ser de los entrenadores.");
            return false;
        }
    }

    /**
     * Funcion para actualizar el nivel de los Pokemon tras la batalla
     * @param pokemonGanador: pokemon ganador de la batalla
     */
    private void actualizarNivelPokemonGanador(PokemonAuxiliar pokemonGanador) {
        Random random = new Random();
        if (random.nextBoolean()) {
            restTemplate.put(POKEMON_SERVICE_URL + "/pokemon/{id}/incrementar-nivel", null, pokemonGanador.getId());
        }
    }

    /**
     * Funcion para incrementar los contadores de la clase Entrenador
     * @param ganador: id del Entrenador ganador
     * @param perdedor: id del Entrenador perdedor
     */
    private void incrementarContadores(Integer ganador, Integer perdedor) {
        restTemplate.put(ENTRENADOR_SERVICE_URL + "/entrenadores/{id}/incrementar-ganadas", null, ganador);
        restTemplate.put(ENTRENADOR_SERVICE_URL + "/entrenadores/{id}/incrementar-perdidas", null, perdedor);
    }

    /**
     * Funcion que calcula la probabilidad de que un entrenador gane la batalla
     * @param entrenador: entrenador a tener en cuenta
     * @param pokemon: pokemon del entrenador
     * @param oponente: pokemon oponente
     * @return: valor de la probabilidad de ganar
     */
    private int calcularProbabilidadGanar(EntrenadorAuxiliar entrenador, PokemonAuxiliar pokemon, PokemonAuxiliar oponente) {
        double factorBatallas = 0.33;
        double factorNivel = 0.33;
        double factorTipo = 0.33;

        int probabilidadBatallas = (entrenador.getBatallasGanadas() + 1) / (entrenador.getBatallasPerdidas() + 1);
        int probabilidadNivel = pokemon.getNivel();
        int probabilidadTipo = calcularProbabilidadTipo(pokemon, oponente);

        System.out.println(probabilidadTipo + " " + probabilidadBatallas + " " + probabilidadNivel);
        return (int) ((probabilidadBatallas * factorBatallas) + (probabilidadNivel * factorNivel) + (probabilidadTipo * factorTipo));
    }

    /**
     * Funcion para calcular la probabilidad basada en los tipos de Pokémon
     * @param pokemon: pokemon del entrenador
     * @param oponente: pokemon del oponente
     * @return: valor de la probabilidad basada en tipos
     */
    private int calcularProbabilidadTipo(PokemonAuxiliar pokemon, PokemonAuxiliar oponente) {
        Tipo tipoPokemon1 = pokemon.getTipo1();
        Tipo tipoPokemon2 = pokemon.getTipo2();
        Tipo tipoOponente1 = oponente.getTipo1();
        Tipo tipoOponente2 = oponente.getTipo2();

        Double probabilidadTipo1 = calcularProbabilidadTipoIndividual(tipoPokemon1, tipoOponente1, tipoOponente2);
        Double probabilidadTipo2 = (tipoPokemon2 != null) ? calcularProbabilidadTipoIndividual(tipoPokemon2, tipoOponente1, tipoOponente2) : 0;

        return (int) ((probabilidadTipo1 + probabilidadTipo2) / 2);
    }

    /**
     * Funcion para calcular la probabilidad basada en un tipo individual de Pokémon
     * @param tipoPokemon: tipo del Pokémon
     * @param tipoOponente1: primer tipo del oponente
     * @param tipoOponente2: segundo tipo del oponente
     * @return: valor de la probabilidad basada en el tipo individual
     */
    private Double calcularProbabilidadTipoIndividual(Tipo tipoPokemon, Tipo tipoOponente1, Tipo tipoOponente2) {
        Tipo[] fortalezas = TABLA_RELACIONES.get(tipoPokemon);

        if (fortalezas != null && fortalezas.length > 0) {
            for (Tipo tipoFortaleza : fortalezas) {
                if (tipoOponente1 == tipoFortaleza || tipoOponente2 == tipoFortaleza) {
                    return 1.0;
                }
            }
        }
        return 0.5;
    }
}
