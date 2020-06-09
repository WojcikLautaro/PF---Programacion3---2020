import java.util.ArrayList;

import clases.Guerrero;
import clases.Mago;
import razas.Orco;
import razas.RazaBase;
import razas.Trol;

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
}
