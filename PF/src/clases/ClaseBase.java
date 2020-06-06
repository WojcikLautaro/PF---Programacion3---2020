package clases;
import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.RazaBase.POSIBLES_CLASES;
import recursos.MaximosRecursos;
import recursos.Recursos;

public abstract class ClaseBase {
	private static final String NOMBRE_SIN_CLASE = "No Class";
	
	public static String getNombreDeClase () {
		return NOMBRE_SIN_CLASE;
	}
	
	public static POSIBLES_CLASES getEnumDeClase () {
		return POSIBLES_CLASES.SIN_CLASE;
	}
	
	public static ArrayList<Habilidad> getClassAbilities () {
		return new ArrayList <> ();
	}
	
	public static Recursos getClassResources () {
		return new Recursos(new MaximosRecursos(100, 100, 0, 0));
	}
	
	public static AtributeMultipliers getMultiplicadorDeAtributosDeClase () {
		return new AtributeMultipliers(1,1,1,1,1,1,1,1);
	}
}
