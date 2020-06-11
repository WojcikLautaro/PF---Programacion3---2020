import java.io.IOException;
import java.util.ArrayList;

import administradorDePersonajes.AdministradorDePersonajes;
import clases.Brujo;
import clases.Guerrero;
import clases.Mago;
import razas.ClasesConcretas.Humano;
import razas.ClasesConcretas.NoMuerto;
import razas.ClasesConcretas.Orco;
import razas.ClasesConcretas.Trol;
import razas.ClasesNoConcretas.RazaBase;

public class Main {
	public static void main(String[] args) {
	ArrayList<RazaBase<?>> personajes = new ArrayList <> ();
		
		try {	
			personajes.add(RazaBase.getNuevoPersonaje(RazaBase.POSIBLES_RAZAS.HUMANO, RazaBase.POSIBLES_CLASES.MAGO, "Flor"));
			personajes.add(new Orco		<> ("Guerrero"	, new Guerrero()));
			personajes.add(new Trol		<> ("Mago"		, new Guerrero()));
			personajes.add(new NoMuerto	<> ("Luis"		, new Brujo()));
			personajes.add(new Humano	<> ("Sancho"	, new Mago()));
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			/*
			for (RazaBase<?> aux : personajes)
				System.out.println(aux);
			*/
		}
		
		/* Realizar la implementacion de una clase, que administre un conjunto de personajes y que sea serializable.
		 * El sistema tiene que ser tal que haya relacionado un string unico a un conjunto de personajes
		 */

		AdministradorDePersonajes admin = AdministradorDePersonajes.cargar("file.dat");
		admin.personajesPorUsuarios.put("usuarioA", personajes);
		admin.personajesPorUsuarios.put("usuarioB", new ArrayList <> ());
		admin.personajesPorUsuarios.put("usuarioC", new ArrayList <> ());
		admin.personajesPorUsuarios.put("usuarioD", new ArrayList <> ());
		 
		System.out.println(admin.personajesPorUsuarios);
		
		try {
			admin.guardar("file.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
