package Card_Bonus;

import Deck.Card;
import java.util.*;

/**
 * Classe Paracétamol, il s'agit d'une carte de défense, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Paracetamol extends Card_Bonus 
{
	/**
	 * Constructeur de la classe
	 */
	public Paracetamol()
	{
		super("Paracétamol") ;
	}
	
	public boolean canDefend(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(2).isEmpty())
		{
			for(int i = 0 ; i < x.elementAt(2).size(); i++)
			{
				if(x.elementAt(2).elementAt(i).getName().equals("Fête de trop"))
				{
					x.elementAt(2).removeElementAt(i);
					return true ;
				}
			}
		}
		
		return false ;
	}
	
	public boolean canForward(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	public boolean canImmu(Vector<Vector<Card>> x)
	{
		return false ;
	}
}