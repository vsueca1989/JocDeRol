package joc;
import ee.ee;

public class Alien extends Player {

	// METODE CONSTRUCTOR DE L'ALIEN
	public Alien (String nom, int aP, int dP, int hP) {
		super (nom, aP, dP, hP);
		
		ee.imprimir("He creat un Alien\n");
	}
	
	// METODE PER A ATACAR
	public void atac (Player p) {
		
		// si el atacant esta mort no podra atacar
		if (this.getPuntsVida() == 0) {
			ee.imprimir(this.getNom() + " està mort, no pot atacar\n");
		}
		else {	// si el atacant esta viu
			if (p.getPuntsVida() == 0) { 	// si el defensor esta mort
											// no podra ser atacat mes
				ee.imprimir(p.getNom() + " ja està mort!\n");
			}	
			else {	// si el defensor esta viu tambe, farem el proces datac
				
				// mostrarem qui ataca a qui
				ee.imprimir(this.dades() + " ataca a " + p.dades() + "\n");
				
				// el atacant colpejara al defensor
				
				// CAPACITAT DE L'ALIEN 
				// si la vida es superior a 20 la seua defensa es dividira entre 3
				if (this.getPuntsVida() > 20){
					p.hit(this.getPuntsAtac() * 3);
				}
				else {
					p.hit(this.getPuntsAtac());
				}
				
				// si el jugador no es mort despres de l'atac fara el contraatac
				
				if (p.getPuntsVida() != 0) this.hit(p.getPuntsAtac());
				
				// mostrarem els parametres dels 2 jugadors per pantalla despres de l'atac
				ee.imprimir("Resultat de l'atac: " + this.dades() + ", " + p.dades() + "\n");
			}
		}
	}
	
	// METODE PER A COLPEJAR
	protected void hit (int aP) {
		
		// si volguerem traure el nom de la clase empleariem : this.getClass().getSimpleName()
		int restaVidaDefensor;	// variable per a guardar els punts de vida a restar
				
		// Si els punts d' atac del ATACANT son menors o iguals als punts de defensa del DEFENSOR
		// no llevem vida
		
		// CAPACITAT DE L'ALIEN 
		// si la vida es superior a 20 la seua defensa es dividira entre 3
		if (this.getPuntsVida() > 20) {
			if (aP < (this.getPuntsDefensa() / 3)) {
				restaVidaDefensor = 0;
			}
			else {	// si els punts d'atac son majors si k en llevem
					// per tant, guardem els punts de vida a restar en restaVidaAtacant
				restaVidaDefensor = aP - (this.getPuntsDefensa() / 3);
			}
		}
		else {
			if (aP < this.getPuntsDefensa()) {
				restaVidaDefensor = 0;
			}
			else {
			restaVidaDefensor = aP - (this.getPuntsDefensa());
			}
		}

		// guardarem els punts de vida restants del DEFENSOR en una variable
		int vidaFinal = this.getPuntsVida() - restaVidaDefensor;

		
		// imprimirem x pantalla el proces d'atac i defensa
		// Ex:
		// DEFENSOR es atacat amb X punts datac i es defen amb Y punts de defensa
		// Mostrem el calcul: Punts de vida Defensor = Y - X = Resta de vida
		if (this.getPuntsVida() > 20) {
			ee.imprimir(this.dades() + " és atacat amb " + aP + " i es defén amb " + (this.getPuntsDefensa() / 3) +
					". Vida: " + this.getPuntsVida() );
		} else {
			ee.imprimir(this.dades() + " és atacat amb " + aP + " i es defén amb " + this.getPuntsDefensa() +
					". Vida: " + this.getPuntsVida() );
		}
				
		
		// controlarem k la vida no baixe de 0
		// una volta aplegue a 0 es considerara k el defensor es mort
		if (restaVidaDefensor > getPuntsVida()) {
			this.setPuntsVida(0);
			vidaFinal = 0;
		}
		
		 ee.imprimir(" - " + restaVidaDefensor + " = " + (vidaFinal) + "\n");
		
		// Per últim fixarem els punts de vida finals del defensor 
		this.setPuntsVida(vidaFinal);
		
		
	}
}
