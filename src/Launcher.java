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
	 * @throws Exception = attrape l'exception !
	 */
	public static void main(String[] args) throws Exception
	{
		Player p = new Human("Thomas","Auritas") ;
		Player p1 = new Human("Nizar", "L'araben") ;
		Game game = new Game() ;
		game.addPlayer(p);
		game.addPlayer(p1);
		game.beginGame();
	}
}
