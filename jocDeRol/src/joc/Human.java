package joc;
import ee.ee;

public class Human extends Player {
	
	// METODE CONSTRUCTOR DE L'HUMA
	public Human (String nom, int aP, int dP, int hP) {
		super (nom, aP, dP, hP);
		
		// CAPACITAT DEL HUMA
		// la vida del huma estara sempre limitada a 100
		
		if (hP > 100) this.setPuntsVida(100);
		ee.imprimir("He creat un Human\n");
	}
}
