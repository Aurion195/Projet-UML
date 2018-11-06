import Player.*;

/**
 * Création du 1000go (jeux de carte façon CERI)
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 */
public class Launcher 
{
	/**
	 * Launcher du game
	 * @param args = string ;
	 */
	public static void main(String[] args)
	{
		Player p = new Human("Thomas", "Auritas") ;
		p.addCard();
		p.displayDeck();
	}
}
