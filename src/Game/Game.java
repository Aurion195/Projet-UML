package Game;
import Player.* ;
import Deck.* ;

import java.util.* ;

public class Game 
{
	Vector<Player> player ;
	Deck deck ;
	
	public Game()
	{
		deck = new Deck() ;
	}
	
	public void addPlayer(Player p)
	{
		this.player.addElement(p);
	}
	
	public void beginGame()
	{
		
	}
}
