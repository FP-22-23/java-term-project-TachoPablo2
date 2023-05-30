package fp.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Races {


	private List<Race> races;
	
	public Races(Stream<Race> st) {
		races = st.collect(Collectors.toList());
	}
		
	public Races() {
			races = new ArrayList<Race>();
	}
	
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
			public Boolean existanceofDriver(String driver) {
				Boolean res = false;
				for(Race r:races) { //ask for the condition, set ex to true, stop the loop
					if(r.getDriver().equals(driver)) {
						res = true;
						break;
				  }
			  }
			  return res;
		  }
			
	//counter
			//counts the number of victories of the driver passed as parameter
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
			
	//filtering
			
		public Set<String> getDriversByGrid(Integer n){
			Set<String> s  = new HashSet<>();
			for(Race r: races) {
				if(r.getGrid()== n) {
					s.add(r.getDriver());
				}
		
			}
			return s;
		}
		
	//Map with values of type list
	//keys = number of victories, values = list of the drivers with that number of victories
		
	public Map<Integer, List<String>> getDriversByNumVictories(){
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
	
	//map with count
	//keys = driver, values = number of races disputed
	//hay alguna manera de hacerlo con count++?
	
	public Map <String, Integer> getNumberRacesByDriver(){
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
		
	
		
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
