package fp.test;

import fp.types.RaceFactory;
import fp.types.Races;
import fp.types.Season;

public class TestRaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Season s = new Season(1);
		
		Races races = RaceFactory.readRaces("data/formula_e_race_results4.csv");
		
		System.out.println("There are " + races.getSize() + " races.");
		
		//test of the functions
		
		System.out.println("Did Nyck de Vries race in Formula E? " + races.existanceofDriver("Nyck de Vries"));
		
		System.out.println("Nyck de Vries won " + races.numberVictoriesDriver("Nyck de Vries") + " races.");
		
		System.out.println(races.getDriversByGrid(1)+ " started from pole position.");
		
		//System.out.println(races.getDriversByNumVictories());
		
		System.out.println("The best postion finish of Nyck de Vries is " + races.bestRankDriver("Nyck de Vries"));
		
		System.out.println("The finishes of Nyck de Vries are:" + races.getDriverFinishes("Nyck de Vries"));
		
		System.out.println(races.getNumberRacesByDriver());
		
		System.out.println(races.maxPositionByDriver());
		
		System.out.println(races.winnerByRace());
		
		System.out.println(races.topNDriversByRaceSeasonSorted2(10,s));
		
		System.out.println(races.driverMostWins());
		
		
	}

}
