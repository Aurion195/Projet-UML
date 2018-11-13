package Card_Bonus;

import Deck.Card;
import java.util.*;

public class Paracetamol extends Card_Bonus 
{
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