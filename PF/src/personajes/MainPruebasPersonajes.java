package personajes;

import personajes.administradorDePersonajes.AdministradorDePersonajes;
import personajes.administradorDePersonajes.excepciones.PersonajeOcupadoException;
import personajes.administradorUsuariosParaPersonajes.AdministradorDeUsuariosParaPersonajes;
import personajes.administradorUsuariosParaPersonajes.interfaces.ProblemaAlGuardarElArchivoException;
import personajes.administradorUsuariosParaPersonajes.interfaces.UsuarioNoRegistradoException;
import personajes.razas.clasesNoConcretas.RazaBase;
import personajes.razas.excepciones.ClaseNoAceptadaParaRazaException;

public class MainPruebasPersonajes {
	public static void main(String[] args) {
		AdministradorDePersonajes personajes = new AdministradorDePersonajes();
		try {
			personajes.aniadirPersonaje(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.HUMANO,
			RazaBase.POSIBLES_CLASES.PALADIN, "Flor"));
			personajes.aniadirPersonaje(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.ORCO,
			RazaBase.POSIBLES_CLASES.GUERRERO, "Guerrero"));
			personajes.aniadirPersonaje(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.TROL,
			RazaBase.POSIBLES_CLASES.GUERRERO, "Mago"));
			personajes.aniadirPersonaje(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.NOMUERTO,
			RazaBase.POSIBLES_CLASES.BRUJO, "Luis"));
			personajes.aniadirPersonaje(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.HUMANO,
			RazaBase.POSIBLES_CLASES.PALADIN, "Sancho"));
		}

		catch (ClaseNoAceptadaParaRazaException | PersonajeOcupadoException e) {
			e.printStackTrace();
		}
		
		AdministradorDeUsuariosParaPersonajes admin = AdministradorDeUsuariosParaPersonajes.cargar("file.dat");
		System.out.println(admin.toString());
		/*admin.aniadirUsuario("usuarioA");
		admin.aniadirUsuario("usuarioB");
		admin.aniadirUsuario("usuarioC");

		AdministradorDePersonajes pjs;

		try {
			pjs = admin.getAdministradorDePersonajesDeUsuario("usuarioA");
		}

		catch (UsuarioNoRegistradoException e) {
			pjs = new AdministradorDePersonajes();
			e.printStackTrace();
		}

		for (RazaBase<?> aux : personajes.getPersonajes()) {
			try {
				pjs.aniadirPersonaje(aux);
			}

			catch (PersonajeOcupadoException e) {
				e.printStackTrace();
			}
		}*/

		System.out.println(admin.toString());

		try {
			admin.guardar("file.dat");
		}

		catch (ProblemaAlGuardarElArchivoException e) {
			e.printStackTrace();
		}
	}
}
