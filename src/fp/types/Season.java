package fp.types;

public record Season(Integer season) {
	public String getShortFormat() {
		return "This race belongs to the season " + season();
	}
	
	

}
