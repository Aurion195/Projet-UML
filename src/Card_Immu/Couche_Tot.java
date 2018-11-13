package Card_Immu;

import Deck.Card;
import java.util.*;

/**
 * Classe Couche_tot, il s'agit d'une carte d'immuniter, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Couche_Tot extends Card_Immu
{
	/**
	 * Constructeur de la classe
	 */
	public Couche_Tot()
	{
		super("Couche-tôt") ;
	}
	
	public boolean canImmu(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty())
		{
			this.delMalus(x,"Panne de réveil") ;
			x.elementAt(3).addElement(this);
			return true ;
		}
		
		return false ;
	}
	
	public boolean canDefend(Vector<Vector<Card>> x)
	{
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
}
