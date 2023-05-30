package fp.types;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Races {


	private List<Race> races;
	
	public Races(Stream<Race> rc) {
		races = rc.collect(Collectors.toList());
	}
		
	public Races() {
			races = new ArrayList<Race>();
	}
	public Races(Collection<Race> rc) {
		races = (List<Race>)rc;
	}
		
	// to get the number of items
	public Integer getSize() {
		return races.size();
	}
	
	
	//hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(races);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Races other = (Races) obj;
		return Objects.equals(races, other.races);
	}

	
	//toString
	
	
	@Override
	public String toString() {
		return "Races [races=" + races + "]";
	}
	
	//operations
	
	// to get the number of items
	public List<Race> getRaces(){
		return races;
		
	}
	
	//to add an item
	public void addRace(Race r) {
		races.add(r);
	}
	
	// to add a collection of items
	
	public void addRaces(List<Race> lr) {
		races.addAll(lr);
	}
	
	// to remove an item
	public void removeRace(Race r) {
		races.remove(r);
	}
	
	
	
	//other methods
	
	//existence
	
	//Checks if the driver put as parameter has raced in the FormulaE 
		/*	public Boolean existanceofDriver(String driver) {
				Boolean res = false;
				for(Race r:races) { //ask for the condition, set ex to true, stop the loop
					if(r.getDriver().equals(driver)) {
						res = true;
						break;
				  }
			  }
			  return res;
		  }*/
	
	
	
	//1
	public Boolean existanceofDriver(String driver) { //checks if the driver has raced in Formula E
		return races.stream().anyMatch(rc -> rc.getDriver().equals(driver));
	}
			
	//counter
		/*	//counts the number of victories of the driver passed as parameter
			public Integer numberVictoriesDriver(String driver) {
				Integer count = 0;
				for (Race r: races) {
					if(r.getDriver().equals(driver)) {
						if(r.getRank()==1) {
							count++;
						}
					}
				}
				return count;
			}
			*/
	
	
	//2
	public Integer numberVictoriesDriver(String driver) { //gets the number of wins of the driver passed as parameter
		return (int) races.stream()
				.filter(rc -> rc.getDriver().equals(driver)&& rc.getRank().equals(1)).count();
	}
	//filtering
			
		/*public Set<String> getDriversByGrid(Integer n){
			Set<String> s  = new HashSet<>();
			for(Race r: races) {
				if(r.getGrid()== n) {
					s.add(r.getDriver());
				}
		
			}
			return s;
		}
		*/
	
	
	//3
	public Set<String> getDriversByGrid(Integer n){ //returns a Set with the drivers who have started from the position passed as parameter.
		return  races.stream().filter(rc-> rc.getGrid().equals(n)).map(rc->rc.getDriver()).collect(Collectors.toSet());
	}
	//Map with values of type list
	//keys = number of victories, values = list of the drivers with that number of victories
		
	/*public Map<Integer, List<String>> getDriversByNumVictories(){
		 Map<Integer, List<String>> m = new HashMap<>();
		 for (Race r : races) {
			 if(m.containsKey(numberVictoriesDriver(r.getDriver()))){
				 m.get(numberVictoriesDriver(r.getDriver())).add(r.getDriver());
			 }
			 else {
				 List<String> drivers = new ArrayList<>();
				 drivers.add(r.getDriver());
				 m.put(numberVictoriesDriver(r.getDriver()), drivers);
			 }
			
		 }
		 return m;
	}
	*/
	
	//map with count
	//keys = driver, values = number of races disputed
	//hay alguna manera de hacerlo con count++?
	
	/*public Map <String, Integer> getNumberRacesByDriver(){
		Map<String, Integer> m = new HashMap<>();
		for (Race r: races) {
			if(m.containsKey(r.getDriver())) {
				m.put(r.getDriver(), m.get(r.getDriver())+1);
				
				}
			else {
				m.put(r.getDriver(), 1);
				}
		}
		return m;
	}
	*/
	//4: maximum/minimum with filtering
	
	public Integer bestRankDriver(String driver) { //returns the best position finish of the driver passed as parameter
		return races.stream()
				.filter(rc -> rc.getDriver().equals(driver))
				.min(Comparator.comparing(rc -> rc.getRank()))
				.orElse(null).getRank();
	}
	
	//5 : selection with filtering and sorting
	
	public List<Integer> getDriverFinishes(String name) { //returns a list with the finishes of the driver passed as parameter
		return races.stream().filter(rc -> rc.getDriver().equals(name))
				.sorted(Comparator.comparing(rc -> rc.getRank()))
				.map(rc -> rc.getRank())
				.collect(Collectors.toList()) ;
		
	}
	
	//6
	
	public Map <String, Long> getNumberRacesByDriver(){ // returns a map with keys of type string and values of type long.
														//The keys are the drivers and the values are the number of races disputed by the driver in the key
		return races.stream().collect(Collectors
				.groupingBy(rc -> rc.getDriver(),
						Collectors.counting()));
				
	}
	
	
	//7
	
	public Map <String, Integer> maxPositionByDriver(){ // returns a map with the driver and its best position finish
			return races.stream().collect(Collectors.groupingBy(rc -> rc.getDriver(),
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(rc -> rc.getRank())) , opt -> opt.orElse(null).getRank())));
		
		
	}
	
	
	
	
	//8 
	
	public Map <String, String> winnerByRace() { //returns a map which keys are the races and values are the driver who won the race in the key.
		 return  races.stream().collect(Collectors.groupingBy(rc -> rc.getRace_name(), 
				Collectors.collectingAndThen(Collectors
						.minBy(Comparator.comparing(rc -> rc.getRank())), opt -> opt.orElse(null).getDriver())));
		
		
	}
	
	

	//9
	
	//returns a SortedMap whose keys are the races of the season passed as parameter and whose values are the top n drivers in the race of the key
	
	
	public SortedMap<String, List<String>> topNDriversByRaceSeasonSorted2(Integer n, Season season) {
	    return races.stream()
	            .filter(race -> race.getSeason().equals(season))
	            .collect(Collectors.groupingBy(
	                    Race::getRace_name,
	                    TreeMap::new,
	                    Collectors.collectingAndThen(
	                            Collectors.toList(),
	                            racesList -> calculateTopNDriver2(racesList, n)
	                    )
	            ));
	}

	private List<String> calculateTopNDriver2(List<Race> racesList, Integer n) { //auxiliar function to calculate the top n
	    return racesList.stream()
	            .map(Race::getDriver)
	            .limit(n)
	            .collect(Collectors.toList());
	
	}
	
	
	//10
	
	public Map.Entry<String, Long> driverMostWins() { //returns the Map.Entry of the driver who has won most races. The key is the driver and the value the number of victories
		return races.stream()
				.filter(rc -> rc.getRank().equals(1))
				.collect(Collectors
				.groupingBy(rc -> rc.getDriver(),
						Collectors.counting()))
				.entrySet().stream()
				.max(Comparator.comparing(x -> x.getValue()))
				.orElse(null);
		
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
