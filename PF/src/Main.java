import java.util.ArrayList;

import administradorDePersonajes.AdministradorDePersonajes;
import administradorDePersonajes.excepciones.PersonajeOcupadoException;
import administradorDePersonajes.excepciones.ProblemaAlGuardarElArchivoException;
import administradorDePersonajes.excepciones.UsuarioNoRegistradoException;
import razas.clasesNoConcretas.RazaBase;
import razas.excepciones.ClaseNoAceptadaParaRazaException;

public class Main {
	public static void main(String[] args) {
		ArrayList<RazaBase<?>> personajes = new ArrayList<>();
		try {
			personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.HUMANO, RazaBase.POSIBLES_CLASES.MAGO,
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

		catch (ClaseNoAceptadaParaRazaException e) {
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

		catch (UsuarioNoRegistradoException e) {
			e.printStackTrace();
		}

		for (RazaBase<?> aux : personajes) {
			try {
				admin.aniadirPersonajeAUsuario("usuarioA", aux);
			}

			catch (PersonajeOcupadoException e) {
				e.printStackTrace();
			} 
			
			catch (UsuarioNoRegistradoException e) {
				e.printStackTrace();
			}
		}

		System.out.println(admin.toString());

		try {
			admin.guardar("file.dat");
		}

		catch (ProblemaAlGuardarElArchivoException e) {
			e.printStackTrace();
		}
	}
}
