package fp.test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.types.Group;
import fp.types.Race;
import fp.types.Season;


public class TestRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Season s = new Season(1);
		Season s2 = new Season(4);
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(0);
		l1.add(0);
		List<Integer> l2 = new ArrayList<>();
		l2.add(0);
		l2.add(0);
		l2.add(0);
		
		Race r1 = new Race(s,1,"2014 Beijing",LocalDate.of(2014, 9, 13),"Daniel Abt",66,"Audi Sport ABT",Group.AUDI,10,3,25,ParseBool(0),l1);
		Race r2 = new Race(s2,2,"2017 Hong Kong",LocalDate.of(2017,12,03),"Nelson Piquet Jr.",3,"Jaguar",Group.JAGUAR,12,11,45,ParseBool(0),l2);
		r1.setTeam_group(Group.NISSAN_RENAULT);
		System.out.println("r1 is " +r1.toString());
		System.out.println("r2 is " +r2.toString());
		System.out.println("r1 is equals to r2?" + r1.equals(r2));
		r2.setDriver("Fernando Alonso");
		System.out.println("r1 is equals to r2? " + r1.equals(r2));
		System.out.println("r1 compared to  r2  " + r1.compareTo(r2));
		
		//I don't know how to put the Duration and the List on the corresponding type here in the set

	}

	private static Boolean ParseBool(Integer i) {
		 {
			if (i == 1) {
			  return true;
			}
			else {
				return false;
			}
			
		}
	}

}
