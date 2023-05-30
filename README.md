# java-term-project-TachoPablo2
java-term-project-TachoPablo2 created by GitHub Classroom



Project of the Second term
Autor/a: Pablo Romero Gómez, uvus: GFQ0792

This project is an adaptation of the one from  the student Pablo Diego Acosta, on the 

Este proyecto es una adaptación del proyecto presentado por el estudiante Pablo Diego Acosta,on the course 2021/22.

Structure of the project
/src: Directory with the source code.
fp.types:Package which contains the types of the project.
fp.test: Package that contains the test classes of the project.
fp.utils: Package that contains the utility classes.
/data: Contains the dataset of the project.
formula_e_race_reesults4.csv: Archivo csv que contiene datos de diferentes partidas de ajedrez.
Estructura del dataset
The original dataset Formula_e_raceresultscan be obtained from the URL https://www.kaggle.com/datasets/mlandry/formula-e-championship. Originally it had 17 columns y each row contains data about one race of Formula E. The dataset used has 13 columns. Now we will describe the 13 columns of the dataset:

season: of type integer, shows the number of the season, that is, if it is number one, two, etc.
race_num : of type integer, shows the number of the race in the season.
race_name : of type String, it shows the date and the name of the circuit in which it is raced.
race_date: of type LocalDate, date on which the race takes place.
driver: of type String, name of the driver.
car: of type Integer, number of the car.
team: of type String, the team of the pilot who is running.
team_group: of type String, group of teams to which the team of the pilot who is racing belongs
rank: of type integer, position in which the pilot finished.
grid: of type integer, starting position on the driver's grid.
laps: Integer type, number of laps in the race
retired: of type boolean, it is true when the pilot retired from the test.
ptsl: of type list, list containing the rank, pole and bonus points.


Implemented types
The types that have been implemented in the project are the following:

Base Type - Race
It represents a specific race. Properties:

season, of type Season, queryable. (is the auxiliary type)
race_num, of type Integer, queryable.
race_name, of type String, queryable.
race_date, of type LocalDate, queryable.
driver, of type String, queryable.
car, of type Integer, queryable.
team, of type String, queryable.
team_group, of type enumerated, queryable.
rank, of type Integer, queryable.
grid, of type Integer, queryable.
laps, of type Long,, queryable.
retired, of type Boolean, queryable.
ptsl, of type list, queryable.

Constructors:

C1: It has a parameter for each basic property of the type.
C2: Create an object of type Race from the following parameters: season, race_num, race_name, race_date, driver, team_group, team, rank, laps,  retired, ptsl
restrictions:

R1: The range must be positive greater than zero.
R2: The number of laps has to be positive

Order criteria: first compares the date of the race and then the position in which the driver finishes.

Type RaceFactory:
does the conversion from the strings of the csv to the corresponding datatype of each field. Has two methods: one for reading the lines of the file and another for parsing those lines into the corresponding datatypes.

Type Races:

has the property races, which is a list of type Race.
It had the following methods in delivery 2: two constructors, one from an empty list and one with a collection; one to get the size, the hashcode and equals; the toString method, one to get all the items, one to add an item, another to add a collection of items, another to remove an item, another to check if a driver has raced in Formula E, another to get the number of victories of the driver passed as parameter, another to filter the drivers by grid position, another which returns a map with keys = to the number of victories and values a list of drivers, and the last one returns a map with keys = drivers and values = number of races in which the driver has participated.

Now in delivery 3, we have some updates: 
We have a new  constructor from a stream and some methods have been changed to streams and some created:
- Boolean existanceofDriver(String driver)  which checks if the driver has raced in Formula E (now done with streams).
- Integer numberVictoriesDriver(String driver)  which gets the number of wins of the driver passed as parameter (now done with streams).
- Set<String> getDriversByGrid(Integer n) which returns a Set with the drivers who have started from the position passed as parameter (now done with streams).
- Integer bestRankDriver(String driver)  which returns the best position finish of the driver passed as parameter.
- List<Integer> getDriverFinishes(String name) which returns a list with the finishes of the driver passed as parameter.
-  Map <String, Long> getNumberRacesByDriver() which returns a map with keys of type string and values of type long. The keys are the drivers and the values are the number of races disputed by the driver in the key (now done with streams)
- Map <String, Integer> maxPositionByDriver() which returns a map with the driver and its best position finish
- Map <String, String> winnerByRace() which returns a map which keys are the races and values are the driver who won the race in the key.
- SortedMap<String, List<String>> topNDriversByRaceSeasonSorted2(Integer n, Season season) which returns a SortedMap whose keys are the races of the season passed as parameter and whose values are the top n drivers in the race of the key. It uses an auxiliary function to calculate the top n drivers of the list.
- Map.Entry<String, Long> driverMostWins()  which returns the Map.Entry of the driver who has won most races. The key is the driver and the value the number of victories
	

Type Group:
enumerated type with all the team groups.

Type Season:
record which converts an Integer into this new type. (is the auxiliary type).
Has a method to get the short format.

