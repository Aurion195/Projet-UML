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
		this.deck = new Deck() ;
		this.player = new Vector<Player>() ;
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
	 * Vérifie si le move est légal en fonction de la carte choisit par le joueur
	 * @param e = carte du joueur ;
	 * @param i = place du joueur dans le vector player
	 * @return true si le move est acceptable / false sinon
	 * @throws Exception = Attrape l'exceptipon !
	 */
	private boolean moveIsLegal(Card e, int i) throws Exception
	{
		//Si le joueur choisit de jeter une carte
		if(e == null) return true ;
		

		if(e.canDefend(player.elementAt(i).getPlateau()))
		{
			player.elementAt(i).delCard(e);
			return true ;
		}


		if(e.canForward(player.elementAt(i).getPlateau()))
		{
			player.elementAt(i).addScore(Integer.parseInt(e.getName())) ;
			player.elementAt(i).delCard(e);
			return true ;
		}



		Vector<Vector<Card>> p = player.elementAt(i).choosePlayer(player, i) ;

		if(e.canAttaque(p))
		{
			player.elementAt(i).delCard(e);
			return true ;
		}


		if(e.canImmu(player.elementAt(i).getPlateau()))
		{
			player.elementAt(i).delCard(e);
			player.elementAt(i).pioche(deck.pioche());								//Quand le joueur joue une carte immu, il pioche de nouveau
			return true ;
		}

		return false ;
	}
	
	/**
	 * Fonction qui va gérer les tours du jeu
	 * @throws Exception = attrapre l'exception !
	 */
	public void beginGame() throws Exception
	{
		boolean winer = false ;
		Card e ;
		this.displayPlayer() ;
		while(!winer && !this.endOfGame())
		{
			for(int i = 0 ; i < this.player.size() ; i++)
			{
				System.out.println("\n \n \n \n");
				System.out.println("Tour du joueur : "+player.elementAt(i).getName());
				player.elementAt(i).pioche(deck.pioche());
				System.out.println("Le joueur pioche une carte");
				boolean back = true ;
				if(back)
				{
					
					do {
						e = player.elementAt(i).chooseCard() ;
						if(this.moveIsLegal(e, i))
						{
							break ;
						}
						
						System.out.println("La carte choisit ne peut être posé, réesseyer !! ");
					} while(true) ; 
					back = false ;
				}

				if(this.player.elementAt(i).win())
				{
					System.out.println("Le grand gagnat du concours est :"+this.player.elementAt(i).getPseudo());
					return ;
				}
				
				System.out.println("Fin du tour \n \n");
				this.displayPlayer() ;
			}
			
		}
	}
	
	/**
	 * Regarde si le deck est vide, dans le cas ou il est vide il affiche le pseudo du joueur qui a le plus gros score
	 * @return true si la pioche est vide / false sinon 
	 */
	private boolean endOfGame()
	{
		if(deck.vide())
		{
			String p = "" ;
			int max = 0 ;
			
			for(int i = 0 ; i < this.player.size() ; i++)
			{
				if(player.elementAt(i).getScorePlayer() > max)
				{
					max = player.elementAt(i).getScorePlayer() ;
					p = player.elementAt(i).getPseudo() ;
				}
			}
			
			System.out.println("Le grand vainqueur est :"+p) ;
			return true ;
		}
		
		return false ;
	}
}
