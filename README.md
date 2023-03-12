# java-term-project-TachoPablo2
java-term-project-TachoPablo2 created by GitHub Classroom



Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: Pablo Romero Gómez, uvus: GFQ0792

Este proyecto es una adaptación del proyecto presentado por el estudiante Pablo Diego Acosta, en el curso 2021/22.

Estructura de las carpetas del proyecto
/src: Directorio con el código fuente.
fp.types: Paquete que contiene los tipos del proyecto.
fp.test: Paquete que contiene las clases de test del proyecto.
fp.utils: Paquete que contiene las clases de utilidad.
/data: Contiene el dataset del proyecto.
formula_e_race_reesults3.csv: Archivo csv que contiene datos de diferentes partidas de ajedrez.
Estructura del dataset
El dataset original Formula_e_raceresults se puede obtener de la URL https://www.kaggle.com/datasets/mlandry/formula-e-championship. Originalmente tiene 17 columnas y cada fila contiene datos sobre una carrera de fórmula e. El dataset usado en este proyecto tiene 14 columnas. A continuación se describen las 14 columnas del dataset:

season: de tipo integer, muestra el numero de la temporada, es decir, si es la número uno, dos etc.
race_num : de tipo integer, muestra el numero de la carrera en la temporada.
race_name : de tipo String, muestra la fecha y el nombre del circuito en que se corre.
race_date: de tipo LocalDate, fecha en que tiene lugar la carrera.
driver: de tipo String, nombre del piloto.
car: de tipo Integer, número del coche.
team: de tipo String, equipo del piloto que corre.
team_group: de tipo String, grupo de equipos al que pertence el equipo del piloto que corre
rank: de tipo integer, posición en la que acabó el piloto.
grid: de tipo integer, posición de salida en parrilla del piloto.
laps: de tipo Long, número de vueltas de la carrera
duration: de tipo duration, tiempo que tardó el piloto en acabar la carrera.
retired: de tipo boolean, es verdadero cuando el piloto se retiró de la prueba.
ptsl: de tipo list, lista que contiene los puntos de rank, de pole y bonus.
points: de tipo Integer, suma de los miembros de la lista anterior.

Tipos implementados
Los tipos que se han implementado en el proyecto son los siguientes:

Tipo Base - Race
Representa una carrera concreta. Propiedades:

season, de tipo Season, consultable. 
race_num, de tipo Integer, consultable.
race_name, de tipo String, consultable.
race_date, de tipo LocalDate, consultable.
driver, de tipo String, consultable.
car, de tipo Integer, consultable.
team, de tipo String, consultable.
team_group, de tipo String, consultable.

Constructores:

C1: Tiene un parámetro por cada propiedad básica del tipo.
C2: Crea un objeto de tipo Partida a partir de los siguientes parámetros: Boolean clasificatoria, TipoVictoria tipoVictoria, Resultado resultado, String jugadorBlancas, String jugadorNegras, Integer ratingBlancas, Integer ratingNegras, String movimientos, String apertura, LocalDate fecha, Integer duracion.
Restricciones:

R1: La duración debe estar entre 1 y 60.
R2: El movimiento inicial debe ser uno de los movimientos siguientes: h3, h4, g3, g4, f3, f4, e3, e4, d3, d4, c3, c4, b3, b4, a3, a4, Nh3, Nf3, Nc3, Na3.
R3: El rating de las blancas debe ser mayor que cero.
R4: El rating de las negras debe ser mayor que cero. *Criterio de igualdad: Dos partidas son iguales si todas sus propiedades básicas son iguales.
Criterio de ordenación: Por fecha, duración y número de movimientos.

Otras operaciones:

String getMovimiento(Integer numMovimiento): Devuelve el movimiento dado por el número numMovimiento. Eleva IllegalArgumentException si numMovimiento no está en el intervalo [1, getNumMovimientos()]
Tipos auxiliares
TipoVictoria, enumerado. Puede tomar los valores OUTOFTIME, RESIGN, MATE, DRAW.
Resultado, enumerado. Puede tomar los valores WHITE, BLACK, DRAW.
Factoría - FactoriaPartidas
Clase de factoría para construir objetos de tipo Partidas.

Partidas leerPartidas(String nomfich):Crea un objeto de tipo Partidas a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.
Tipo Contenedor - Partidas
Clase contenedora de los objetos de tipo Partida.

Propiedades:

partidas, de tipo List<Partida>, consultable. Lista de partidas de ajedrez
numero partidas, de tipo Integer, consultable. Número de partidas del contenedor.
Constructores:

C1: Constructor por defecto. Creal un objeto de tipo Partidas sin ninguna partida almacenada.
C2: Constructor con un parámetro de tipo Collection<Partida>. Crea un objeto de tipo Partidas con las partidas incluidas en la colección dada como parámetro.
C3: Constructor con un parámetro de tipo Stream<Partida>. Crea un objeto de tipo Partidas con las partidas incluidas en el Stream dado
Criterio de igualdad: Dos partidas son iguales si lo son sus propiedades partidas.

Otras operaciones:

void agregarPartida(Partida p): Añade una partida de ajedrez al objeto.
Double getPromedioDuracionesMedias(TipoVictoria vic): Devuelve la media de la duración media(en segundos) por turno de las partidas. Si la media no se puede calcular, devuelve cero.
Map<String, Double> getPorcentajesSiguienteMovimiento(String movimiento, Integer numeroMovimiento): Devuelve un Map en el que las claves son movimientos siguientes al dado como parámetro (según el movimiento y la posición en la que se hace), y los valores el porcentaje de veces que se ha hecho ese movimiento. Por ejemplo, si el movimiento es "Nc6" y el número de movimiento es el 6, el Map contiene como claves los movimientos hechos en séptimo lugar tras un movimiento "Nc6". Los valores serán el porcentaje de veces que se han hecho esos movimientos. Eleva IllegalArgumentExceptionsi numeroMovimiento no es mayor o igual que uno.
Double getPorcentajeVictoriasDeApertura(String apertura, Resultado resultado): Devuelve el porcentaje de partidas que incluyen la cadena de apertura en su apertura y cuyo resultado es el dado como parámetro.
SortedSet getNPartidasMasCortas(Integer anyo, Integer n): Devuelve un conjunto ordenado con las n partidas más cortas jugadas en el año dado como parámetro. El conjunto estará ordenado por el número de movimientos de la partida.
List getNMejoresJugadores(Integer anyo, Integer n): Devuelve una lista con los ids de los n jugadores con más victorias en el año dado como parámetro.
Long getTiempoTotalJuego(String idJugador): Devuelve el total de minutos jugados por el jugador dado como parámetro.
String getJugadorMasVictorias(Integer anyo, Resultado resultado): Devuelve true si hay algún jugador que tenga más de n victorias.
Map<TipoVictoria, String> getGanadorNPorTipoVictoria(Integer n): Devuelve un map en el que las claves son los tipos de victoria y el valor es el enésimo jugador con más rating entre los jugadores que han tenido victorias de ese tipo. Es decir, si hacemos un ranking de los jugadores según su rating, nos quedaríamos con el que está en la posición n.
