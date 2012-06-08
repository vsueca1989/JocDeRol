package joc;

import java.util.ArrayList;

import ee.ee;

public class Player {
	String nom;
	int puntsAtac, puntsDefensa, puntsVida;
	
	// array d'equips
	ArrayList<Team> teams = new ArrayList<Team>();
	
	// array d'items
	public ArrayList<Item> items = new ArrayList<Item>();
	
	
	// METODE CONSTRUCTOR DEL PLAYER
	public Player (String name, int aP, int dP, int hP) {
		nom = name;
		puntsAtac = aP;
		puntsDefensa = dP;
		puntsVida = hP;
		
		ee.imprimir("He creat un Player\n");
	}
	
	// METODES PER A FIXAR ELS PARAMETRES DEL JUGADOR
	void setNom (String n) { nom = n; }
	void setPuntsAtac (int a) { puntsAtac = a; }
	void setPuntsDefensa (int d) { puntsDefensa = d; }
	void setPuntsVida (int h) { puntsVida = h; }
	
	// METODES PER A RETORNAR ELS PARAMETRES DEL JUGADOR
	String getNom () { return nom; }
	int getPuntsAtac () { return puntsAtac; }
	int getPuntsDefensa () { return puntsDefensa; }
	int getPuntsVida () { return puntsVida; }
	
	// METODE PER A RETORNAR TOTES LES DADES DEL JUGADOR
	public String dades () {
		String dades = nom + " AP: " + puntsAtac + " DP: " + puntsDefensa + " HP: " 
			+ puntsVida + "(" + this.teams.size() + " teams)";
		
		if (!items.isEmpty()) {
			for (int i = 0; i < items.size(); i++) {
				if (i == 0) {
					dades += " amb " + this.items.get(i).nom + " " + this.items.get(i).atacBonus + "/" + this.items.get(i).defensaBonus;
				}
				else {
					dades += ", " + this.items.get(i).nom + " " + this.items.get(i).atacBonus + "/" + this.items.get(i).defensaBonus;
				}
				
			}
		}
		return  dades; 
	}
		
	// METODE PER A RETORNAR ELS OBJECTES DEL JUGADOR LLISTATS
	public String objJugador () {
		String objectes = "";
		for (int i = 0; i < this.items.size(); i++) {
			objectes += ((i + 1) + ". " + this.items.get(i).dades() + "\n");
		}
		return objectes;
	}
	
	// METODE PER A ATACAR
	public void atac (Player p) {
		
//		if (this.equals(p)) {
//			ee.imprimir(this.getNom() + " no pot atacar-se a si mateixa\n");
//		} else {
			// si el atacant esta mort no podra atacar
			if (this.getPuntsVida() == 0) {
				ee.imprimir(this.getNom() + " est� mort, no pot atacar\n");
			}
			else {	// si el atacant esta viu
				if (p.getPuntsVida() == 0) { 	// si el defensor esta mort
												// no podra ser atacat mes
					ee.imprimir(p.getNom() + " ja est� mort, tampoc te ralles!\n");
				}	
				else {	// si el defensor esta viu tambe, farem el proces datac
					
					// mostrarem qui ataca a qui
					ee.imprimir(this.dades() + " ataca a " + p.dades() + "\n");
					
					// el atacant colpejara al defensor
					p.hit(this.getPuntsAtac());
					
					// si el jugador es mort despres de l'atac ja no pot contraatacar
					// si es viu fara el contratac
					if (p.getPuntsVida() != 0) this.hit(p.getPuntsAtac());
					
					// mostrarem els parametres dels 2 jugadors per pantalla despres de l'atac
					ee.imprimir("Resultat de l'atac: " + this.dades() + ", " + p.dades() + "\n");
				}
			}
//		}
		
	}
	
	// METODE PER A COLPEJAR
	protected void hit (int aP) {
		
		// si volguerem traure el nom de la clase empleariem : this.getClass().getSimpleName()

		
		int restaVidaAtacant;	// variable per a guardar els punts de vida a restar
		
		// Si els punts d' atac del ATACANT son menors o iguals als punts de defensa del DEFENSOR
		// no llevem vida
		if (aP < this.getPuntsDefensa()) {
			restaVidaAtacant = 0;
		}
		else {	// si els punts d'atac son majors si k en llevem
				// per tant, guardem els punts de vida a restar en restaVidaAtacant
			restaVidaAtacant = aP - this.getPuntsDefensa();
		}
		
		// guardarem els punts de vida restants del DEFENSOR en una variable
		int vidaFinal = this.getPuntsVida() - restaVidaAtacant;

		// imprimirem x pantalla el proces d'atac i defensa
		// Ex:
		// DEFENSOR es atacat amb X punts datac i es defen amb Y punts de defensa
		// Mostrem el calcul: Punts de vida Defensor = Y - X = Resta de vida
		ee.imprimir(this.dades() + " �s atacat amb " + aP + " i es def�n amb " + this.getPuntsDefensa() + 
				". Vida: " + this.getPuntsVida() );
		
		// controlarem k la vida no baixe de 0
		// una volta aplegue a 0 es considerara k el defensor es mort
		if (restaVidaAtacant > getPuntsVida()) {
			this.setPuntsVida(0);
			vidaFinal = 0;
		}
		
		 ee.imprimir(" - " + restaVidaAtacant + " = " + (vidaFinal) + "\n");
		
		// Per �ltim fixarem els punts de vida finals del defensor 
		this.setPuntsVida(vidaFinal);
		
		
	}
	
	// METODE PER A A�ADIR TEAM AL PLAYER
	public void add (Team t) {
			// si el array d'equips no conte el team
			if (!teams.contains(t))		{
				// a�adim el equip al array d'equips
				teams.add(t);	
				// cridem a a�adir player al equip
				t.add(this);
			}	
	}
	
	// METODE PER A ESBORRAR AL PLAYER DEL TEAM
	public void remove (Team t) {
		// si el array d'equips conte el team
		if (teams.contains(t)) {
			// esborrem el equip del array d'equips
			teams.remove(t);
			// cridem a la funció per a borrar al jugador del equip
			t.remove(this);
		}
	}
	
	// METODE PER A A�ADIRLI ITEM AL PLAYER
	public void add (Item it) {
		items.add(it);
		
		if (!items.isEmpty()) {
			for (int i = 0; i < items.size(); i++) {
				this.puntsAtac += items.get(i).atacBonus;
				this.puntsDefensa += items.get(i).defensaBonus;
			}
		}
	}
	
	// METODE PER A ESBORRARLI ITEM AL PLAYER
	public void remove (Item it) {
		items.remove(it);
		
		if (!items.isEmpty()) {
			for (int i = 0; i < items.size(); i++) {
				puntsAtac -= items.get(i).atacBonus;
				puntsDefensa -= items.get(i).defensaBonus;
			}
		}
	}
	
	boolean equals (Player p) {
		if (this.equals(p))	{
			return true;
		}
		else {
			return false;
		}
	}

//	public boolean contains(Item item) {
//		if (this.contains(item)) return true;
//		else return false;
//	}

}
