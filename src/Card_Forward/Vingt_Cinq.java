package Card_Forward;

import Deck.* ;
import java.util.*;

/**
 * Classe Vingt_Cinq, il s'agit d'une carte qui permet d'avancer, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Vingt_Cinq extends Card_Forward
{
	/**
	 * Constructeur de la classe
	 */
	public Vingt_Cinq()
	{
		super("25") ;
	}
	
	public boolean canForward(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && x.elementAt(2).isEmpty())
		{
			x.elementAt(1).addElement(this);
			return true ;
		}
		
		if(!x.elementAt(0).isEmpty())
		{
			if(x.elementAt(2).size()-1 == 0)
			{
				if(x.elementAt(2).elementAt(0).getName().equals("Fête de trop"))
				{
					return true ;
				}
			}
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
