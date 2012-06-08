package joc;

public class Item {
	String nom;
	int atacBonus, defensaBonus;
	
	public Item (String n, int aB, int dB) {
		nom = n;
		atacBonus = aB;
		defensaBonus = dB;
	}
	
	public String dades() {
		return nom + " " + atacBonus + "/" + defensaBonus;
	}
}
