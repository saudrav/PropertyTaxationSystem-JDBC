# PropertyTaxationSystem-JDBC


I.	BUSINESS SCENARIO

The City corporation plans to offer discounts to the loyal property owners in the city who pay the property taxes on time. The discount is calculated based on the category of the property and the area of the property. Corporation wants to automate the process of taxation &calculation of discounted tax.

The property tax  details of  citizens of the city are stored in a .txt file (as a comma separated fields). This file contains the details/records of the properties/tax liabilities  of both commercial and residential properties. But the discount  is applicable only to the citizens who pay the taxes before the stipulated deadline. 

The proposed system is supposed to pick up the citizens’ property details , whose actual payment dates are before the stipulated payment dates (which are pre-defined), and then the revised Tax Liability is calculated based on the city corporation administrative policy, as mentioned in the below requirement specification. After the Revised Tax is applied , the system needs to persist those records in the database.


Design Constraints ::
a.	The database.properties has connection details required to connect to the backend 
b.	Do not change the keys of the property files, you can update the values based on the local database settings. For example, do not change the key, db.username. Rather you can have any value as user name based on local settings. 
c.	Use only JDBC to establish Database connection 
d.	Assume the location of the property file will be always as given in the skeleton.  
e.	Don’t Hardcode the connection string to establish database connection. Read it from property files. 
f.	Use Prepared Statement to insert records 
g.	Close all the resources after use 
h.	Catch all database related exception and throw Application specific exception only from DAO or from DBConnectionManager class. There has to be a constructor in DBConnectionManager class, to load the database property file and to establish a database connection using JDBC .
i.	Rollback the Insert if any SQL exception has occurred. Throw application specific exception, PropertyTaxPytException
j.  You may have to convert the java.util.date to java.sql.date before storing to database.
k.	Calculate the taxDiscount based on the constraints in the table given below

Property Type	  AreaInSqFt	    Discount
Commercial	      <=1000	        7%
Commercial	   1001 to 10000	    10%
Commercial	      >10000	        13%
Residential	      <=1000	        5%
Residential	  1001 to 10000	      9%
Residential	      >10000	        11%




