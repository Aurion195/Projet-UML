package Player;
import Deck.*;
import java.util.* ;

/**
 * Classe player
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 */

public abstract class Player 
{
	/**
	 * Nom du joueur
	 */
	String name ;
	
	/**
	 * Type du joueur (IA / humain)
	 */
	String type ;
	
	/**
	 * Pseudo du joueur
	 */
	String pseudo ;
	
	/**
	 * Score du joueur
	 */
	int scorePlayer ;
	
	/**
	 * Vector contenant toutes les cartes du joueur
	 */
	Vector<Card> card ;
	
	/**
	 * Initialisation de deck
	 */
	Deck deck = new Deck();
	
	
	/**
	 * Constructeur du Player
	 * @param name = nom du joueur ;
	 * @param pseudo = pseudo du joueur ;
	 */
	public Player(String name, String pseudo)
	{
		this.name = name ;
		this.pseudo = pseudo ;
		this.scorePlayer = 0 ;
		this.type = this.getClass().getName() ;
		this.card = new Vector<Card>() ;
	}
	
	/**
	 * @return true / false si le joueur à atteint les 1000go
	 */
	public boolean win()
	{
		return(this.scorePlayer == 1000 ? true : false) ;
	}

	/**
	 * Ajoute une carte au deck du joueur
	 */
	public void addCard()
	{
		for(int i = 0 ; i < 6 ; i++)
		{
			card.addElement(deck.giveCard());
		}
	}
	
	public void displayDeck()
	{
		for(int i = 0 ; i < card.size() ; i++)
		{
			System.out.println(card.elementAt(i).getName());
		}
	}
	
	/**
	 * @return le nom du joueur
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return le type du joueur
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * @return le pseudo du joueur
	 */
	public String getPseudo() 
	{
		return pseudo;
	}

	/**
	 * @return le score du joueur
	 */
	public int getScorePlayer() 
	{
		return scorePlayer;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Change le type de Player
	 * @param type = nouveau type ;
	 */
	public void setType(String type) 
	{
		this.type = type;
	}

	/**
	 * change le pseudo du player
	 * @param pseudo = nouveau pseudo ;
	 */
	public void setPseudo(String pseudo) 
	{
		this.pseudo = pseudo;
	}

	/**
	 * Change le score du player
	 * @param scorePlayer = nouveau score ;
	 */
	public void setScorePlayer(int scorePlayer) 
	{
		this.scorePlayer = scorePlayer;
	}
	
	
}
