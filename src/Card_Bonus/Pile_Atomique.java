package Card_Bonus;

import Deck.Card;
import java.util.*;

public class Pile_Atomique extends Card_Bonus 
{
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
