package Card_Forward;

import Deck.* ;
import java.util.*;


public class Cinquante extends Card_Forward
{
	public Cinquante()
	{
		super("50") ;
	}
	
	public boolean canForward(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && x.elementAt(2).isEmpty())
		{
			return true ;
		}
		
		if(!x.elementAt(0).isEmpty())
		{
			if(x.elementAt(2).size()-1 == 0)
			{
				if(x.elementAt(2).elementAt(0).getName().equals("Fête de trop"))
				{
					x.elementAt(1).addElement(this);
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
