package Game;
import Player.* ;
import Deck.* ;

import java.util.* ;

public class Game 
{
	/**
	 * Vector de player
	 */
	Vector<Player> player ;
	
	/**
	 * Deck du jeu
	 */
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
			player.elementAt(player.size()-1).addCard(deck.pioche());
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
				x.removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Travaux") && e.getName().equals("Bus Magique"))
			{
				x.removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Maladie") && e.getName().equals("Mot du docteur"))
			{
				x.removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Réseaux down") && e.getName().equals("Réseau Up"))
			{
				x.removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Fête de trop") && e.getName().equals("Paracétamol"))
			{
				x.removeElementAt(i);
				return true ;
			}
		}
		
		return false ;
	}
	
	/**
	 * Fonction permettant de regarder le joueur possède déjà la carte
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
	 * @param tmp = plateau du joueur ;
	 * @return true s'il peut jouer / false sinon 
	 */
	public boolean moveIsLegal(Card e, int i, Vector<Vector<Card>> tmp)
	{
		Vector<Vector<Card>> x = player.elementAt(i).getPlateau() ;

		if(e.getName().equals("Réseau Up") && tmp.elementAt(0).isEmpty())
		{
			tmp.elementAt(0).addElement(e);
			return true ;
		}
		
		if(e.getType().equals("Deck.Fete_De_Trop") && !this.sameCard(tmp, e)) 
		{
			tmp.elementAt(2).addElement(e);
			return true ;
		}

		if(e.getType().equals("Deck.Card_Malus") && !tmp.elementAt(0).isEmpty() &&!this.sameCard(tmp, e))
		{
			tmp.elementAt(2).addElement(e);
			return true ;
		}
		else
		{
			System.out.println("Le joueur n'a pas posé de carte Réseau Up ou alors il possède déjà cette carte malus ! ");
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
			else
			{
				System.out.println("Vous n'avez pas de malus");
			}
		}
		return false ;
	}
	
	/**
	 * Affiche les caractéristiques du joueur (nom et score)
	 */
	private void displayPlayer()
	{
		for(int i = 0 ; i < player.size() ; i++)
		{
			System.out.println("Nom = "+player.elementAt(i).getName()+" , score = "+player.elementAt(i).getScorePlayer()+"\n");
			player.elementAt(i).displayPlateau();
		}
	}
	
	/**
	 * Fonction qui va gérer les tours du jeu
	 * @throws Exception = attrapre l'exception !
	 */
	public void beginGame() throws Exception
	{
		boolean win = false ;
		Card e ;
		while(!win)
		{
			for(int i = 0 ; i < this.player.size() ; i++)
			{
				System.out.println("\n \n \n \n");
				System.out.println("Tour du joueur : "+player.elementAt(i).getName());
				player.elementAt(i).pioche(deck.pioche());
				System.out.println("Le joueur pioche une carte");
				
				if(player.elementAt(i).canPlay(player))
				{
					do {
						e = player.elementAt(i).chooseCard() ;
						
						if(e.getName().equals("Réseau Up"))
						{
							if(player.elementAt(i).getPlateau().elementAt(0).isEmpty())
							{
								player.elementAt(i).placeCard(e, 0);
							}
							
							break ;
						}
						
						if(e.getType().equals("Deck.Card_Forward") && !player.elementAt(i).getPlateau().elementAt(0).isEmpty()
								&& player.elementAt(i).getPlateau().elementAt(2).isEmpty())
						{
							player.elementAt(i).placeCard(e, 1);
							break ;
						}
						
						if(!e.getName().equals("Réseau Up") && !e.getType().equals("Deck.Card_Forward") && this.moveIsLegal(e, i, player.elementAt(i).choosePlayer(player,i))) 
						{
							break ;
						}
						
						
						System.out.println("La carte choisit ne peut être posé, réesseyer !! ");
					} while(true) ; 
				}
				else
				{
					System.out.println("Le joueur jette une carte");
					Card carte = player.elementAt(i).jetteCard() ;
					this.deck.jetteCard(carte);
				}
				System.out.println("Fin du tour");
				this.displayPlayer() ;
			}
		}
	}
}
