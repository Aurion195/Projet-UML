package Card_Bonus;

import Deck.Card;
import java.util.*;

/**
 * Classe Réseau Up, il s'agit d'une carte de défense, cette carte connait ses propres règles et ses conditions de de mise en place
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Reseau_Up extends Card_Bonus 
{
	/**
	 * Constructeur de la classe
	 */
	public Reseau_Up()
	{
		super("Réseau up") ;
	}
	
	public boolean canDefend(Vector<Vector<Card>> x)
	{
		if(x.elementAt(0).isEmpty())
		{
			x.elementAt(0).addElement(this);
			return true ;
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