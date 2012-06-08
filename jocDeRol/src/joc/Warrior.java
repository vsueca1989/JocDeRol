package joc;

import ee.ee;

public class Warrior extends Human {
	
	// METODE CONSTRUCTOR DEL WARRIOR
	public Warrior (String nom, int aP, int dP, int hP) {
		// li pasarem al constructor de warrior els parametres del player creat
		super(nom, aP, dP, hP);
		ee.imprimir("He creat un Warrior\n");
	}
	
	// METODE ESPECIFIC PER A COLPEJAR DEL WARRIOR
	protected void hit (int aP) {
		
		// si volguerem traure el nom de la clase empleariem : this.getClass().getSimpleName()
	
		int restaVidaAtacant;	// variable per a guardar els punts de vida a restar
		
		// Si els punts d'atac del ATACANT son menors o iguals als punts de defensa del DEFENSOR
		// no llevem vida
		if (aP <= this.getPuntsDefensa()) {
			restaVidaAtacant = 0;
		}
		else {	// si els punts d'atac son majors si k en llevem
				// per tant, guardem els punts de vida a restar en restaVidaAtacant
			restaVidaAtacant = aP - this.getPuntsDefensa();
		}
		
		// CAPACITAT DEL WARRIOR
		// si la resta de vida del defensor es menor o igual a 5 no llevarem vida
		
		if (restaVidaAtacant <= 5) {
			restaVidaAtacant = 0;
		}
		
		// guardarem els punts de vida restants del DEFENSOR en una variable
		int vidaFinal = this.getPuntsVida() - restaVidaAtacant;

		// imprimirem x pantalla el proces d'atac i defensa
		// Ex:
		// DEFENSOR es atacat amb X punts datac i es defen amb Y punts de defensa
		// Mostrem el calcul: Punts de vida Defensor = Y - X = Resta de vida
		ee.imprimir(this.dades() + " és atacat amb " + aP + " i es defén amb " + this.getPuntsDefensa() + 
				". Vida: " + this.getPuntsVida() );
		
		// controlarem k la vida no baixe de 0
		// una volta aplegue a 0 es considerara k el defensor es mort
		
		if (restaVidaAtacant > getPuntsVida()) {
			this.setPuntsVida(0);
			vidaFinal = 0;
		}
		
		 ee.imprimir(" - " + restaVidaAtacant + " = " + (vidaFinal) + "\n");
		
		// Per últim fixarem els punts de vida finals del defensor 
		this.setPuntsVida(vidaFinal);
		
		
	}
}
