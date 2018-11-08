package Game;
import Player.* ;
import Deck.* ;

import java.util.* ;

public class Game 
{
	Vector<Player> player ;
	Deck deck ;
	
	/**
	 * Crée une instance unique d'un deck qui sera pour tous les players
	 */
	public Game()
	{
		deck = new Deck() ;
		player = new Vector() ;
	}
	
	/**
	 * Ajoute un player au vector, en même temps va créer le vector de card du joueur
	 * @param p = player à ajouter ;
	 */
	public void addPlayer(Player p)
	{
		this.player.addElement(p);
		for(int i = 0 ; i < 6 ; i++)
		{
			if(!deck.vide())													//Petite Sécurité
			{
				player.elementAt(player.size()-1).addCard(deck.pioche());
			}
		}
	}
	
	/**
	 * Regarde si la carte poser peut annuler
	 * @param x = plateau du joueur ;
	 * @param e = carte jouer ;
	 * @return true si la carte annule / false sinon
	 */
	private boolean annuleMalus(Vector<Vector<Card>> x, Card e)
	{
		for(int i = 0 ; i < x.elementAt(2).size() ; i++)
		{
			String tmp = x.elementAt(2).elementAt(i) .getName() ;
			
			if(tmp.equals("Panne de réveil") && e.getName().equals("Pile Atomique"))
			{
				return true ;
			}
			else if(tmp.equals("Travaux") && e.getName().equals("Bus Magique"))
			{
				return true ;
			}
			else if(tmp.equals("Maladie") && e.getName().equals("Mot du docteur"))
			{
				return true ;
			}
			else if(tmp.equals("Réseaux down") && e.getName().equals("Réseau Up"))
			{
				return true ;
			}
			else if(tmp.equals("Fête de trop") && e.getName().equals("Paracétamol"))
			{
				return true ;
			}
		}
		
		return false ;
	}
	
	/**
	 * @param tmp = vector de carte du joueur ;
	 * @param e = carte choisir par le joueur
	 * @return true si le joueur n'a pas déjà cette carte / false sinon
	 */
	private boolean sameCard(Vector<Vector<Card>> tmp, Card e)
	{
		if(!tmp.elementAt(2).isEmpty())
		{
			for(int i = 0 ; i < tmp.elementAt(2).size() ; i++)
			{
				if(tmp.elementAt(2).elementAt(i).getName().equals(e.getName())) return true ;
			}
		}
		
		return false ;
	}
	
	/**
	 * Verifie si le move que le joueur veut faire est légal
	 * @param e = carte ;
	 * @param i = indice du joueur ;
	 * @return true s'il peut jouer / false sinon 
	 */
	public boolean moveIsLegal(Card e, int i, Vector<Vector<Card>> tmp)
	{
		Vector<Vector<Card>> x = player.elementAt(i).getPlateau() ;
		
		if(e.getType().equals("Deck.Card_Forward"))
		{
			if(x.elementAt(2).isEmpty() && !x.elementAt(0).isEmpty())
			{
				return true ;
			}
		}
		if(e.getType().equals("Deck.Fete_De_Trop")) return true ;
		
		if(e.getType().equals("Deck.Card_Malus") && !tmp.elementAt(0).isEmpty() &&!this.sameCard(tmp, e))
		{
			return true ;
		}
		
		if(e.getType().equals("Deck.Card_Bonus"))
		{
			if(!x.elementAt(2).isEmpty())
			{
				if(this.annuleMalus(x, e))
				{
					return true ;
				}
			}
		}
		
		return false ;
	}
	
	/**
	 * Fonction qui va gérer les tours du jeu
	 * 
	 * @throws Exception
	 */
	public void beginGame() throws Exception
	{
		boolean win = false ;
		
		while(!win)
		{
			for(int i = 0 ; i < this.player.size() ; i++)
			{
				player.elementAt(i).pioche(deck.pioche());
				
				if(player.elementAt(i).canPlay(player))
				{
					boolean back = false ;
					
					do {
						if(this.moveIsLegal(player.elementAt(i).chooseCard(), i, player.elementAt(i).choosePlayer(player)))
						{
							back = true ;
						}
					}while(!back) ;
				}
				else
				{
					Card carte = player.elementAt(i).jetteCard() ;
					this.deck.jetteCard(carte);
				}
			}
		}
	}
}
