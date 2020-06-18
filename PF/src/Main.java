import java.io.IOException;
import java.util.ArrayList;

import administradorDePersonajes.AdministradorDePersonajes;
import razas.clasesNoConcretas.RazaBase;

public class Main {
	public static void main(String[] args) {
		ArrayList<RazaBase<?>> personajes = new ArrayList<>();
		try {
			personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.HUMANO, RazaBase.POSIBLES_CLASES.PALADIN,
					"Flor"));
			// personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.ORCO,
			// RazaBase.POSIBLES_CLASES.GUERRERO, "Guerrero"));
			// personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.TROL,
			// RazaBase.POSIBLES_CLASES.GUERRERO, "Mago"));
			// personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.NOMUERTO,
			// RazaBase.POSIBLES_CLASES.BRUJO, "Luis"));
			// personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.HUMANO,
			// RazaBase.POSIBLES_CLASES.PALADIN, "Sancho"));
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Realizar la implementacion de una clase, que administre un conjunto de
		 * personajes y que sea serializable. El sistema tiene que ser tal que haya
		 * relacionado un string unico a un conjunto de personajes
		 */

		AdministradorDePersonajes admin = AdministradorDePersonajes.cargar("file.dat");
		admin.aniadirUsuario("usuarioA");
		admin.aniadirUsuario("usuarioB");
		admin.aniadirUsuario("usuarioA");

		try {
			System.out.println("Result: " + admin.getPersonajeDeUsuario("usuarioB", "Flor"));
		} 
		
		catch (Exception e2) {
			e2.printStackTrace();
		}

		for (RazaBase<?> aux : personajes) {
			try {
				admin.aniadirPersonajeAUsuario("usuarioA", aux);
			} 
			
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		System.out.println(admin.toString());

		try {
			admin.guardar("file.dat");
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
