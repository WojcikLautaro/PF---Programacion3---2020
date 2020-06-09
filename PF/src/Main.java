import java.util.ArrayList;

import clases.Brujo;
import clases.Guerrero;
import clases.Paladin;
import razas.ClasesConcretas.Humano;
import razas.ClasesConcretas.NoMuerto;
import razas.ClasesConcretas.Orco;
import razas.ClasesConcretas.Trol;
import razas.ClasesNoConcretas.RazaBase;

public class Main {
	public static void main(String[] args) {
		ArrayList<RazaBase<?>> personajes = new ArrayList <> ();
		personajes.add(new Orco		<> ("Guerrero"	, new Guerrero()));
		personajes.add(new Trol		<> ("Mago"		, new Guerrero()));
		personajes.add(new NoMuerto	<> ("Luis"		, new Brujo()));
		personajes.add(new Humano	<> ("Sancho"	, new Paladin()));

		for (RazaBase<?> aux : personajes) {
			System.out.println(aux);
		}
		
		/* Realizar la implementacion de una clase, que administre un conjunto de personajes y que sea serializable.
		 * El sistema tiene que ser tal que haya relacionado un string unico a un conjunto de personajes
		 */
		
		/* Cambier el contructor de personajes tal que uno requiera el nombre del personaje y otro el nombre y el nivel
		 */
	}
  
	// PROBANDO MODIFICACIÓN DE PULL Y PUSH EN GIT.
	// Probando modif con new branch.
	
	// Probando modif con new branch.
	
}
