package Card_Bonus;

import Deck.Card;
import java.util.*;

public abstract class Card_Bonus extends Card
{
	String name ;
	
	public Card_Bonus(String name)
	{
		super(name,"Card_Bonus") ;
		this.name = name ;
	}
}