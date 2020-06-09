package clases;
import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import razas.InterfasesClasesNoConcretas.HerenciaParaTodasLasRazas;
import recursos.Recursos;

public abstract class ClaseBase implements HerenciaParaTodasLasRazas{
	public abstract POSIBLES_CLASES getEnumDeClase ();
	public abstract ArrayList<Habilidad> getClassAbilities ();
	public abstract Recursos getClassResources ();
	public abstract AtributeMultipliers getMultiplicadorDeAtributosDeClase ();
}
