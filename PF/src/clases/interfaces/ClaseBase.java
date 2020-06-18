package clases.interfaces;

import java.util.ArrayList;

import atributosDeRazaYClase.AtributeMultipliers;
import clases.habilidades.Habilidad;
import clases.recursos.Recursos;
import razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES;

public interface ClaseBase {
	public ArrayList<Habilidad> getClassAbilities();

	public Recursos getClassResources();

	public POSIBLES_CLASES getEnumDeClase();

	public AtributeMultipliers getMultiplicadorDeAtributosDeClase();
}
