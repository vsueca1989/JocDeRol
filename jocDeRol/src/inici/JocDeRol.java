package inici;

import java.util.ArrayList;

import joc.Alien;
import joc.Human;
import joc.Item;
import joc.Player;
import joc.Team;
import joc.Warrior;
import joc.Team;
import ee.ee;

public class JocDeRol {

	public static void main(String[] args) {
		menu();
	}
	
	public static void prova1 () {
		ee.imprimir("Vaig a crear un humï¿½\n");
		Human huma = new Human("Vï¿½ctor", 44, 15, 120);
		ee.imprimir("Vaig a crear un guerrer\n");
		Warrior guerrer = new Warrior("guerrer", 23, 64, 56);
		ee.imprimir("Vaig a crear un alien\n");
		Alien alien = new Alien("E.T.", 22, 33, 44);
	}
	
	public static void prova2 () {
		ee.imprimir("Vaig a crear un humï¿½\n");
		Human huma = new Human("Vï¿½ctor", 44, 15, 120);
		ee.imprimir("Vaig a crear un guerrer\n");
		Warrior guerrer = new Warrior("guerrer", 23, 60, 56);
		ee.imprimir("Vaig a crear un alien\n");
		Alien alien = new Alien("E.T.", 22, 33, 44);
		huma.atac(guerrer);
		alien.atac(guerrer);
		guerrer.atac(alien);
		alien.atac(guerrer);
	}
	
	public static void prova3 () {
		Human huma = new Human("Vï¿½ctor", 44, 15, 120);
		Warrior guerrer = new Warrior("guerrer", 23, 60, 56);
		Alien et = new Alien("E.T.", 22, 33, 44);
		Human kaupa = new Human("Kaupa", 0, 100, 6);
		Warrior aniseto = new Warrior("Aniseto", 50, 44, 75);
		Alien galindo = new Alien("Galindo", 12, 66, 77);
		
		Team valencia = new Team("Valencieta");
		Team marcianos = new Team("Marcianos");
		
		ee.imprimir(aniseto.dades() + "\n");
		Item chepa = new Item ("Chepa de camello", -5, 50);
		Item orelles = new Item ("Orelles de Dumbo", 10, 10);
		
		huma.add(valencia);
		et.add(valencia);
		guerrer.add(valencia);
		
		galindo.add(marcianos);
		
		kaupa.add(marcianos);
		aniseto.add(orelles);
		
		ee.imprimir(valencia.dades() + "\n");
		et.add(marcianos);
		ee.imprimir(marcianos.dades() + "\n");
		
		aniseto.add(chepa);
		
		ee.imprimir(aniseto.dades() + "\n");
		
		kaupa.remove(marcianos);
		valencia.remove(et);
		
		ee.imprimir(kaupa.dades() + "\n");
		ee.imprimir(marcianos.dades() + "\n");
		ee.imprimir(valencia.dades() + "\n");
	}
	
	public static void prova4()	{
		Human huma = new Human("Vï¿½ctor", 44, 15, 120);
		Warrior aniseto = new Warrior("Aniseto", 50, 44, 75);
		
		Item chepa = new Item ("Chepa de camello", -5, 50);
		Item nas = new Item ("Nariz aguileï¿½a", 5, 10);
		
		aniseto.add(nas);
		aniseto.add(chepa);
		
		ee.imprimir(aniseto.objJugador());
//		ee.imprimir(huma.dades() + ", " + aniseto.dades() + "\n");
		
//		huma.atac(aniseto);
//		huma.atac(aniseto);
//		huma.atac(aniseto);
//		aniseto.atac(huma);
	}
	
	public static void menu () {
		// variables menu principal
		int opcioMP = -1;
		boolean eixir = false;
		
		ArrayList<Player> jugadors = new ArrayList<Player>();
		
		ArrayList<Team> equips = new ArrayList<Team>();
	
		ArrayList<Item> objectes = new ArrayList<Item>();
		
		// MENU PRINCIPAL	
		do {
			ee.imprimirMenu();
			opcioMP = ee.llegirEnter();
			
			switch (opcioMP) {
				case 1:		configuracio(jugadors, equips, objectes);		break;
							
							
				case 2:		// INICIAR EL JOC
							// per a iniciar el joc tenim que tindre al menys dos equips de jugadors ples
					
							// jugadors creats de prova
							Human huma = new Human("Vï¿½ctor", 44, 15, 120);
							Warrior guerrer = new Warrior("guerrer", 23, 60, 56);
							Alien et = new Alien("E.T.", 22, 33, 44);
							Human kaupa = new Human("Kaupa", 0, 100, 6);
							Warrior aniseto = new Warrior("Aniseto", 50, 44, 75);
							Alien galindo = new Alien("Galindo", 12, 66, 77);
							
							
							Team valencia = new Team("Valencieta");
							Team marcianos = new Team("Marcianos");
							
							valencia.add(huma);
							valencia.add(guerrer);
							valencia.add(aniseto);
							
							marcianos.add(et);
							marcianos.add(kaupa);
							marcianos.add(galindo);
							
							equips.add(valencia);
							equips.add(marcianos);
							// equips creats de prova
							
							
							
							int equipMeu = -1;
							int equipRival = -1;
							
							int jugMeu;
							int jugRival;
							
							ArrayList<Player> jugEquipMeu = new ArrayList<Player>();
							ArrayList<Player> jugEquipRival = new ArrayList<Player>();
							
							// mostrem les dades de tots els equips a triar
							if (!equips.isEmpty() && equips.size() > 1) {
								for (int i = 0; i < equips.size(); i++) {
									ee.imprimir((i + 1) + ". " + equips.get(i).dades() + "\n");
								}
								
								// seleccionem el nostre equip
								ee.imprimir("Quin vols que siga el teu equip?\n");
								equipMeu = (ee.llegirEnter() - 1);
								
								int index = 1;
								// tornem a mostrar la informacio per a triar el equip rival
								for (int i = 0; i < equips.size(); i++) {
									if (i == equipMeu) {
										continue;
									} else {
										ee.imprimir(index + ". " + equips.get(i).dades() + "\n");
										index++;
									}
									
								}
								// comprovarem que l'equip rival no siga el mateix k el equip k em triat
								ee.imprimir("I el equip rival?\n");
								
								equipRival = (ee.llegirEnter()) - 1;
								
								if (equipMeu <= equipRival) {
									equipRival++;
								}
								
								
								ee.imprimir("Equip meu: " + equips.get(equipMeu).dades() + "\n");
								ee.imprimir("Equip rival: " + equips.get(equipRival).dades() + "\n");
								
								jugEquipMeu = equips.get(equipMeu).getMembers();
								jugEquipRival = equips.get(equipRival).getMembers();
								
								ee.imprimir("\nVA A COMENSAR LA BATALLA!!\n");
								
								ee.imprimir("ÉS EL TEU TORN DEL TEU EQUIP\n");
								for (int i = 0; i < jugEquipMeu.size(); i++) {
									ee.imprimir((i + 1) + ". " + jugEquipMeu.get(i).dades() + "\n");
								}
								ee.imprimir("Amb quin jugador vols atacar?");
								jugMeu = ee.llegirEnter();
								
								for (int i = 0; i < jugEquipRival.size(); i++) {
									ee.imprimir((i + 1) + ". " + jugEquipRival.get(i).dades() + "\n");
								}
								ee.imprimir("A quin jugador vols atacar?");
								jugRival = ee.llegirEnter();
								
								jugEquipMeu.get(jugMeu - 1).atac(jugEquipRival.get(jugRival - 1));
								
								ee.imprimir("RESULTAT DE L'ATAC\n");
								ee.imprimir("Equip meu: " + equips.get(equipMeu).dades() + "\n");
								ee.imprimir("Equip rival: " + equips.get(equipRival).dades() + "\n");
								
								ee.llegirEnter();
								
								ee.imprimir("TORN DEL EQUIP RIVAL\n");
								
								// fer que el rival ataque al teu jugador que tinga menys vida, 
								// sempre i quan tinga el poder suficient per a llevar-li vida
								
							} else {
								ee.imprimir("Per a comensar a jugar necessites al menys dos equips amb jugadors\n");
							}
							ee.imprimir("joc\n");	break;
							
							// cada torn atacara un jugador de distint equip pero aquests atacaran en un ordre aleatori
							
							// nosaltres triarem a qui volem atacar
						
							
				case 3: 	// EIXIR DEL PROGRAMA
							eixir = true;			break;
				
				default:	ee.imprimir("Introdueix un número vàlid(Del 1 al 3)\n");
							
							break;
			}
		} while (!eixir);
		ee.imprimir("GAME OVER\n");
	}
	
	// FUNCIONS GESTIO JUGADORS
	public static void crearJugador(ArrayList<Player> jugadors) {
		int tipusJ = -1;
		String nomJ = "";
		int pA = 0;
		int pD = 0;
		int pV = 100;
		
		do {
			ee.imprimir("//======CREAR JUGADOR=======//\n");
			ee.imprimir("De que tipus serà el jugador?\n");
			ee.imprimir("1. Human, 2. Guerrer, 3. Alien\t\t4. Cancelar\n");
			tipusJ = ee.llegirEnter();
			
			if (tipusJ < 1 || tipusJ > 4) ee.imprimir("Introdueix una clase vàlida (1 al 4)\n");
		} while (tipusJ < 1 || tipusJ > 4);

		if (tipusJ != 4) {
			ee.imprimir("Introdueix el nom del jugador:\n");
			nomJ = ee.llegirCadena();
			
			pA = ee.aleatorio(0, 100);
			pD = 100 - pA;
		}
		
		switch (tipusJ) {
			case 1:		Human huma = new Human (nomJ, pA, pD, pV);
						jugadors.add(huma);
						break;
						
			case 2:		Warrior guerrer = new Warrior (nomJ, pA, pD, pV);
						jugadors.add(guerrer);
						break;
						
			case 3:		Alien alien = new Alien (nomJ, pA, pD, pV);
						jugadors.add(alien);
						break;
						
			case 4:		
		}
	}
	
	public static void mostrarJugadors (ArrayList<Player> jugadors) {
		if (!jugadors.isEmpty()) {
			for (int i = 0; i < jugadors.size(); i++) {
				ee.imprimir(jugadors.get(i).dades() + "\n");
			}
		}  else {
			ee.imprimir("Encara no has introduit cap jugador\n");
		}
	}
	
	public static void esborrarJugadors (ArrayList<Player> jugadors, ArrayList<Team> equips) {
		int borraJ = -1;
		
		if (!jugadors.isEmpty()) {
			do {
				for (int i = 0; i < jugadors.size(); i++) {
					ee.imprimir((i + 1) + ". " + jugadors.get(i).dades() + "\n");
				}
				
				ee.imprimir("Quin jugador vols borrar?\n");
				borraJ = ee.llegirEnter();
			} while (borraJ < 1 || borraJ > jugadors.size());
			
			for (int i = 0; i < equips.size(); i++) {
				equips.get(i).remove(jugadors.get(borraJ - 1));
			}
			
			jugadors.remove(borraJ - 1);
		} else {
			ee.imprimir("Encara no has introduit cap jugador\n");
		}
	}
	
	public static void assignarJugadorAlEquip (ArrayList<Player> jugadors, ArrayList<Team> equips) {
		int eleccioJ1 = -1;
		int eleccioJ2 = -1;
		
		if (!jugadors.isEmpty() && !equips.isEmpty()) {
			for (int i = 0; i < jugadors.size(); i++) {
				ee.imprimir((i + 1) + ". " + jugadors.get(i).dades() + "\n");
			}
			do {
				ee.imprimir("Quin jugador vols assignar al equip?\n");
				eleccioJ1 = ee.llegirEnter();
			} while (eleccioJ1 < 1 || eleccioJ1 > jugadors.size());
			
			for (int i = 0; i < equips.size(); i++) {
				ee.imprimir((i + 1) + ". " + equips.get(i).dades() + "\n");
			}
			do {
				ee.imprimir("A quin equip el vols assignar?\n");
				eleccioJ2 = ee.llegirEnter();
			} while (eleccioJ2 < 1 || eleccioJ2 > equips.size());
			
			jugadors.get(eleccioJ1 - 1).add(equips.get(eleccioJ2 - 1)); 
		} else {
			ee.imprimir("Encara no has introduit cap jugador o equip\n");
		}
	}
	
	public static void assignarObjecteAJugador (ArrayList<Player> jugadors, ArrayList<Item> objectes) {
		int eleccioJ1 = -1;
		int eleccioJ2 = -1;

		if (!jugadors.isEmpty()) {
			if (!objectes.isEmpty()) {
				for (int i = 0; i < objectes.size(); i++) {
					ee.imprimir((i + 1) + ". " + objectes.get(i).dades() + "\n");
				}
				do {
					ee.imprimir("Quin objecte vols assignar?\n");
					eleccioJ1 = ee.llegirEnter();
				} while (eleccioJ1 < 1 || eleccioJ1 > objectes.size());
		
				for (int i = 0; i < jugadors.size(); i++) {
					ee.imprimir((i + 1) + ". " + jugadors.get(i).dades() + "\n");
				}
				do {
					ee.imprimir("A quin jugador?\n");
					eleccioJ2 = ee.llegirEnter();
				} while (eleccioJ2 < 1 || eleccioJ2 > jugadors.size());
				jugadors.get(eleccioJ2 - 1).add(objectes.get(eleccioJ1 - 1));
				objectes.remove(eleccioJ1 - 1);
			} else {
				ee.imprimir("Encara no has introduit cap objecte\n");
			}	
		} else {
			if (objectes.isEmpty()) {
				ee.imprimir("Encara no has introduit cap objecte i cap jugador\n");
			} else {
				ee.imprimir("Encara no has introduit cap jugador\n");
			}
		}
	}
	
	// FUNCIONS GESTIO EQUIPS
	public static void crearEquip (ArrayList<Team> equips) {
		String nomE = "";
		
		ee.imprimir("//=======CREAR EQUIP=======//\n");
		ee.imprimir("Introdueix el nom del nou equip:\n");
		nomE = ee.llegirCadena();
		
		Team team = new Team (nomE);
		equips.add(team);
	}
	
	public static void mostrarEquips (ArrayList<Team> equips) {
		if (!equips.isEmpty()) {
			for (int i = 0; i < equips.size(); i++) {
				ee.imprimir(equips.get(i).dades() + "\n");
			}
		} else {
			ee.imprimir("Encara no has introduit cap equip\n");
		}
	}
	
	public static void esborrarEquip (ArrayList<Team> equips, ArrayList<Player> jugadors) {
		int borraE = -1;
		
		if (!equips.isEmpty()) {
			do {
				for (int i = 0; i < equips.size(); i++) {
					ee.imprimir((i + 1) + ". " + equips.get(i).dades() + "\n");
				}
				
				ee.imprimir("Quin equip vols borrar?\n");
				borraE = ee.llegirEnter();
			} while (borraE < 1 || borraE > equips.size());
			// metode valid per a borrar els jugadors del equip
			for (int i = 0; i < jugadors.size(); i++) {
				jugadors.get(i).remove(equips.get(borraE - 1));
			}
			// metode per a borrar el equip del array
			equips.remove(borraE - 1);
		} else {
			ee.imprimir("Encara no has introduit cap equip\n");
		}
	}
	
	public static void assignarEquipAlJugador (ArrayList<Team> equips, ArrayList<Player> jugadors) {
		int eleccioJ1 = -1;
		int eleccioJ2 = -1;
		
		if (!jugadors.isEmpty() && !equips.isEmpty()) {
			for (int i = 0; i < equips.size(); i++) {
				ee.imprimir((i + 1) + ". " + equips.get(i).dades() + "\n");
			}
			do {
				ee.imprimir("Quin equip li vols assignar al jugador?\n");
				eleccioJ1 = ee.llegirEnter();
			} while (eleccioJ1 < 1 || eleccioJ1 > equips.size());
			
			for (int i = 0; i < jugadors.size(); i++) {
				ee.imprimir((i + 1) + ". " + jugadors.get(i).dades() + "\n");
			}
			do {
				ee.imprimir("A quin jugador?\n");
				eleccioJ2 = ee.llegirEnter();
			} while (eleccioJ2 < 1 || eleccioJ2 > jugadors.size());
			
			equips.get(eleccioJ1 - 1).add(jugadors.get(eleccioJ2 - 1)); 
		} else {
			ee.imprimir("Encara no has introduit cap jugador o equip\n");
		}
	}
	
	// FUNCIONS GESTIO OBJECTES
	public static void crearObjecte (ArrayList<Item> objectes) {
		String nomO = "";
		int bonAtac = 0;
		int bonDefensa = 0;
		
		ee.imprimir("Introdueix el nom del objecte:\n");
		nomO = ee.llegirCadena();

		ee.imprimir("Quina vols que siga la bonificació del atac?\n");
		bonAtac = ee.llegirEnter();
		
		ee.imprimir("Quina vols que siga la bonificació de la defensa?\n");
		bonDefensa = ee.llegirEnter();
		
		Item item = new Item(nomO, bonAtac, bonDefensa);
		objectes.add(item);
	}
	
	public static void mostrarObjectes (ArrayList<Item> objectes) {
		if (!objectes.isEmpty()) {
			for (int i = 0; i < objectes.size(); i++) {
				ee.imprimir(objectes.get(i).dades() + "\n");
			}
		}  else {
			ee.imprimir("Encara no has introduit cap objecte\n");
		}
	}
	
	public static void dessasignarObjecteAlJugador (ArrayList<Item> objectes, ArrayList<Player> jugadors) {
		int eleccioJ1 = -1;
		int borraO = -1;
		
		if (!jugadors.isEmpty()) {
			do {
				for (int i = 0; i < jugadors.size(); i++) {
					ee.imprimir((i + 1) + ". " + jugadors.get(i).dades() + "\n");
				}
				
				ee.imprimir("A quin jugador li vols desassignar el objecte?\n");		
				eleccioJ1 = ee.llegirEnter();
			} while ((eleccioJ1 < 1) || eleccioJ1 > jugadors.size());
			
			if (!jugadors.get(eleccioJ1 - 1).items.isEmpty()) {
			do {	
				ee.imprimir(jugadors.get(eleccioJ1 - 1).objJugador());
				
				ee.imprimir("Quin objecte li vols borrar?\n");
				borraO = ee.llegirEnter();
			} while (borraO < 1 || borraO > jugadors.get(eleccioJ1 - 1).items.size());
			
			objectes.add(jugadors.get(eleccioJ1 - 1).items.get(borraO - 1));
			jugadors.get(eleccioJ1 - 1).remove(jugadors.get(eleccioJ1 - 1).items.get(borraO - 1));
			} else {
				ee.imprimir("Aquest jugador no te cap objecte assignat\n");
			}
//			
		} else {
			ee.imprimir("Encara no has introduit cap jugador\n");
		}
	}
	
	public static void assignarObjecteAlJugador (ArrayList<Item> objectes, ArrayList<Player> jugadors) {
		int eleccioJ1 = -1;
		int eleccioJ2 = -1;
		
		if (!jugadors.isEmpty()) {
			if (!objectes.isEmpty()) {
				for (int i = 0; i < objectes.size(); i++) {
					ee.imprimir((i + 1) + ". " + objectes.get(i).dades() + "\n");
				}
				do {
					ee.imprimir("Quin objecte vols assignar?\n");
					eleccioJ1 = ee.llegirEnter();
				} while (eleccioJ1 < 1 || eleccioJ1 > objectes.size());
		
				for (int i = 0; i < jugadors.size(); i++) {
					ee.imprimir((i + 1) + ". " + jugadors.get(i).dades() + "\n");
				}
				do {
					ee.imprimir("A quin jugador?\n");
					eleccioJ2 = ee.llegirEnter();
				} while (eleccioJ2 < 1 || eleccioJ2 > jugadors.size());
				jugadors.get(eleccioJ2 - 1).add(objectes.get(eleccioJ1 - 1));
				objectes.remove(eleccioJ1 - 1);
			} else {
				ee.imprimir("Encara no has introduit cap objecte\n");
			}	
		} else {
			if (objectes.isEmpty()) {
				ee.imprimir("Encara no has introduit cap objecte i cap jugador\n");
			} else {
				ee.imprimir("Encara no has introduit cap jugador\n");
			}
		}
	}
	
	public static void esborrarObjectesDisponibles (ArrayList<Item> objectes) {
		int eleccioJ1 = -1;
		
		if(!objectes.isEmpty()) {
			do {
			for (int i = 0; i < objectes.size(); i++) {
				ee.imprimir((i + 1) + ". " + objectes.get(i).dades() + "\n");
			}
			ee.imprimir("Quin objecte vols esborrar?\n");
			eleccioJ1 = ee.llegirEnter();
			} while (eleccioJ1 < 1 || eleccioJ1 > objectes.size());
			
			objectes.remove(eleccioJ1 - 1);
		} else {
			ee.imprimir("No hi ha ningun objecte disponible per a esborrar\n");
		}
	}
	
	// FUNCIONS CONFIGURACIÓ
	public static void gestioJugadors (ArrayList<Player> jugadors, ArrayList<Team> equips, ArrayList<Item> objectes) {
		boolean eixirJ = false;
		
		do {
			ee.imprimirJugadors();
			int opcioJugadors = ee.llegirEnter();
			
			
			
			switch (opcioJugadors) {
							
				case 1:		crearJugador(jugadors);					break;
							
				case 2:		mostrarJugadors(jugadors);				break;
							
				case 3:		esborrarJugadors(jugadors, equips);		break;
							
				case 4:		assignarJugadorAlEquip(jugadors, equips);		break;
					
				case 5:		assignarObjecteAJugador(jugadors, objectes);	break;
									
				case 6:		// TORNAR
							eixirJ = true;
							break;
							
				default:	ee.imprimir("Introdueix un número vàlid(Del 1 al 6)\n");
				
							break;
			}
		} while (!eixirJ);	
	}
	
	public static void gestioEquips (ArrayList<Team> equips, ArrayList<Player> jugadors) {
		boolean eixirE = false;
		int opcioEquips;
		
		do {
			ee.imprimirEquips();
			opcioEquips = ee.llegirEnter();
			
			switch (opcioEquips) {
				case 1:		crearEquip(equips);		break;
							
				case 2:		mostrarEquips(equips);	break;
							
				case 3:		esborrarEquip(equips, jugadors);			break;
							
				case 4:		assignarEquipAlJugador(equips, jugadors);	break;
				
				case 5:		// TORNAR
							eixirE = true;
							break;
							
				default:	ee.imprimir("Introdueix un número vàlid(Del 1 al 5)\n");		
			}
		} while (!eixirE);
	}
	
	public static void gestioObjectes (ArrayList<Item> objectes, ArrayList<Player> jugadors) {
		boolean eixirO = false;
		int opcioObjectes;
		
		do {
			ee.imprimirObjectes();
			opcioObjectes = ee.llegirEnter();
			
			switch (opcioObjectes) {
				case 1:		crearObjecte(objectes);			break;
							
				case 2:		mostrarObjectes(objectes);		break;
							
				case 3:		dessasignarObjecteAlJugador(objectes, jugadors);		break;
							
				case 4:		assignarObjecteAlJugador(objectes, jugadors);			break;
							
				case 5:		esborrarObjectesDisponibles(objectes);					break;
							
				case 6:		// TORNAR
							eixirO = true;					break;
							
				default:	ee.imprimir("Introdueix un número vàlid(Del 1 al 6)\n");
								
							break;
			}
		} while (!eixirO);
	}
	
	// FUNCIONS MENU PRINCIPAL
	public static void configuracio (ArrayList<Player> jugadors, ArrayList<Team> equips, ArrayList<Item> objectes) {
		boolean eixirC = false;
		int opcioConf;
		
		do {
			
			ee.imprimirConf();
			opcioConf = ee.llegirEnter();
			
			
			
			switch (opcioConf) {
				
				case 1:		gestioJugadors(jugadors, equips, objectes);			break;
				
				case 2:		gestioEquips(equips, jugadors);						break;
							
				case 3:		gestioObjectes(objectes, jugadors);					break;
							
				case 4:		// tornar al menu principal
							eixirC = true;
							break;
							
				default:	ee.imprimir("Introdueix un número vàlid(Del 1 al 4)\n");
						
							break;
			}
		} while (!eixirC);
	}
}
