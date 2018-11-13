package Card_Bonus;

import Deck.Card;
import java.util.*;

public class Reseau_Up extends Card_Bonus 
{
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