package ee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import joc.Team;

public class ee {
	public static void imprimir (String frase) {
		System.out.print(frase);
	}
	
	public static void imprimirMenu() {
		imprimir("JOC DE ROL\n");
		imprimir("==========\n");
		imprimir("1. Configuració\n");
		imprimir("2. Iniciar el joc\n");
		imprimir("3. Eixir\n");
	}
	
	public static void imprimirConf() {
		imprimir("CONFIGURACIO DEL JOC\n");
		imprimir("====================\n");
		imprimir("1. Gestió jugadors\n");
		imprimir("2. Gestió equips\n");
		imprimir("3. Gestió objectes\n");
		imprimir("4. Tornar\n");
	}
	
	public static void imprimirJugadors() {
		imprimir("JUGADORS\n");
		imprimir("========\n");
		imprimir("1. Crear jugador\n");
		imprimir("2. Mostrar jugadors\n");
		imprimir("3. Esborrar jugador\n");
		imprimir("4. Assignar jugador a equip\n");
		imprimir("5. Assignar objecte a jugador\n");
		imprimir("6. Tornar\n");
	}
	
	public static void imprimirEquips() {
		imprimir("EQUIPS\n");
		imprimir("======\n");
		imprimir("1. Crear equip\n");
		imprimir("2. Mostrar equips\n");
		imprimir("3. Esborrar equip\n");
		imprimir("4. Assignar equip a jugador\n");
		imprimir("5. Tornar\n");
	}
	
	public static void imprimirObjectes() {
		imprimir("OBJECTES\n");
		imprimir("========\n");
		imprimir("1. Crear objecte\n");
		imprimir("2. Mostrar objectes disponibles\n");
		imprimir("3. Desassignar objecte del jugador\n");
		imprimir("4. Assignar objecte a jugador\n");
		imprimir("5. Esborrar objectes disponibles\n");
		imprimir("6. Tornar\n");
	}
	
	public static void imprimirJugadorsEquip(Team t) {
		
	}
	
	public static int aleatorio(int max,int min){
		return (int)(Math.random()*(max-min)) + min;		
	}
	
	public static int llegirEnter(){
	    BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
	    String linia="";
	    int n=0;
	    boolean error = false;
	    do
	        try{
	            error = false;
	            linia=teclat.readLine();
	            n=Integer.parseInt(linia);
	        }
	        catch(Exception e){
	            System.out.println("Error d'entrada de dades "+e.getMessage());
	            System.out.println("Dóna'm un número enter:");
	            error = true;
	        }
	    while (error);
	    return n;
	}

	public static String llegirCadena(){
	    BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
	    String linia="";
	    //System.o=0;ut.print("Dï¿½na'm una cadena: ");
	    try{
	        linia=teclat.readLine();
	    }
	    catch(IOException e){
	        System.out.print("Error d'entrada de dades "+e.getMessage());
	    }
	    return linia;
	}
	
	public static float llegirReal(){
	    BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
	    String linia="";
	    float n=0;
	    boolean error = false;
	    do
	        try{
	            error = false;
	            linia=teclat.readLine();
	            n=Float.parseFloat(linia);
	        }
	        catch(Exception e){
	            System.out.println("Error d'entrada de dades "+e.getMessage());
	            System.out.println("Dóna'm un número real:");
	            error = true;
	        }
	    while (error);
	    return n;
	}
	
	public static char llegirCaracter(){
	    char lletra='0';
	    try{
	        lletra=(char) System.in.read(); // consumix 1 lletra
	        System.in.read();        // consumix altre carï¿½cter (per a l'INTRO)
	    }
	    catch(IOException e){
	       System.out.print("Error d'entrada de dades "+e.getMessage()); 
	    }
	    return lletra;
	}

	public static void llegirVectorEnters(int v[]){
	    for (int i=0; i<v.length; i++){
	        System.out.print("v["+i+"]=");
	        v[i]=llegirEnter();
	    } 
	}

	public static void llegirVectorReals(float v[]){
	    for (int i=0; i<v.length; i++){
	        System.out.print("v["+i+"]=");
	        v[i]=llegirReal();
	    } 
	}
}
