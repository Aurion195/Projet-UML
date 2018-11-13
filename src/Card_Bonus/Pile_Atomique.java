package Card_Bonus;

import Deck.Card;
import java.util.*;

/**
 * Classe Pile_Atomique, il s'agit d'une carte de défense, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Pile_Atomique extends Card_Bonus 
{
	/**
	 * Constructeur de la classe
	 */
	public Pile_Atomique()
	{
		super("Pile atomique") ;
	}
	
	public boolean canDefend(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(2).isEmpty())
		{
			for(int i = 0 ; i < x.elementAt(2).size(); i++)
			{
				if(x.elementAt(2).elementAt(i).getName().equals("Panne de réveil"))
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
