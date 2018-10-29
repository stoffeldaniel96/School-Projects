/*=================================================================================

Name:  Daniel Stoffel	
Date:  10/29/2018        
Desc: Simple practice exercise in class extension and mutator operations.

=================================================================================*/
public class animalFarm {

	public static void main(String[] args) {
		lizard snake = new lizard();
		snake.setClaws(false);
		System.out.println("Snakes have claws? " + snake.getClaws());
	}

}
