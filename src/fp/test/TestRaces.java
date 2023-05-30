package fp.test;

import fp.types.RaceFactory;
import fp.types.Races;

public class TestRaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Races races = RaceFactory.readRaces("data/formula_e_race_results4.csv");
		
		System.out.println("There are " + races.getSize() + " races.");
		
		System.out.println("Did Nyck de Vries race in Formula E? " + races.existanceofDriver("Nyck de Vries"));
		
		System.out.println("Nyck de Vries won " + races.numberVictoriesDriver("Nyck de Vries") + " races.");
		
		System.out.println(races.getDriversByGrid(1)+ " started from pole position.");
		
		System.out.println(races.getDriversByNumVictories());
		
		System.out.println(races.getNumberRacesByDriver());

	}

}
