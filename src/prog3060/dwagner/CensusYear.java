//PROG3060-Exercise 2
// DAVID WAGNER - 7256506
//CREATED 2/21/2018
//FINISHED 2/23/2018

//CENSUS YEAR CLASS

package prog3060.dwagner;

public class CensusYear {
	
	public CensusYear(int censusYearID, int censusYear){
		
		this.censusYearID = censusYearID;
		this.censusYear = censusYear;
		
	}
	
	private int censusYearID;
	private int censusYear;
	
	public int getCensusYearID() {
		return censusYearID;
	}
	public void setCensusYearID(int censusYearID) {
		this.censusYearID = censusYearID;
	}
	public int getCensusYear() {
		return censusYear;
	}
	public void setCensusYear(int censusYear) {
		this.censusYear = censusYear;
	}

}
