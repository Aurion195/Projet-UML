package Card_Bonus;

import Deck.Card;
import java.util.*;

/**
 * Constructeur de le classe carte Bus_Magique
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Bus_Magique extends Card_Bonus 
{
	/**
	 * Constructeur de la classe
	 */
	public Bus_Magique()
	{
		super("Bus magique") ;
	}
	
	/**
	 * Regarde si la carte sert à quelque choses pour le joueur qui veut se défendre
	 * il pourra la poser seulement s'il a la carte malus qui est approprié avec elle
	 * S'il peut jouer il pose alors la carte
	 * @param x = plateau du joueur
	 * @return true s'il peut jouer / false sinon
	 */
	public boolean canDefend(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(2).isEmpty())
		{
			for(int i = 0 ; i < x.elementAt(2).size(); i++)
			{
				if(x.elementAt(2).elementAt(i).getName().equals("Travaux"))
				{
					x.elementAt(2).removeElementAt(i);
					return true ;
				}
			}
		}
		
		return false ;
	}
	
	/**
	 * Fonction abstraite de la classe Forward
	 * Si le joueur rentre dedans avec la mauvaise carte elle renvoi false
	 * @return 
	 */
	public boolean canForward(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	/**
	 * Fonction abstraite de la classe Malus
	 */
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	/**
	 * Fonction abstraite de la classe Immu
	 */
	public boolean canImmu(Vector<Vector<Card>> x)
	{
		return false ;
	}
}
