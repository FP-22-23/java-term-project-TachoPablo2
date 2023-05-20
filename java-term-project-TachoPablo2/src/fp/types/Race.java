package fp.types;


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
	private Integer laps;
	private Boolean retired;
	private List<Integer> ptsl;
	
	
	
	//Constructors
	
	public Race(Season season, Integer race_num, String race_name, LocalDate race_date, String driver, Integer car,
			String team, Group team_group, Integer rank, Integer grid, Integer laps, Boolean retired,
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
		this.retired = retired;
		this.ptsl = ptsl;
		
		
		Checkers.check("Wrong argument for rank.", rank> 0);
		Checkers.check("Wrong value for laps", laps >= 0);
	}
	
	//second constructor
	
	public Race(Season season, Integer race_num, String race_name, LocalDate race_date, String driver,Group team_group,
			String team,  Integer rank, Integer laps, Boolean retired,
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
		this.retired = retired;
		this.ptsl = ptsl;
		
		
		
		Checkers.check("Wrong argument for rank.", rank> 0);
		Checkers.check("Wrong value for laps", laps >= 0);
	}
	
	
	//getters and setters
	
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Integer getRace_num() {
		return race_num;
	}

	public void setRace_num(Integer race_num) {
		this.race_num = race_num;
	}

	public String getRace_name() {
		return race_name;
	}

	public void setRace_name(String race_name) {
		this.race_name = race_name;
	}

	public LocalDate getRace_date() {
		return race_date;
	}

	public void setRace_date(LocalDate race_date) {
		this.race_date = race_date;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Integer getCar() {
		return car;
	}

	public void setCar(Integer car) {
		this.car = car;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Group getTeam_group() {
		return team_group;
	}

	public void setTeam_group(Group team_group) {
		this.team_group = team_group;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getGrid() {
		return grid;
	}

	public void setGrid(Integer grid) {
		this.grid = grid;
	}

	public Integer getLaps() {
		return laps;
	}

	public void setLaps(Integer laps) {
		this.laps = laps;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public List<Integer> getPtsl() {
		return ptsl;
	}

	public void setPtsl(List<Integer> ptsl) {
		this.ptsl = ptsl;
	}
	
	
	//Hashcode and equals
	
	public int hashCode() {
		return Objects.hash(car, driver, grid, laps, ptsl, race_date, race_name, race_num, rank, retired, season, team,
				team_group);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		return Objects.equals(car, other.car) && Objects.equals(driver, other.driver)
				&& Objects.equals(grid, other.grid) && Objects.equals(laps, other.laps)
				&& Objects.equals(ptsl, other.ptsl) && Objects.equals(race_date, other.race_date)
				&& Objects.equals(race_name, other.race_name) && Objects.equals(race_num, other.race_num)
				&& Objects.equals(rank, other.rank) && Objects.equals(retired, other.retired)
				&& Objects.equals(season, other.season) && Objects.equals(team, other.team)
				&& team_group == other.team_group;
	}

	
	
	
	//natural order --> compares first the date of the race and then the position where the driver ended up
	
	
	public int compareTo(Race r) {
		int res = getRace_date().compareTo(r.getRace_date());
		if (res == 0) {
			res = getRank().compareTo(r.getRank());
			}
		return res;
	}
	
	
	
	public String toString() {
		return "Race [season=" + season + ", race_num=" + race_num + ", race_name=" + race_name + ", race_date="
				+ race_date + ", driver=" + driver + ", car=" + car + ", team=" + team + ", team_group=" + team_group
				+ ", rank=" + rank + ", grid=" + grid + ", laps=" + laps + ", retired=" + retired + ", ptsl=" + ptsl
				+ "]";
	}
	
	
	//derived property
	
	
	

	public Integer getYearRace() {
		return race_date.getYear(); //we could also have used return getRace_date().getYear()
	}
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
}
