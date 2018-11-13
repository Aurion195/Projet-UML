package Card_Malus;

import java.util.*;
import Deck.Card;

/**
 * Classe Maladie, il s'agit d'une carte qui permet d'attaquer, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Maladie extends Card_Malus 
{
	/**
	 * Constructeur de la classe
	 */
	public Maladie()
	{
		super("Maladie") ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && !super.sameCard(x,this) && this.notImmu(x, "Santé de fer"))
		{
			x.elementAt(2).addElement(this);
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
	
	public boolean canImmu(Vector<Vector<Card>> x)
	{
		return false ;
	}
}