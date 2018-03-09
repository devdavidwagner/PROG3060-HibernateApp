//PROG3060-Exercise 2
// DAVID WAGNER - 7256506
//CREATED 2/22/2018
//FINISHED 2/23/2018

//AGE CLASS

package prog3060.dwagner;

public class Age {
	public Age() {};
	public Age(AgeGroup ageGroup, CensusYear censusYear, GeographicArea geoArea, int combined, int female, int male)
	{
	
		this.ageGroup = ageGroup;
		this.censusYear = censusYear;
		this.geoArea = geoArea;
		this.combined = combined;
		this.female = female;
		this.male = male;
	}

	private int ageID;
	
	private GeographicArea geoArea;
	private AgeGroup ageGroup;
	private CensusYear censusYear;
	
	private int combined;
	private int female;
	private int male;
	
	public int getAgeID() {
		return ageID;
	}
	public void setAgeID(int ageID) {
		this.ageID = ageID;
	}
	public CensusYear getCensusYear() {
		return censusYear;
	}
	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}
	public GeographicArea getGeoArea() {
		return geoArea;
	}
	public void setGeoArea(GeographicArea geoArea) {
		this.geoArea = geoArea;
	}
	public AgeGroup getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}
	public int getCombined() {
		return combined;
	}
	public void setCombined(int combined) {
		this.combined = combined;
	}
	public int getFemale() {
		return female;
	}
	public void setFemale(int female) {
		this.female = female;
	}
	public int getMale() {
		return male;
	}
	public void setMale(int male) {
		this.male = male;
	}
	
	
}
