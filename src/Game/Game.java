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
	 * Supprime les malus que la carte d'immunité protège
	 * @param tmp = plateau de jeu du joueur ;
	 * @param e = carte choisit par le joueur ;
	 */
	private void delMalus(Vector<Vector<Card>> tmp, Card e)
	{
		if(!tmp.elementAt(2).isEmpty())
		{
			for(int i = 0 ; i < tmp.elementAt(2).size() ; i++)
			{
				if(tmp.elementAt(3).elementAt(i).getName().equals("Couche-tôt") && e.getName().equals("Panne de réveil"))
				{
					tmp.elementAt(2).removeElementAt(i);
				}
				
				if(tmp.elementAt(3).elementAt(i).getName().equals("Hélicoptère") && e.getName().equals("Travaux"))
				{
					tmp.elementAt(2).removeElementAt(i);
				}
				
				if(tmp.elementAt(3).elementAt(i).getName().equals("Santé de fer") && e.getName().equals("Maladie"))
				{
					tmp.elementAt(2).removeElementAt(i);
				}
				
				if(tmp.elementAt(3).elementAt(i).getName().equals("Proxy") && (e.getName().equals("Fête de trop") || e.getName().equals("Réseau down")))
				{
					tmp.elementAt(2).removeElementAt(i);
				}
			}
		}
	}
	
	/**
	 * Pose la carte Immunité et enlève les malus que cette carte protège
	 * @param tmp = plateau du joueur ;
	 * @param e = carte choisit par le joueur ;
	 */
	private void poseCardImmu(Vector<Vector<Card>> tmp, Card e)
	{
		tmp.elementAt(3).addElement(e);
		this.delMalus(tmp, e) ;
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
			String tmp = x.elementAt(2).elementAt(i).getName() ;
			
			if(tmp.equals("Panne de réveil") && e.getName().equals("Pile Atomique"))
			{
				x.elementAt(2).removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Travaux") && e.getName().equals("Bus Magique"))
			{
				x.elementAt(2).removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Maladie") && e.getName().equals("Mot du docteur"))
			{
				x.elementAt(2).removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Réseaux down") && e.getName().equals("Réseau Up"))
			{
				x.elementAt(2).removeElementAt(i);
				return true ;
			}
			else if(tmp.equals("Fête de trop") && e.getName().equals("Paracétamol"))
			{
				x.elementAt(2).removeElementAt(i);
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
	 * Vérifie si le joueur ne possède pas de carte d'immunité pour empèche la carte choisir par le joueur
	 * @param tmp = plateau du joueur choisit par l'attaque ;
	 * @param e = carte choisi par le joueur ;
	 * @return true s'il peut jouer / false sinon
	 */
	private boolean cardImmu(Vector<Vector<Card>> tmp, Card e)
	{
		if(!tmp.elementAt(3).isEmpty())
		{
			for(int i = 0 ; i < tmp.elementAt(3).size() ; i++)
			{
				if(tmp.elementAt(3).elementAt(i).getName().equals("Couche-tôt") && e.getName().equals("Panne de réveil")) return false ;
				if(tmp.elementAt(3).elementAt(i).getName().equals("Hélicoptère") && e.getName().equals("Travaux")) return false ;
				if(tmp.elementAt(3).elementAt(i).getName().equals("Santé de fer") && e.getName().equals("Maladie")) return false ;
				if(tmp.elementAt(3).elementAt(i).getName().equals("Proxy") && (e.getName().equals("Fête de trop") || e.getName().equals("Réseau down"))) return false ;
			}
		}
		
		return true ;
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
		if(!this.cardImmu(tmp, e)) return false ;
		
		Vector<Vector<Card>> x = player.elementAt(i).getPlateau() ;

		if(e.getName().equals("Deck.Fête_De_Trop") && !this.sameCard(tmp, e)) 
		{
			tmp.elementAt(2).addElement(e);
			return true ;
		}
		
		if(e.getName().equals("Réseau down") && !tmp.elementAt(0).isEmpty() && !this.sameCard(tmp, e))
		{
			System.out.println("Chute du réseau");
			tmp.elementAt(0).removeElementAt(0);
			return true ;
		}
		
		if(e.getType().equals("Deck.Card_Malus") && !tmp.elementAt(0).isEmpty() && !this.sameCard(tmp, e) && this.cardImmu(tmp, e))
		{
			tmp.elementAt(2).addElement(e);
			return true ;
		}
		else
		{
			System.out.println("Vous ne pouvez pas poser cette carte");
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
				boolean back = true ;
				if(back)
				{
					
					do {
						System.out.println("0 \n");
						e = player.elementAt(i).chooseCard() ;
						
						//Si le joueur choisit de jeter une carte
						if(e == null) break ;
						
						//Si la carte choisit est une carte Réseau up
						if(e.getName().equals("Réseau Up") && player.elementAt(i).getPlateau().elementAt(0).isEmpty())
						{
							player.elementAt(i).placeCard(e, 0);
							break ;
						}
						
						//Si la carte choisit est une carte pour avancer et qu'il a une carte Réseau Up active et pas de malus
						if(e.getType().equals("Deck.Card_Forward") && !player.elementAt(i).getPlateau().elementAt(0).isEmpty()
								&& player.elementAt(i).getPlateau().elementAt(2).isEmpty())
						{
							player.elementAt(i).placeCard(e, 1);
							break ;
						}
						
						//Si la carte choisit est une carte pour avancer et qu'il a seulement la carte fete de trop
						if(e.getType().equals("Deck.Card_Forward") && !player.elementAt(i).getPlateau().elementAt(0).isEmpty() && !player.elementAt(i).getPlateau().elementAt(2).isEmpty())
						{
							System.out.println("0");
							if(player.elementAt(i).cardFeteDeTrop() && (e.getName().equals("25") || e.getName().equals("50"))) 
							{
								player.elementAt(i).placeCard(e, 1);
								break ;
							}
						}
						
						//Si la carte jouer est un bonus qui peut annuler des malus que le joueur possède
						if(e.getType().equals("Deck.Card_Bonus") && !player.elementAt(i).getPlateau().elementAt(2).isEmpty() &&
								this.annuleMalus(player.elementAt(i).getPlateau(), e))
						{
							this.annuleMalus(player.elementAt(i).getPlateau(), e) ;
							player.elementAt(i).delCard(e);
							break ;
						}
						
						//Lorsque le joueur pose une carte immunité seulement quand il a une carte Réseau up active
						//Il pioche alors une carte
						if(e.getType().equals("Deck.Card_Immu") && !player.elementAt(i).getPlateau().elementAt(0).isEmpty())
						{
							this.poseCardImmu(player.elementAt(i).getPlateau(), e) ;
							player.elementAt(i).delCard(e);
							player.elementAt(i).pioche(deck.pioche());
							break ;
						}
						
						//Lorsque le joueur pose une carte malus il va choisir le joueur, et la fonction va voir qu'il n'a pas de carte immu qui va rendre le bonus inutilisable 
						if(e.getType().equals("Deck.Card_Malus") && 
							this.moveIsLegal(e, i, player.elementAt(i).choosePlayer(player,i))) 
						{
							player.elementAt(i).delCard(e);

							break ;
						}
						
						
						System.out.println("La carte choisit ne peut être posé, réesseyer !! ");
					} while(true) ; 
					back = false ;
				}

				
				System.out.println("Fin du tour \n \n");
				this.displayPlayer() ;
			}
			
		}
	}
}
