/*=================================================================================

Name:  Daniel Stoffel	
Date:  10/29/2018        
Desc: Lizard class that extends animal class for inheritance test

=================================================================================*/
public class lizard extends animal{
	private boolean sharpClaws;
	private int AvgBodyTemp;
	
	public lizard (boolean veg, String food, int legs)
		{
			super (veg, food, legs);
			this.sharpClaws = true;
			this.AvgBodyTemp = 100;
		}
	public lizard ()
	{
		super ();
		this.sharpClaws = true;
		this.AvgBodyTemp = 100;
	}
	public boolean getClaws (){
		return this.sharpClaws;
	}
	
	public void setClaws (boolean claw)
	{
		this.sharpClaws = claw;
	}
}
