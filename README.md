# Proyecto de Microservicios Pokémon

Este proyecto implementa un sistema de batallas Pokémon utilizando microservicios. Los microservicios incluyen servicios para Pokémon, entrenadores y batallas.

## Estructura del Proyecto

El proyecto está dividido en varios módulos:

- **Pokemon:** Gestiona la información de los Pokémon.
- **Entrenador:** Gestiona la información de los entrenadores y sus Pokémon.
- **Batallas:** Gestiona las batallas entre Pokémon de los entrenadores.

Cada módulo tiene su propia lógica de negocio y se comunica con otros servicios a través de API REST.

## Tecnologías Utilizadas

- Java
- Spring Boot
- JPA/Hibernate
- REST
- Maven

## Endpoints de los Servicios

### Pokemon Service

El servicio de Pokémon proporciona las siguientes API REST:

- **Obtener todos los Pokémon:**
  - **Endpoint:** `/pokemones`
  - **Método:** `GET`
  - **Descripción:** Obtiene la lista completa de Pokémon.

- **Obtener un Pokémon por ID:**
  - **Endpoint:** `/pokemon/{id}`
  - **Método:** `GET`
  - **Parámetros:** `id` - Identificador del Pokémon.
  - **Descripción:** Obtiene la información detallada de un Pokémon específico.

- **Crear un nuevo Pokémon:**
  - **Endpoint:** `/pokemon`
  - **Método:** `POST`
  - **Cuerpo de la Solicitud:** Datos del nuevo Pokémon.
  - **Descripción:** Crea un nuevo Pokémon y lo agrega a la base de datos.
 
- **Incrementar nivel a Pokémon:**
  - **Endpoint:** `/pokemon/{id}/incrementar-nivel`
  - **Método:** `PUT`
  - **Parámetros:** `id` - Identificador del Pokémon.
  - **Descripción:** Sube en una unidad el nivel del Pokémon.

- **Eliminar Pokémon:**
  - **Endpoint:** `/pokemon/{id}/`
  - **Método:** `DELETE`
  - **Parámetros:** `id` - Identificador del Pokémon.
  - **Descripción:** Elimina de la base de datos el Pokémon deseado.

### Entrenador Service

El servicio de Entrenadores proporciona las siguientes API REST:

- **Obtener todos los Entrenadores:**
  - **Endpoint:** `/entrenadores`
  - **Método:** `GET`
  - **Descripción:** Obtiene la lista completa de Entrenadores.

- **Obtener un Entrenador por ID:**
  - **Endpoint:** `/entrenadores/{id}`
  - **Método:** `GET`
  - **Parámetros:** `id` - Identificador del Entrenador.
  - **Descripción:** Obtiene la información detallada de un Entrenador específico.
 
- **Obtener Pokémon de un Entrenador por ID:**
  - **Endpoint:** `/entrenadores/{id}/pokemon`
  - **Método:** `GET`
  - **Parámetros:** `id` - Identificador del Entrenador.
  - **Descripción:** Obtiene la información detallada del Pokémon de un Entrenador específico.

- **Crear un nuevo Entrenador:**
  - **Endpoint:** `/entrenadores`
  - **Método:** `POST`
  - **Cuerpo de la Solicitud:** Datos del nuevo Entrenador.
  - **Descripción:** Crea un nuevo Entrenador y lo agrega a la base de datos.

- **Crear un nuevo Entrenador:**
  - **Endpoint:** `/entrenadores`
  - **Método:** `POST`
  - **Cuerpo de la Solicitud:** Datos del nuevo Entrenador.
  - **Descripción:** Crea un nuevo Entrenador y lo agrega a la base de datos.

- **Incrementar batallas ganadas a Entrenador:**
  - **Endpoint:** `/entrenadores/{id}/incrementar-ganadas`
  - **Método:** `PUT`
  - **Parámetros:** `id` - Identificador del Entrenador.
  - **Descripción:** Sube en una unidad las batallas ganadas del Entrenador.
 
- **Incrementar batallas perdidas a Entrenador:**
  - **Endpoint:** `/entrenadores/{id}/incrementar-perdidas`
  - **Método:** `PUT`
  - **Parámetros:** `id` - Identificador del Entrenador.
  - **Descripción:** Sube en una unidad las batallas perdidas del Entrenador.

- **Eliminar Entrenador:**
  - **Endpoint:** `/entrenadores/{id}/`
  - **Método:** `DELETE`
  - **Parámetros:** `id` - Identificador del Entrenador.
  - **Descripción:** Elimina de la base de datos el Entrenador deseado.

### Batallas Service

El servicio de Batallas proporciona las siguientes API REST:

- **Obtener todas las Batallas:**
  - **Endpoint:** `/batallas`
  - **Método:** `GET`
  - **Descripción:** Obtiene la lista completa de Batallas.

- **Obtener una Batalla por ID:**
  - **Endpoint:** `/batallas/{id}`
  - **Método:** `GET`
  - **Parámetros:** `id` - Identificador de la Batalla.
  - **Descripción:** Obtiene la información detallada de una Batalla específica.

- **Crear una nueva Batalla:**
  - **Endpoint:** `/batallas`
  - **Método:** `POST`
  - **Cuerpo de la Solicitud:** Datos de la nueva Batalla.
  - **Descripción:** Crea una nueva Batalla y la agrega a la base de datos.

