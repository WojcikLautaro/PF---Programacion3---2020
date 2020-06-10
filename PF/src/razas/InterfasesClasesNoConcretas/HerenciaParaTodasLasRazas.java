package razas.InterfasesClasesNoConcretas;

import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import recursos.Recursos;

public interface HerenciaParaTodasLasRazas {
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase();
	public Recursos getClassResources();
	public ArrayList <Habilidad> getClassAbilities();
	public POSIBLES_CLASES getEnumDeClase();
}
