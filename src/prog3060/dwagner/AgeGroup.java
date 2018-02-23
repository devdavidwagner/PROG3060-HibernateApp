//PROG3060-Exercise 2
// DAVID WAGNER - 7256506
//CREATED 2/22/2018
//FINISHED 2/23/2018

//AGE GROUP CLASS

package prog3060.dwagner;

public class AgeGroup {
	
	public AgeGroup(int ageGroupID, String description)
	{
		this.ageGroupID = ageGroupID;
		this.description = description;
	}
	
	
	private int ageGroupID;
	private String description;
	
	public int getAgeGroupID() {
		return ageGroupID;
	}
	public void setAgeGroupID(int ageGroupID) {
		this.ageGroupID = ageGroupID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
