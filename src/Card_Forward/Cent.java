package Card_Forward;

import Deck.* ;
import java.util.*;

/**
 * Classe Cent, il s'agit d'une carte qui permet d'avancer, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Cent extends Card_Forward
{
	/**
	 * Constructeur de la classe
	 */
	public Cent()
	{
		super("100") ;
	}
	
	public boolean canForward(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && x.elementAt(2).isEmpty())
		{
			x.elementAt(1).addElement(this);
			return true ;
		}
		
		return false ;
	}
	
	public boolean canDefend(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	public boolean canImmu(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		return false ;
	}
}