package clases;
import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.RazaBase.POSIBLES_CLASES;
import recursos.Recursos;

public abstract class ClaseBase {
	public abstract POSIBLES_CLASES getEnumDeClase ();
	public abstract ArrayList<Habilidad> getClassAbilities ();
	public abstract Recursos getClassResources ();
	public abstract AtributeMultipliers getMultiplicadorDeAtributosDeClase ();
}
