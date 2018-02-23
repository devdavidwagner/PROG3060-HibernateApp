//PROG3060-Exercise 2
// DAVID WAGNER - 7256506
//CREATED 2/21/2018
//FINISHED 2/23/2018

//GEOGRAPHIC AREA CLASS


package prog3060.dwagner;

public class GeographicArea {
	
	public GeographicArea(int geoAreaID, int code, int level, String name, int altCode) {
		this.setGeoAreaID(geoAreaID);
		this.setCode(code);
		this.setLevel(level);
		this.setName(name);
		this.setAltCode(altCode);
		
		
	}
	
	private int geoAreaID;
	private int code;
	private int level;
	private String name;
	private int altCode;
	
	
	
	public int getGeoAreaID() {
		return geoAreaID;
	}
	public void setGeoAreaID(int geoAreaID) {
		this.geoAreaID = geoAreaID;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public int getAltCode() {
		return altCode;
	}



	public void setAltCode(int altCode) {
		this.altCode = altCode;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





}
