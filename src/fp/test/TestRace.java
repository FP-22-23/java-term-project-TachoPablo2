package fp.test;

import java.time.Duration;
import java.time.LocalDate;

import fp.types.Group;
import fp.types.Race;
import fp.types.Season;


public class TestRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Season s = new Season(1);
		Season s2 = new Season(4);
		
		Race r1 = new Race(s,1,"2014 Beijing",LocalDate.of(2014, 9, 13),"Daniel Abt",66,"Audi Sport ABT",Group.AUDI,10,10,3,25,"1:02.5071,1,0,0,1");
		Race r2 = new Race(s2,2,"2017 Hong Kong",LocalDate.of(2017,12,03),"Nelson Piquet Jr.",3,"Jaguar","Jaguar",12,12,11,45,"2:02.5071,0,0,0,0");
		r1.setTeam_group(Group.NISSAN_RENAULT);
		System.out.println("r1 is " +r1);
		System.out.println("r2 is " +r2);
		System.out.println("r1 is equals to r2?" + r1.equals(r2));
		r2.setDriver("Fernando Alonso");
		System.out.println("r1 is equals to r2?" + r1.equals(r2));
		System.out.println("r1 compared to  r2 " + r1.compareTo(r2));
		
		//I don't know how to put the Duration and the List on the corresponding type here in the set

	}

}
