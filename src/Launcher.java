import Player.*;
import Game.* ;
import java.util.* ;
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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		Player p = new Human("Thomas","Auritas") ;
		Game game = new Game() ;
		game.addPlayer(p);
		game.beginGame();
	}
}
