package Card_Malus;

import java.util.*;
import Deck.Card;

public class Travaux extends Card_Malus 
{
	public Travaux()
	{
		super("Travaux") ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && !super.sameCard(x,this) && this.notImmu(x, "Hélicoptère"))
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