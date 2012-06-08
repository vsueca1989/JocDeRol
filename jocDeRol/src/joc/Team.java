package joc;

import java.util.ArrayList;

public class Team {
	String nom;
	
	// array de players
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Team (String n) {
		this.nom = n;
	}
	
	// METODE PER A A�ADIR PLAYER AL TEAM
	public void add (Player p) {
			// si el array d'equips no conte el team
			if (!players.contains(p))		{
				// a�adim el equip al array d'equips
				players.add(p);	
				// cridem a a�adir team al player
				p.add(this);
			}
	}
	
	public void remove (Player p) {
		// si el array d'equip conte el t
		if (players.contains(p)) {
			players.remove(p);
			p.remove(this);
		}
	}
	
	public ArrayList<Player> getMembers () {
		return players;
	}
	
	boolean equals (Team t) {
		if (this.equals(t))		return true;
		else					return false;
	}
	
	public String dades () { 
		String dades;
		dades = "Equip " + nom + " (";
		
		for (int i = 0; i < this.players.size(); i ++){
			if (i != 0) {
				dades += "  ";
			}
			dades += players.get(i).dades();
		}
		dades += ")";
		return dades;
	}
}
