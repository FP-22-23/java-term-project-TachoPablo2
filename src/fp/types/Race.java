package fp.types;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utils.Checkers;

public class Race implements Comparable<Race> {
	
	
	//Attributes
	
	private Season season;
	private Integer race_num;
	private String race_name;
	private LocalDate race_date;
	private String driver;
	private Integer car;
	private String team;
	private Group team_group;
	private Integer rank;
	private Integer grid;
	private Long laps;
	private Duration duration;
	private Boolean retired;
	private List<Integer> ptsl;
	
	
	
	//Constructors
	
	public Race(Season season, Integer race_num, String race_name, LocalDate race_date, String driver, Integer car,
			String team, Group team_group, Integer rank, Integer grid, Long laps, Duration duration, Boolean retired,
			List<Integer> ptsl) {
		
		this.season = season;
		this.race_num = race_num;
		this.race_name = race_name;
		this.race_date = race_date;
		this.driver = driver;
		this.car = car;
		this.team = team;
		this.team_group = team_group;
		this.rank = rank;
		this.grid = grid;
		this.laps = laps;
		this.duration = duration;
		this.retired = retired;
		this.ptsl = ptsl;
		
		
		Checkers.check("Wrong argument for rank.", rank>= 0);
		Checkers.check("Wrong value for duation", duration.isNegative() == false);
	}
	
	//segundo constructor
	
	public Race(Season season, Integer race_num, String race_name, LocalDate race_date, String driver,Group team_group,
			String team,  Integer rank, Long laps, Duration duration, Boolean retired,
			List<Integer> ptsl ) {
		
		this.season = season;
		this.race_num = race_num;
		this.race_name = race_name;
		this.race_date = race_date;
		this.driver = driver;
		this.car = null;
		this.team = team;
		this.team_group = team_group;
		this.rank = rank;
		this.grid = null;
		this.laps = laps;
		this.duration = duration;
		this.retired = retired;
		this.ptsl = ptsl;
		
		
		
		Checkers.check("Wrong argument for rank.", rank>= 0);
		Checkers.check("Wrong value for duration", duration.isNegative() == false);
	}
	
	
	
	
	
	

	// Getters
	
	public Season getSeason() {
		return season;
	}
	
	public Integer getRace_num() {
		return race_num;
	}
	public String getRace_name() {
		return race_name;
	}
	public List<Integer> getPtsl() {
		return ptsl;
	}
	public LocalDate getRace_date() {
		return race_date;
	}
	public String getDriver() {
		return driver;
	}
	public Integer getCar() {
		return car;
	}
	public String getTeam() {
		return team;
	}
	public Group getTeam_group() {
		return team_group;
	}
	public Integer getRank() {
		return rank;
	}
	public Integer getGrid() {
		return grid;
	}
	public Long getLaps() {
		return laps;
	}
	public Duration getDuration() {
		return duration;
	}
	public Boolean getRetired() {
		return retired;
	}
	
	//setters
	
	
	

	public void setRace_num(Integer race_num) {
		this.race_num = race_num;
	}

	public void setRace_name(String race_name) {
		this.race_name = race_name;
	}

	public void setRace_date(LocalDate race_date) {
		this.race_date = race_date;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setCar(Integer car) {
		this.car = car;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setTeam_group(Group team_group) {
		this.team_group = team_group;
	}

	public void setRank(Integer rank) {
		
		Checkers.check("Wrong argument for rank.", rank>= 0);
		this.rank = rank;
	}

	public void setGrid(Integer grid) {
		this.grid = grid;
	}

	public void setLaps(Long laps) {
		this.laps = laps;
	}

	public void setDuration(Duration duration) {
		
		Checkers.check("Wrong value for duration", duration.isNegative() == false);
		this.duration = duration;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public void setPtsl(List<Integer> ptsl) {
		this.ptsl = ptsl;
	}

	
	
	
	
	
	//Hashcode & equals
	
	
	@Override
	public int hashCode() {
		return Objects.hash(car, driver, duration, grid, laps, ptsl, race_date, race_name, race_num, rank, retired,
				season, team, team_group);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		return Objects.equals(car, other.car) && Objects.equals(driver, other.driver)
				&& Objects.equals(duration, other.duration) && Objects.equals(grid, other.grid)
				&& Objects.equals(laps, other.laps) && Objects.equals(ptsl, other.ptsl)
				&& Objects.equals(race_date, other.race_date) && Objects.equals(race_name, other.race_name)
				&& Objects.equals(race_num, other.race_num) && Objects.equals(rank, other.rank)
				&& Objects.equals(retired, other.retired) && Objects.equals(season, other.season)
				&& Objects.equals(team, other.team) && team_group == other.team_group;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Race [season=" + season + ", race_num=" + race_num + ", race_name=" + race_name + ", race_date="
				+ race_date + ", driver=" + driver + ", car=" + car + ", team=" + team + ", team_group=" + team_group
				+ ", rank=" + rank + ", grid=" + grid + ", laps=" + laps + ", duration=" + duration + ", retired="
				+ retired + ", ptsl=" + ptsl + "]";
	}
	
	//natural order --> compares first the date of the race and then the position where the driver ended up
	public int compareTo(Race r) {
		int res = getRace_date().compareTo(r.getRace_date());
		if (res == 0) {
			res = getRank().compareTo(r.getRank());
			}
		return res;
	}
	
	
	
	//EDITAR ENUM Q ME FALTAN GRUPOS Y EDITAR CSV Y HACER TEST
		
		
	
	
	
	
	
	
	
	
	
	
	
	
}
