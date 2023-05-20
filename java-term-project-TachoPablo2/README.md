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
team_group, de tipo enumerado, consultable.
rank, de tipo Integer, consultable.
grid, de tipo Integer, consultable.
laps, de tipo Long,, consultable.
duration, de tipo Duration, consultable.
retired, de tipo Boolean, consultable.
ptsl, de tipo list, consultable.
points, de tipo Integer, consultable.

Constructores:

C1: Tiene un parámetro por cada propiedad básica del tipo.
C2: Crea un objeto de tipo Race a partir de los siguientes parámetros: season, race_num, race_name, race_date, driver, team_group, team, rank, laps, duration, retired, ptsl 
Restricciones:

R1: El rango debe ser positivo mayor que cero.
R2: La duración debe ser positiva.

Criterio de ordenación: compara primero la fecha de la carrera y luego la posición en la que acaba el piloto.


