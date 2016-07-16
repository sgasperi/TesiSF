package unibo.progettotesi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stop {
	private String name;
	private List<Line> lines;
	private int code;
	private List<Stop> sisters;
	private String site;
	private String municipality;
	private Location location;

	public Stop(Location location, int code, String name) {
		this.location = location;
		this.code = code;
		this.name = name;
		this.sisters = new ArrayList<Stop>();
		this.lines = new ArrayList<Line>();
	}

	public Stop(Location location, int code, String name, String site) {
		this.location = location;
		this.code = code;
		this.name = name;
		this.site = site;
		this.sisters = new ArrayList<Stop>();
		this.lines = new ArrayList<Line>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public void addLine(Line line){
		lines.add(line);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Stop> getSisters() {
		return sisters;
	}

	public void setSisters(List<Stop> sisters) {
		this.sisters = sisters;
	}

	public void addSister(Stop stop){
		sisters.add(stop);
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String savingString() {
		return location.savingString() + "®" + code + "®" + name + "®" + site;
	}

	public static Stop getStopFromString(String saved){
		StringTokenizer stringTokenizer = new StringTokenizer(saved, "®");
		return new Stop(Location.getLocationFromString(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken(), stringTokenizer.nextToken());
	}
}
