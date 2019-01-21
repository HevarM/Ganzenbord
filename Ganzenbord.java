package ganz;

import java.util.*;

public class Ganzenbord {
	static ArrayList<Players> players = beginSpel();
//	Ganzenbord g = new Ganzenbord();

	
	
	public static void main(String[] args) {
		boolean spelBegin = true;
		while (!Players.winnaar) {
			for (Players p : players) {
				p.spelerBewegen(p.throwDice());
			} 
		}

	}

	public static ArrayList<Players> beginSpel() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welkom bij het spel Ganzenbord!");
		
		ArrayList<Players> players = new ArrayList<Players>();
		
		System.out.println("Met hoeveel spelers wil je spelen? ");
		int input = scanner.nextInt();
		
		for(int i = 0; i < input; i++) {
			System.out.println(("Speler " +(i+1)));
			String naam = scanner.next();
			players.add(new Players(naam));
			
		}
		return players;
	}

	public static boolean spelBegin () {
		return false;
		
	}
}
class Players {
	
	// Spelers info
			String naam;
			int positie;
			static public boolean winnaar;
			
			
			Players(String naam) {
				this.naam = naam;
				positie = 0;
				winnaar = false;
		}

	// Dobbelsteen
	    public int throwDice() {
	        int dice = (int) (Math.random() * 6) + 1;
	        return dice;
	       
	    }

	// Spelers posities
	    public void spelerBewegen (int dice) {
	    	if(winnaar == false) {
	    		positie += dice;
	    		System.out.println(naam+ " heeft " +dice+ " gegooid.");
	    		System.out.println("Je huidige positie is " +positie);
	    	}
	    	if (positie == 23) {
//	    		positie = -1000;
	    		System.out.println("Het spel is voorbij, iedereen heeft verloren!");
//	    		winnaar = true;
	    	}
	    	if (positie == 25 || positie == 45 || positie == 58) { 
	    		positie = 0;
	    		System.out.println("Helaas! " +naam+ " moet terug naar de start!");
	    	}
	    	if (positie == 42)  {
	    		positie = 39;
	    		System.out.println("Je bent in een doolhof beland! Ga terug naar plek 39!");
	    	}
	    	if (positie == 6) {
	    		positie = 12;
	    		System.out.println("Kijk eens...Een burg! Je mag hier oversteken!");
	    	}
	    	if (positie == 10 || positie == 20 || positie == 30 || positie == 40 || positie == 50 || positie == 60) {
	    		positie = positie + dice;
	    		System.out.println(naam+ " Wat een geluk!! Je mag nog een keer je aantal stappen nemen, je nieuwe positie is " +positie);
	    	}
	    	if (positie + dice >= 63) {
	    		positie += dice;
	    		winnaar = true;
	    		System.out.println(naam+ " heeft het spel gewonnen!!");
	            System.out.println("************************************");
	            System.out.println("*  QUACK!!! 63 of hoger, JIJ WINT! *");
	            System.out.println("*                                  *");
	            System.out.println("*               __1__              *");
	            System.out.println("           _____|   |____          *");
	            System.out.println("*          |            |          *");
	            System.out.println("************************************");
	    	}
	    
	}

		public void spelerPos() {
				System.out.println(naam + " begint op positie " +positie);			
		}
		
		public String toString() {
			return naam;
		}
	}
