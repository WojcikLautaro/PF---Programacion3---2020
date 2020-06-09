import java.util.ArrayList;

import clases.Guerrero;
import clases.Mago;
import razas.RazaBase;
import razas.ClasesConcretas.Orco;
import razas.ClasesConcretas.Trol;

public class Main {
	public static void main(String[] args) {
		ArrayList<RazaBase<?>> personajes = new ArrayList <> ();
		personajes.add(new Orco<> ("Fernando", new Guerrero()));
		personajes.add(new Trol<> ("Mago", new Mago()));

		System.out.println(personajes.get(0));
		System.out.println(personajes.get(1));
	}
  
	// PROBANDO MODIFICACIÓN DE PULL Y PUSH EN GIT.
	// Probando modif con new branch.
	
	/*
	 * Orco -> Guerrero, Paladin, Picaro, Cazador
	 * Trol -> Guerrero, Brujo
	 * Goblin -> Picaro, Guerrero, Brujo
	 * No muerto -> Brujo, Sacerdote, Mago
	 * 
	 * Humano -> Guerrero, Paladin, Picaro, Cazador
	 * Elfo -> Druida, Brujo, Sacerdote, Mago
	 * Enano -> Picaro, Guerrero, Paladin
	 * Draenel -> Brujo, Sacerdote, Mago
	 */
}
