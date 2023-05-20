package fp.types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utils.Checkers;





public class RaceFactory {
	public static Races readRaces(String fileName){
		Races races = null;
		
		try {
			Stream<Race> st = Files.lines(Paths.get(fileName))
						.skip(1)
						.map(RaceFactory::parseLine);
			races = new Races(st);
		
		}catch (IOException e) {
			e.printStackTrace();
		}
			
		return races;
	}
	
	
	public static Race parseLine(String line) {
		String[] values = line.split(";");	
		Checkers.check("Format line error", values.length==13);
		
		Integer seasonint = Integer.valueOf(values[0].trim());
		Season season = new Season(seasonint);
		Integer race_num = Integer.valueOf(values[1].trim());
		String race_name = values[2].trim();
		LocalDate race_date = LocalDate.parse(values[3].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String driver = values[4].trim();
		Integer car = Integer.valueOf(values[5].trim());
		String team = values[6].trim();
		Group team_group = Group.valueOf(values[7].trim());
		Integer rank = Integer.valueOf(values[8].trim());
		Integer grid = Integer.valueOf(values[9].trim());
		Integer laps = Integer.valueOf(values[10].trim());
		Boolean retired = parseB(values[11].trim());
		List<Integer> points = parsePoints(values[12]);
		
		return new Race(season, race_num, race_name, race_date, driver, car, team, team_group, rank, grid, laps, retired, points);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private static Boolean parseB(String s) {
		Boolean b = false;
		if (s.equals(1)) {
		 b = true;
		}
		return b;

		
	}
		
	
	private static List<Integer> parsePoints(String s) {
		String[] values = s.split(",");
		List<Integer> pts = new ArrayList<>();
		for (String v: values) {
			pts.add(Integer.valueOf(v.trim()));
		}
		return pts;
		}

				
				
				
				
				
	}
		
		
		
		
		
		
		
	

