package Player;
import Deck.*;
import java.util.* ;

public abstract class Player 
{
	String name ;
	String type ;
	String pseudo ;
	int scorePlayer ;
	Vector<Deck> deck ;
	
	public Player(String name, String pseudo)
	{
		this.name = name ;
		this.pseudo = pseudo ;
		this.scorePlayer = 0 ;
		this.type = this.getClass().getName() ;
		this.deck = new Vector<Deck>() ;
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
