//PROG3060-Exercise 2
// DAVID WAGNER - 7256506
//CREATED 2/22/2018
//FINISHED 2/23/2018

//MAIN CLASS FOR HIBERNATE APP 
//RETURNS CENSUS DATA

package prog3060.dwagner;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateApplication
{

	
	//takes a ageGroup param and returns list of HQL query using that param
	@SuppressWarnings("unchecked")
	private static List<String> ageDataQuery(Session tempSession, Transaction tempTrans,
			SessionFactory tempSessionFact, int newCode, int ageGroup, int censusYear)
	{

	    try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  //INSERT NEW GEOAREA
	    
	
        
        GeographicArea newGA = new GeographicArea(499,2,"Frenchville", 24499);
        tempSession.save(newGA);
        CensusYear cy = tempSession.get(CensusYear.class, censusYear);
        AgeGroup ag = tempSession.get(AgeGroup.class, ageGroup);
        Age age = new Age(ag, cy, newGA, 199999, 10000, 9999);
        
  
        tempSession.save(age);
     

        
		
		List <String> ageResults = new ArrayList <String>();
                      
   
        String selectStringHQL = "SELECT a, ag, c, ga "
     	        + "FROM Age a "
        	    + "JOIN a.ageGroup ag " 
        	    + "JOIN a.censusYear c "
        	    + "JOIN a.geoArea ga "
        		+ "WHERE ag.ageGroupID = :ageGroup AND c.censusYearID = :censusYear "
        		+ "AND ga.altCode = :geoArea";
		
        

        Query <Object[]> tempQuery = tempSession.createQuery(selectStringHQL)
                .setParameter("ageGroup", ageGroup)
                .setParameter("censusYear", censusYear)
                .setParameter("geoArea", newCode);

        // Setting maximum number of results may be useful in some cases for pagination
        tempQuery.setMaxResults(25);
        
        //Retrieve the results from the database and store as a collection
        List <Object[]> tempResultList = tempQuery.getResultList();

        //Use an iterator to the collection to traverse the results
        Iterator <Object[]> tempResultListIterator = tempResultList.iterator();
        
        ageResults.add(String.format("%-20s", "Census Year")
                + String.format("%-15s", "Description")
                + String.format("%-25s", "Name")
                + String.format("%-25s", "Code")
                + String.format("%-25s", "Level")
                + String.format("%-25s", "AltCode")
                + String.format("%-25s", "Male")
                + String.format("%-25s", "Female")
                + String.format("%-25s", "Combined"));

        Boolean isfirst = true;
        String description = "";

        while (tempResultListIterator.hasNext())
        {

            Object[] resultSet = tempResultListIterator.next();
            
            Age ageTemp = (Age) resultSet[0];
            AgeGroup ageGroupTemp = (AgeGroup) resultSet[1];
            CensusYear censusYearTemp = (CensusYear) resultSet[2];
            GeographicArea geoAreaTemp = (GeographicArea) resultSet[3];

            if (isfirst)
            {

            	description = ageGroupTemp.getDescription();
            	isfirst = false;

            }

            String tempCensusYear = Integer.toString(censusYearTemp.getCensusYear());
            
            String tempDescription = ageGroupTemp.getDescription();
            String tempName = geoAreaTemp.getName();
            String code = Integer.toString(geoAreaTemp.getCode());
            String level = Integer.toString(geoAreaTemp.getLevel());
            String altcode = Integer.toString(geoAreaTemp.getAltCode());
            
            String male = Integer.toString(ageTemp.getMale());
            String female = Integer.toString(ageTemp.getFemale());
            String combined = Integer.toString(ageTemp.getCombined());

            ageResults.add(String.format("%-20s", tempCensusYear)
                    + String.format("%-15s", tempDescription)
                    + String.format("%-25s", tempName)
                    + String.format("%-25s", code)
                    + String.format("%-25s", level)
                    + String.format("%-25s", altcode)
                    + String.format("%-25s", male)
                    + String.format("%-25s", female)
                    + String.format("%-25s", combined));

        }


		
		return ageResults;		
	}

    @SuppressWarnings("unused")
	public static void main(String[] args)
    {

        Session tempSession = null;
        SessionFactory tempSessionFactory = null;
        Transaction tempTransaction = null;

        try {
        		
        	 Configuration tempConfiguration = new Configuration();
             tempConfiguration.configure("/resources/hibernate.cfg.xml");
  
             tempSessionFactory = tempConfiguration.buildSessionFactory();
         	tempSession = tempSessionFactory.openSession();
         	tempTransaction = tempSession.beginTransaction();
    		
            int newCode = 24499;
             int ageGroupID = 21;
             int censusYear = 1;
             
  
        
             List<String> queryOutput = ageDataQuery(tempSession, tempTransaction, tempSessionFactory,
            		 newCode, ageGroupID, censusYear);
             
             
             PrintOutput("Exersize 2 Report - David Wagner ", queryOutput);
             System.out.println("Report done.");

            if (tempTransaction != null)
				tempTransaction.rollback();

        }
        catch(Exception e)
        {

            if (tempTransaction != null)
            {

                tempTransaction.rollback();

            }

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        finally
        {
            if (tempSession != null)
            {
                tempSession.close();
            }
            tempSessionFactory.close();
        }

    }

    
    
    //Outputs query results into system console
    private static void PrintOutput(String reportOutputTitle, List <String> reportListOutput)
    {

        System.out.println("\\--------------------" + reportOutputTitle + "--------------------//" );
        System.out.println();

        for (String reportElement : reportListOutput)
        {

            System.out.println(reportElement);

        }
        System.out.println();
        System.out.println("\\------------------------------------------------------------------//");

    }

}



