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
	 * Tableau du joueur, chaque joueur en a un
	 */
	Vector<Vector<Card>> plateau ;
	
	
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
		this.plateau = new Vector<Vector<Card>>() ;
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
	 * @param e = carte à ajouter ;
	 */
	public void addCard(Card e)
	{
			card.addElement(e);
	}
	
	/**
	 * Affiche le vector de carte du joueur
	 */
	public void displayDeck()
	{
		for(int i = 0 ; i < card.size() ; i++)
		{
			System.out.println(card.elementAt(i).getName());
		}
	}
	
	/**
	 * @param tmp = string contenant le choix du joueur ;
	 * @return true s'il a choisit la bonne carte
	 */
	private boolean chooseCard(String tmp)
	{
		return(tmp.equals("0") || tmp.equals("1") || tmp.equals("2") || tmp.equals("3") ||
				tmp.equals("4") || tmp.equals("5") 
				? true : false) ;
	}
	
	/**
	 * @return la carte que le joueur a choisit de jouer
	 */
	public Card chooseCard()
	{
		String tmp = "" ;
		
		do {
			Scanner sc = new Scanner(System.in) ;
			for(int i = 0 ; i < card.size() ; i++)
			{
				System.out.println(i+" -          "+card.elementAt(i).getName());
			}
			System.out.println("\n"+"Entrer une valeur : ");
			tmp = sc.nextLine() ;
			sc.close();
		} while(this.chooseCard(tmp)) ;
		
		return(card.elementAt(Integer.parseInt(tmp))) ;
	}
	
	/**
	 * @param tmp = String contenant le type ;
	 * @return true s'il peut attaquer / false sinon 
	 */
	public boolean canAttaque(String tmp)
	{
		return(tmp.equals("Deck.Card_Malus") ? true : false) ;
	}
	
	/**
	 * Permet de regarder si le player peut jouer ou non, en fonction du
	 * tableau du player
	 * @return true si le joueur peut jouer / false s'il ne peut pas
	 */
	public boolean canPlay()
	{
		if(plateau.isEmpty())
		{
			for(int i = 0 ; i < card.size(); i++)
			{
				String tmp = card.elementAt(i).getName() ;
				if(tmp.equals("Réseau Up"))
				{
					return true ;
				}
			}
		}
		else
		{
			if(plateau.elementAt(2).isEmpty())
			{
				return true ;
			}
			
			for(int i = 0 ; i < card.size(); i++)
			{
				String tmp = card.elementAt(i).getType() ;
				if(this.canAttaque(tmp))
				{
					return true ;
				}
			}
		}
		
		return false ;
	}
	
	
	public void pioche(Card e)
	{
		this.card.addElement(e);
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

	public Vector<Vector<Card>> getPlateau()
	{
		return this.plateau ;
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
