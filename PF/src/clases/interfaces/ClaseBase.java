package clases.interfaces;
import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import recursos.Recursos;

public interface ClaseBase {
	public POSIBLES_CLASES getEnumDeClase ();
	public ArrayList<Habilidad> getClassAbilities ();
	public Recursos getClassResources ();
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase ();
}
