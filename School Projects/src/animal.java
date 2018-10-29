/*=================================================================================

Name:  Daniel Stoffel	
Date:  10/29/2018        
Desc: Animal class to be extended for class inheritance exercise.

=================================================================================*/
public class animal {
	private boolean vegetarian;
	private String eats;
	private int noOfLegs;
	
	public animal ()
	{
		vegetarian = true;
		eats = "grass";
		noOfLegs = 4;
	}
	
	public animal (boolean veg, String food, int legs)
	{
		this.vegetarian = veg;
		this.eats = food;
		this.noOfLegs = legs;
	}
	
	public boolean isVegetarian () 
	{
		return vegetarian;
	}
}
